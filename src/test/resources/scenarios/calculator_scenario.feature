Feature: Calculator
  #сложение
  Scenario: add to numbers
    Given i have a calculator
    When i add 28 and 2
    Then result should be 30

  #вычитание
  Scenario: subtract to number
    Given i have a calculator
    When i subtract 5 and 3
    Then result should be 2

  #умножение
  Scenario: multiply to number
    Given i have a calculator
    When i multiply 10 and 50
    Then result should be 500

  #деление
  Scenario: divide to number
    Given i have a calculator
    When i divide 10 and 5
    Then result should be 2
