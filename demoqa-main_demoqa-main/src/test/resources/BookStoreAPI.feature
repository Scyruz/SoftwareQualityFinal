Feature: Book Store Web API
 
  Scenario: Authorization with valid credentials
    Given an existing user
    When the client calls /Account/v1/Authorized with username 'kikelink' and password 'Admin123!'
    Then the client receives status code of 200
    And the client receives response 'true'
    
  Scenario: Generate token for valid credentials 
    Given an existing user
    When the client calls /Account/v1/GenerateToken with username 'kikelink' and password 'Admin123!'
    Then the client receives status code of 200
    And a 'token' property is provided
  
  Scenario: Do not generate token for invalid password  
    Given an existing user
    When the client calls /Account/v1/GenerateToken with username 'kikelink' and password 'Admin124!'
    Then the client receives status code of 200
    And a 'token' property is 'null' 

    
