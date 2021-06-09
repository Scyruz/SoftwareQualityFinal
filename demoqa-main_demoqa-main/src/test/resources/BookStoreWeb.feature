Feature: Book Store Web Log In
 
  Scenario: Login with valid credentials
  	Given a registered user
    When the client calls /login page with username 'Scyruz' and password '*Soyscyruz3'
    Then the client is redirected to the 'Profile' page
    
  Scenario: Login with invalid credentials
    Given a registered user
    When the client calls /login page with username 'Scyruz' and password 'soyScyruz'
    Then the message 'Invalid username or password!' is displayed