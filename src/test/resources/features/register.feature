@regressionSuite
Feature: Register

#  @ringo
#  Scenario: Login as a RingGo account
#    Given the user is on the login page
#    When user logs in using "myRingGoTest" and "W4t3Rf4lls"
#    Then the user should be able to login
#    And the title should contains ""


  @register @smoke @valid
  Scenario Outline: Register as a RingGo account
    Given the user is on the register page
    When user should enter "<mobileNumber>", "<email>" and "<password>"
    Then the user should be able to click to updates buttons and Terms & Conditions
    Examples:
      | mobileNumber | email               | password     |
      | 5321264237   | fvursavas@gmail.com | Vursavas.123 |

  @register @invalid @smoke
  Scenario Outline: Register with an invalid email
    Given the user is on the register page
    When user should enter "<mobileNumber>", "<email>" and "<password>"
    When the user should be able to click to updates buttons and Terms & Conditions
    Then the user should see "<error>" messages
    Examples:
      | mobileNumber | email         | password     | error                     |
      | 1234567890   | @gmail.com    | Vursavas.123 | Email address is invalid  |
      | 1234567891   | abc@com       | Vursavas.123 | Email address is invalid  |
      | 1234567892   | abc@gmail.    | Vursavas.123 | Email address is invalid  |
      | 1234567893   | abc/gmail.com | Vursavas.123 | Email address is invalid  |
      | 1234567893   |               | Vursavas.123 | Email address is required |


  @register @invalid @smoke
  Scenario Outline: Register with an invalid password
    Given the user is on the register page
    When user should enter "<mobileNumber>", "<email>" and "<password>"
    When the user should be able to click to updates buttons and Terms & Conditions
    Then the user should see "<error>" messages
    Examples:
      | mobileNumber | email                | password    | error                                          |
      | 1234557890   | mikesmith@gmail.com  | ursavas.123 | The password does not meet the correct format. |
      | 1234547891   | mariogomez@gmail.com | Vursavas    | The password does not meet the correct format. |
      | 1234527893   | aliveli@gmail.com    | ursavas123  | The password does not meet the correct format. |
      | 1234527893   | aliveli@gmail.com    |             | Password is required                           |

  @register @invalid @smoke
  Scenario Outline: Register with an invalid mobile number
    Given the user is on the register page
    When user should enter "<mobileNumber>", "<email>" and "<password>"
    When the user should be able to click to updates buttons and Terms & Conditions
    Then the user should see "<error>" messages
    Examples:
      | mobileNumber     | email                    | password      | error                                             |
      | 1234547as        | smithmike@gmail.com      | Vursavas      | Mobile number must be numeric                     |
      | @34              | fvursavas@gmail.com      | Vursavas123   | Mobile number must be numeric                     |
      | abcdesd          | afscemil@gmail.com       | ursavas123    | Mobile number must be numeric                     |
      | 123              | hasanhuseyin@hotmail.com | Vursavas1234  | Telephone number must be longer than 9 characters |
      | 1234567898877654 | selemagomez@gmail.com    | Vursavas98765 | Telephone number must be 13 or less characters    |
      |                  | alican2000@gmail.com     | Vursavas1287  | Mobile number is required                         |



