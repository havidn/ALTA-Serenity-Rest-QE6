Feature: to test Reqres
   @latihan
 Scenario Outline: Get list user with valid parameter page
     Given Get list user with parameter page <page>
     When Send request get list user
     Then Should return 200 OK
     And Response body page should be <page>
     And Get list user json schema validator
     Examples:
       |page|
       |1   |
       |2   |
   @tugas
 Scenario Outline: Get list user with string parameter page
    Given Get list user with parameter page "<page>"
    When Send request get list user
    Then Should return 404 Not found
    Examples:
      |page|
      |abc |
      |xyz |
   @tugas
 Scenario Outline: Get list user with Special char parameter page
    Given Get list user with parameter page "<page>"
    When Send request get list user
    Then Should return 404 Not found
    Examples:
      |page|
      |!@# |
      |%#$ |
   @tugas
 Scenario Outline: Get single list Resource with valid parameter
    Given Get Single list Resource with valid parameter <id>
    When Send request get list resource
    Then Should return 200 OK
    And Response body id should be <id>
    And Get single list Resource json schema validator
    Examples:
      |id|
      |1 |
      |2 |
   @tugas
 Scenario Outline: Get Single list Resource with invalid parameter
    Given Get Single list Resource with invalid parameter "<id>"
    When Send request get list resource
    Then Should return 404 Not found
    Examples:
      |id  |
      |apa |
      |abc |
   @tugas
 Scenario Outline: Get single user with valid id
    Given Get single user with valid id <id>
    When Send request get single user
    Then Should return 200 OK
    And Response body id should be <id>
    And Response body should contain email "<email>", first name "<first_name>", and last name "<last_name>"
    And Get single user json schema validator
    Examples:
      |id|email                  |first_name |last_name  |
      |1 |george.bluth@reqres.in |George     |Bluth      |
      |2 |janet.weaver@reqres.in |Janet      |Weaver     |
   @tugas
 Scenario Outline: Get single user with invalid id
    Given Get single user with invalid id "<id>"
    When Send request get single user
    Then Should return 404 Not found
    Examples:
      |id  |
      |apa |
      |!@# |
  @latihan
 Scenario: Post create new user with valid json
     Given Post create new user
     When Send request post create new user
     Then Should return 201 created
     And Response body should contain name "Havid Nursahgandi" and job "QA Engineer"
     And Post create new user json schema validator
   @tugas
 Scenario: Post create new user with invalid json
     Given Post create new invalid user
     When Send request post create new user
     Then Should return 400 Bad Request
  @tugas
 Scenario: Post register user with valid json
    Given Post register user with valid json
    When Send request post register user
    Then Should return 200 OK
    And Response body should contain id 4
    And Post register user json schema validator
  @tugas
  Scenario: Post register user with invalid json
    Given Post register user with invalid json
    When Send request post register user
    Then Should return 400 Bad Request
    And Post register invalid user json schema validator
  @tugas
  Scenario: Post login user with valid json
    Given Post login user with valid json
    When Send request post login user
    Then Should return 200 OK
    And Post login user json schema validator
  @tugas
  Scenario: Post login user without password
    Given Post login user without password
    When Send request post login user
    Then Should return 400 Bad Request
    And Post login invalid user json schema validator
  @tugas
  Scenario: Post login user with without email
    Given Post login user without email
    When Send request post login user
    Then Should return 400 Bad Request
    And Post login invalid user json schema validator
  @latihan
 Scenario Outline: Put update user with valid json
     Given Put update with id <id>
     When Send request put update user
     Then Should return 200 OK
     And Response body should contain name "Havidun" and job "QE update"
     And Put Update user json schema validator
     Examples:
       |id|
       |1 |
       |2 |
   @tugas
 Scenario Outline: Put update user without name
   Given Put update without name json file to id <id>
   When Send request put update user
   Then Should return 400 Bad Request
     Examples:
     |id|
     |1 |
     |2 |
   @tugas
Scenario Outline: Put update user without job
   Given Put update without job json file to id <id>
   When Send request put update user
   Then Should return 400 Bad Request
     Examples:
       |id|
       |1 |
       |2 |
   @tugas
 Scenario: Patch update user with valid json
   Given Patch update with id 2
   When Send request patch update user
   Then Should return 200 OK
   And Response body should contain name "Havidun" and job "Quality Engineer"
   And Patch update user json schema validator
    @tugas
 Scenario: Patch update user with invalid json
    Given Patch update with invalid json file to id 2
      When Send request patch update user
    Then Should return 400 Bad Request

  @latihan
 Scenario Outline: Delete user with valid id
     Given Delete user with valid id <id>
     When Send request delete user
     Then Should return 204 No content
     Examples:
       |id|
       |1 |
       |2 |
   @tugas
 Scenario Outline: Delete user with invalid id
    Given Delete user with invalid id "<id>"
    When Send request delete user
    Then Should return 404 Not found
    Examples:
      |id   |
      |asd  |
      |xyz  |
