package stepdefinitions.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class DatabaseRecord {
    private Connection connection;

    @When("I make connection to the database")
    public void connectToDatabase() throws Exception {
        // Connect to the SQLite database
        String url = "jdbc:sqlite:d:/programy/sqlite-tools-win-x64-3460000/customer.db";
        connection = DriverManager.getConnection(url);
    }


    @Then("I verify that in Customer table there is {int} record with conditions")
    public void verifyCustomerRecord(int expectedCount, io.cucumber.datatable.DataTable dataTable) throws Exception {
        // Get the conditions from the data table
        List<Map<String, String>> conditions = dataTable.asMaps(String.class, String.class);


        StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM Customer WHERE ");

        for (Map<String, String> condition : conditions) {
            for (String k : condition.keySet())
                System.out.println(k + " " + condition.get(k));
               // query.append(k + "AND ");
               // query.append("AND ");
        }





        System.exit(0);
        // Build the SQL query with placeholders for the conditions

        System.out.println(conditions.size());

        for (int i = 0; i < conditions.size(); i++) {
            java.util.Map<String, String> condition = conditions.get(i);
            int conditionIndex = 0;
            for (java.util.Map.Entry<String, String> entry : condition.entrySet()) {
                query.append(entry.getKey()).append(" = ? ");
                if (conditionIndex < condition.size() - 1) {
                    query.append("AND ");
                }
                conditionIndex++;
            }
            if (i < conditions.size() - 1) {
                query.append("AND ");
            }
        }

        // Prepare the statement
        PreparedStatement preparedStatement = connection.prepareStatement(query.toString());

        // Set the condition values in the prepared statement
        int parameterIndex = 1;
        for (java.util.Map<String, String> condition : conditions) {
            for (java.util.Map.Entry<String, String> entry : condition.entrySet()) {
                preparedStatement.setString(parameterIndex++, entry.getValue());
            }
        }

        // Execute the query and get the result
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int actualCount = resultSet.getInt(1);
            assertEquals(expectedCount, actualCount, "The count of records does not match the expected count.");
        } else {
            throw new AssertionError("Query did not return any results.");
        }
    }

    @AfterClass
    public void tearDown() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCustomerRecord() {
        try {
            // SQL query to fetch the customer record by ID
            String sql = "SELECT * FROM customer WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 1); // Replace with the ID of the customer you want to verify

            ResultSet resultSet = statement.executeQuery();

            // Verify the customer record
            if (resultSet.next()) {
                assertEquals(resultSet.getInt("id"), 1);
                assertEquals(resultSet.getString("firstname"), "Jan");
                assertEquals(resultSet.getString("lastname"), "Kowalski");
                assertEquals(resultSet.getString("email"), "jk@gfx.com");
                assertEquals(resultSet.getString("phoneNumber"), "534-345-234");
                assertEquals(resultSet.getString("dateOfBirth"), "1987-02-21");
                assertEquals(resultSet.getString("gender"), "male");
                assertEquals(resultSet.getString("addressLine"), "Obrońców Helu 2/43");
                assertEquals(resultSet.getString("state"), "Mazowieckie");
                assertEquals(resultSet.getString("zipCode"), "02-495");
                assertEquals(resultSet.getString("city"), "Warszawa");
                assertEquals(resultSet.getString("country"), "Poland");
                assertEquals(resultSet.getString("occupation"), "QA Engineer");
                assertEquals(resultSet.getString("occupationRole"), "Employee");
            } else {
                // Fail the test if the customer record is not found
                assertEquals(resultSet.next(), true, "Customer record not found");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
