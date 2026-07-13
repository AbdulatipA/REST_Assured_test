Feature: Calculator UI
  #сложение
  Scenario: add to numbers
    Given i open calculator page
    When i enter 28 and 2 and select add operation
    Then page result should be 30

  #вычитание
  Scenario: subtract to number
    Given i open calculator page
    When i enter 5 and 3 and select subtract operation
    Then page result should be 2

  #умножение
  Scenario: multiply to number
    Given i open calculator page
    When i enter 10 and 50 and select multiply operation
    Then page result should be 500

  #деление
  Scenario: divide to number
    Given i open calculator page
    When i enter 10 and 5 and select divide operation
    Then page result should be 2

  #конкатенация
  Scenario: concatenate to string
    Given i open calculator page
    When i enter "101" and "8" and select concatenate operation
    Then page result should be "1018"
