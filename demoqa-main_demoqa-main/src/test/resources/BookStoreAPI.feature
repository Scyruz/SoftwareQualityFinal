Feature: Book Store Web API
 
  Scenario: Authorization with valid credentials
    Given an existing user
    When the client calls /Account/v1/Authorized with username 'kikelink' and password 'Admin123!'
    Then the client receives status code of 200
    And the client receives response 'true'

    
