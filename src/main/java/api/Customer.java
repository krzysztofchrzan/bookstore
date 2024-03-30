package api;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

public class Customer {
    Properties properties = new Properties();
    private String url = null;
    private Response response = null;
    private String customerId = null;

    @Before(value = "@API")
    public void setupApi() throws IOException {
        properties = new Properties();properties.load(new FileReader("src\\main\\resources\\config.properties"));
        url = properties.getProperty("REST_API_URL") + "customer";
    }


    @When("I make a POST request to customer")
    public void requestPostToCustomer(DataTable datatable) {
        List<Map<String,String>> lista = datatable.asMaps(String.class,String.class);
        Map<String, String> map = lista.get(0);
        String name = map.get("Name").toString();
        String surname = map.get("Surname").toString();
        String age = map.get("Age").toString();
//        for(Map m : lista){
//            name = m.get("Name").toString();
//            surname = m.get("Surname").toString();
//        }

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.header("CDate", "simpleDate");

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

        // send a request
        response = requestSpecification.post(url);

        customerId = response.jsonPath().get("id").toString();
        System.out.println(customerId);
    }

    @Then("I verify that response has status {string}")
    public void verifyStatus(String status) {
        int statusInt = Integer.parseInt(status);
        System.out.println("The status received: " + response.statusLine());
        Assert.assertEquals(response.statusCode(), statusInt);
    }

    @When("I make a GET request to customer")
    public void requestGetToCustomer() {
        // create a request object
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        response = request.get(url + "?id=" + customerId);
        System.out.println(response.jsonPath().get("[0]").toString());
        Assert.assertEquals(response.jsonPath().get("id[0]").toString(), customerId );
        Assert.assertEquals(response.jsonPath().get("name[0]").toString(), "Jan" );
        Assert.assertEquals(response.jsonPath().get("surname[0]").toString(), "Kovalski" );
    }

    @When("I make a GET request for all customers")
    public void getAllCustomers() {

    }

}
