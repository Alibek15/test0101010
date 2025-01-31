Feature: Validate Shop.KZ Home Page

  Scenario: Verify Shop.KZ title
    Given I open the Shop.KZ website
    Then the page title should contain "Интернет-магазин Белый Ветер"
