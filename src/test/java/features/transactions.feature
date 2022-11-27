Feature: Validating Payment Transfer

  Scenario: Register Sender and do Transaction to Recipient and verify
    Given Launch Test Bank Site
    Then  Register Sender
    When  Registration is successful
    Then  Navigate to Bill Pay page
    And   Enter Recipient Details and Amount to Transfer
    Then  Perform Transfer
    And   Verify Transfer is successful to correct Recipient


