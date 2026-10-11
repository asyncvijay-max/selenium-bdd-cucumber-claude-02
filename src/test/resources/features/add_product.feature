Feature: Add Product To Cart

  @addproducttocart
  Scenario: search a product by guest
    Given Guest reaches Store Page
    When Guest search for "blue"
    Then Guest is able to search successfully


