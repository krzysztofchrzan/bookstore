package stepdefinitions.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

import static org.testng.Assert.assertEquals;

public class DatabaseRecord {
    private Connection connection;

    @When("I make connection to the database")
    public void connectToDatabase() throws Exception {
        // Connect to the SQLite database
        String url = "jdbc:sqlite:path/to/your/customer.db";
        connection = DriverManager.getConnection(url);
    }
}
