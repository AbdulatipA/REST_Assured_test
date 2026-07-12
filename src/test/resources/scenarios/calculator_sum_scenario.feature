Feature: Calculator
  #сложение
  Scenario: add to numbers
    Given i have a calculator
    When i add 2 and 3
    Then result should be 5
    And result not null

#  #вычитание
#  Scenario: minus to number
#    Given i have a calculator
#    When i minus 100 and 25
#    Then result should be 75
#    And result not null
#
#  #умножение
#  Scenario: multiply to number
#    Given i have a calculator
#    When i multiply 10 and 5
#    Then result should be 50
#    And result not null
#
#  #деление
#  Scenario: divide to number
#    Given i have a calculator
#    When i divide 10 and 5
#    Then result should be 2
#    And result not null