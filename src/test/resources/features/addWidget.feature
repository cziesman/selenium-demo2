@Widget
Feature: Add a new widget

  Background:
    Given User is viewing the Add Widget page at "http://127.0.0.1:8080/widgety/web/widget"

  @AddWidget
  Scenario: Add a widget named 'A Widget'

    When User adds a new widget with name "A Widget" and description "A really cool widget that you will love!"
    Then The widget named "A Widget" is added

