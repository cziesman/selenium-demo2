@Widget
Feature: View the empty list of widgets

  Background:
    Given User is viewing the List Widgets page at "http://127.0.0.1:8080/widgety/web/widgets"

  @ListWidgets
  Scenario: User can see an empty widget list

    When User can see the Add Widget button
    Then User can click on the Add Widget button

