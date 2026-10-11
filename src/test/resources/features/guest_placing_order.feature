Feature: Guest places Order - E2E

  @guestorder
  Scenario Outline: Ability of guest to place order
    Given Guest reaches Store Page
    When Guest search for "blue"
    And Guest is able to search successfully
    And Guest adds "Blue Shoes" in the cart
    And Guest see the added product in the cart
    And Guest fills the billing address
      | firstName   | lastName   | street   | city   | zip   | email   |
      | <firstName> | <lastName> | <street> | <city> | <zip> | <email> |
    And Guest submits the Order
    Then Guest sees the order successfully
    Examples:
      | firstName | lastName | street     | city     | zip   | email                    |
      | messi     | fine     | 315 street | New York | 10002 | messi123e@testing.com    |
      | chacko    | jenny    | 415 street | New York | 10003 | chackojen23e@testing.com |





