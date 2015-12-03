Feature: reddit.com features
  Scenario: Client Open reddit website
    Given  open reddit website
    And he navigate to new link
    Then he can nevigate new post

  Scenario: Browser commands
 Given  open reddit website
  Then I perform selenium browser commands
