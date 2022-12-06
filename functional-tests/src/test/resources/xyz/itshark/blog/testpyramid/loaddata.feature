Feature: API

  Scenario: load data
    Given base url 'http://localhost:8080'
    When user hit end point 'posts'
    Then I expect list of data

