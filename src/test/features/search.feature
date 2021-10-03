Feature: Search Feature
  As a user
  I should search and retrieve appropriate results

  @search
  Scenario: Validate search with valid key term

    Given I'm on Home Page
    When I enter searchTerm "Jeans"
    And I click searchIcon
    Then I should get appropriate results with keyterm "Jeans"