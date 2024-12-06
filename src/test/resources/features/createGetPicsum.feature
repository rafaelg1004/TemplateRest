Feature: Get a list of images from Lorem Picsum

  @Get
  Scenario: Send GET request to Lorem Picsum API
    Given I want to get a list of images from Lorem Picsum
    When I send a GET request to the endpoint "<endpoint>"
    Then I validate that the response code is "<code>"
    And I validate that the response contains a list of images with the correct attributes

    Examples:
    |endpoint|code|
##@externaldata@parametros/Datos.xlsx@EndCode
   | /v2/list   |200|
