Feature: CRUD Operations for Users

  Scenario Outline: Create a new user with different data
    Given the user payload is ready with name "<name>", username "<username>", and email "<email>"
    When I send a POST request to "createUserEndpoint"
    Then the response status code should be 201
    And the response should contain the username "<username>"
    And the response should contain the email "<email>"

    Examples:
      | name         	| username     | email                 |
      | Anuroop Jha   | anuroopjha   | annu@example.com      |
      | Meenu Sharma  | meenu   		 | meenu@example.com     |
      | Shiv Pratap  	| shiv   			 | shiv@example.com      |

  Scenario: Get user details
    When I send a GET request to "getUserEndpoint"
    Then the response status code should be 200

  Scenario: Update a user
    Given the user payload is ready
    When I send a PUT request to "updateUserEndpoint"
    Then the response status code should be 200

  Scenario: Delete a user
    When I send a DELETE request to "deleteUserEndpoint"
    Then the response status code should be 200
    And the response body should be empty