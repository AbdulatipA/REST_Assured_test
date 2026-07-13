package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Calculator;
import org.junit.jupiter.api.Assertions;

public class CalculatorFeature {
    private Calculator calc;
    private int actualResult = 0;

    //дано
    @Given("i have a calculator")
    public void i_have_a_calculator() {
        calc = new Calculator();
    }

    //сложение
    @When("i add {int} and {int}")
    public void sum(int num1, int num2) {
        actualResult = calc.sum(num1, num2);
    }

    //вычитание
    @When("i subtract {int} and {int}")
    public void subtract(int num1, int num2) {
        actualResult = calc.subtract(num1, num2);
    }

    //умножение
    @When("i multiply {int} and {int}")
    public void multiply(int num1, int num2) {
        actualResult = calc.multiply(num1, num2);
    }

    //деление
    @When("i divide {int} and {int}")
    public void divide(int num1, int num2) {
        actualResult = calc.divide(num1, num2);
    }

    //ответ
    @Then("result should be {int}")
    public void result_should_be(int expectedResult) {
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
