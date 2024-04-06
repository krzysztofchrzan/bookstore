package api;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;


public class Customer {
    private String url = null;
    //private DataTable dataTableExpected;
    private Response responsePost = null;

    @Before(value = "@API")
    public void setupApi() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\main\\resources\\config.properties"));
        url = properties.getProperty("REST_API_URL") + "customer";

        // before delete test data
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        Response responseClear = requestSpecification.get(url + "?surname=Chrzan");
        JsonPath jsonPath = responseClear.jsonPath();
        List<String> customers = jsonPath.getList("id");
        customers.forEach(c -> requestSpecification.delete(url + "/" + c));
    }

    @When("I make a POST request to customer service")
    public void requestPostToCustomer(DataTable datatable) {
        List<Map<String, String>> lista = datatable.asMaps(String.class, String.class);
        lista.forEach(map -> requestPostToCustomer(map));
    }

    private void requestPostToCustomer(Map<String, String> map) {
        String name = map.get("name");
        String surname = map.get("surname");
        String age = map.get("age");
        if (Integer.parseInt(age)<0) { throw new IllegalArgumentException("Age cannot be a negative number."); }

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
        responsePost = requestSpecification.get(url + "?" + key + "=" + value);
    }

    @Then("I verify that response has empty list")
    public void responseShouldHaveEmptyList() {
        Assertions.assertEquals("[]",responsePost.getBody().asString());
    }

    @Tag("status check")
    @DisplayName("Displaying name of status method")
    @Then("I verify that response has status {string}")
    public void verifyResponseStatus(String statusExpected) {
        int statusIntExpected = Integer.parseInt(statusExpected);
        Assertions.assertEquals(
            statusIntExpected,
            responsePost.statusCode(),
            "Should return status: " + statusIntExpected + " but it returned: " + responsePost.statusCode()
        );
    }

    @Then("I verify that response has records")
    public void i_verify_that_response_has_records(DataTable dataTable) {
        Map<String, String> map = dataTable.asMaps(String.class, String.class).get(0);
        Assertions.assertAll(
            () -> Assertions.assertEquals(map.get("name"), responsePost.jsonPath().get("name[0]")),
            () -> Assertions.assertEquals(map.get("surname"), responsePost.jsonPath().get("surname[0]")),
            () -> Assertions.assertEquals(map.get("age"), responsePost.jsonPath().get("age[0]"))
        );
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
}
