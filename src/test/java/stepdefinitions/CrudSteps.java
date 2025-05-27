package stepdefinitions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.User;
import utils.ApiUtils;
import utils.ConfigReader;

//@Description("Validate the user creation API endpoint.")
@Severity(SeverityLevel.CRITICAL)
@Epic("User Management")
@Feature("User CRUD Operations")
public class CrudSteps {
    private Response response;
    private User user;

    @Given("the user payload is ready with name {string}, username {string}, and email {string}")
    public void the_user_payload_is_ready(String name, String username, String email) {
        user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
    }

    @Given("the user payload is ready")
    public void the_user_payload_is_ready() {
        user = new User();
        user.setName("Updated Name");
        user.setUsername("updateduser");
        user.setEmail("updated@example.com");
    }

    @When("I send a POST request to {string}")
    public void send_post_request(String endpointKey) {
        String endpoint = ConfigReader.getProperty(endpointKey);
        response = ApiUtils.sendPost(endpoint, user);
    }

    @When("I send a PUT request to {string}")
    public void send_put_request(String endpointKey) {
        String endpoint = ConfigReader.getProperty(endpointKey);
        response = ApiUtils.sendPut(endpoint, user);
    }

    @When("I send a GET request to {string}")
    public void send_get_request(String endpointKey) {
        String endpoint = ConfigReader.getProperty(endpointKey);
        response = ApiUtils.sendGet(endpoint);
    }

    @When("I send a DELETE request to {string}")
    public void send_delete_request(String endpointKey) {
        RestAssured.baseURI = ConfigReader.getProperty("baseURI");
        String endpoint = ConfigReader.getProperty(endpointKey);
        response = ApiUtils.sendDelete(endpoint);
    }


    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain the username {string}")
    public void the_response_should_contain_the_user_name(String username) {
        User responseUser = response.as(User.class);
        assertThat(responseUser.getUsername(), equalTo(username));
    }

    @Then("the response should contain the email {string}")
    public void the_response_should_contain_the_email(String email) {
        User responseUser = response.as(User.class);
        assertThat(responseUser.getEmail(), equalTo(email));
    }

    @Then("the response body should be empty")
    public void the_response_body_should_be_empty() {
        assertThat(response.getBody().asString().trim(), equalTo("{}"));
    }
}