package api;


import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

public class Customer {
    Properties properties = new Properties();
    private String url = null;
    private Response response = null;

    @Before(value = "@API")
    public void setupApi() throws IOException {
        properties = new Properties();
        properties.load(new FileReader("src\\main\\resources\\config.properties"));
        url = properties.getProperty("REST_API_URL") + "customer";
        System.out.println(url);
    }


    @When("I make a POST request to customer")
    public void requestPostToCustomer() {
        // create a request object
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("CDate", "simpleDate");

        // create a request body
        JSONObject requestJSON = new JSONObject();
        try {
            requestJSON
                    .put("name", "Krzysztof")
                    .put("surname", "Chrzan")
                    .put("age", "40");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        request.body(requestJSON.toString());

        // send a request
        response = request.post(url);
        System.out.println(response.body().asString());
        System.out.println("The status received: " + response.statusLine());
    }

    @Then("I verify that response has status {string}")
    public void verifyStatus(String status) {
        int statusInt = Integer.parseInt(status);
        Assert.assertEquals(response.statusCode(), statusInt);
    }

    @When("I make a GET request to customer")
    public void requestGetToCustomer() {
        // create a request object
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("CDate", "simpleDate");

        // create a request body
        JSONObject requestJSON = new JSONObject();
        try {
            requestJSON.put("name", "Krzysztof");
            requestJSON.put("surname", "Chrzan");
            requestJSON.put("age", "40");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        request.body(requestJSON.toString());

        // send a request
        response = request.post("http://localhost:3000/customer");

        // print
        System.out.println(response.body().asString());
        System.out.println("The status received: " + response.statusLine());
    }

}
