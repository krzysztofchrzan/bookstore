package api;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;


public class Customer {
    private String url = null;
    private DataTable dataTableExpected;
    private Response responsePost = null;

    @Before(value = "@API")
    public void setupApi() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\main\\resources\\config.properties"));
        url = properties.getProperty("REST_API_URL") + "customer";

        // before delete test data
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        Response response = requestSpecification.get(url + "?surname=Chrzan");
        JsonPath jsonPath = response.jsonPath();
        List<String> customers = jsonPath.getList("id");
        customers.forEach(c -> requestSpecification.delete(url + "/" + c));
    }

    @When("I make a POST request to customer service")
    public void requestPostToCustomer(DataTable datatable) {
        dataTableExpected = datatable;
        List<Map<String, String>> lista = datatable.asMaps(String.class, String.class);
        lista.forEach(map -> performPost(map));
    }

    private void performPost(Map<String, String> map) {
        String name = map.get("name");
        String surname = map.get("surname");
        String age = map.get("age");

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");

        // create a body
        JSONObject requestJSON = new JSONObject();
        try {
            requestJSON
                    .put("name", name)
                    .put("surname", surname)
                    .put("age", age);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        requestSpecification.body(requestJSON.toString());
        // send a POST request
        responsePost = requestSpecification.post(url);
    }

    @When("I make a GET request to customer with key {string} and value {string}")
    public void requestGetToCustomer(String key, String value) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        Response response = requestSpecification.get(url + "?" + key + "=" + value);

        Map<String, String> mapaExpected = dataTableExpected.asMaps(String.class, String.class).get(0);
        Assertions.assertEquals(mapaExpected.get("name"), response.jsonPath().get("name[0]"));
        Assertions.assertEquals(mapaExpected.get("surname"), response.jsonPath().get("surname[0]"));
        Assertions.assertEquals(mapaExpected.get("age"), response.jsonPath().get("age[0]"));
    }

    @When("I make a PUT request to customer")
    public void requestPutToCustomer(DataTable dataTable) {
        List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);
        Map<String, String> map = lista.get(0);
        String name = map.get("Name");
        String surname = map.get("Surname");
        String age = map.get("Age");

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");

        // create a body
        JSONObject requestJSON = new JSONObject();
        try {
            requestJSON
                    .put("name", name)
                    .put("surname", surname)
                    .put("age", age);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        requestSpecification.body(requestJSON.toString());
    }

    @Then("I verify that response has status {string}")
    public void verifyStatus(String statusExpected) {
        int statusExpectedInt = Integer.parseInt(statusExpected);
        Assertions.assertEquals(statusExpectedInt, responsePost.statusCode());
    }
}
