package stepdefinitions.api;

import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.testng.Assert.assertEquals;

public class DatabaseRecord {
    private Connection connection;

    //@BeforeClass
    @When("I make connection to the database")
    public void setUpDatabase() {
        try {
            // Establish a connection to the SQLite database
            connection = DriverManager.getConnection("jdbc:sqlite:path/to/your/customers.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
