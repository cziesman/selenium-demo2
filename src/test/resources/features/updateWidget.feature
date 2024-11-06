@Widget
Feature: Update a new widget

  Background:
    Given User is viewing the Update Widget page at "http://127.0.0.1:8080/widgety/web/widget/"

  @UpdateWidget
  Scenario: Update a widget

    When User updates a widget
    Then The widget is updated

