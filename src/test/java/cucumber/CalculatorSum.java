package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorSum {
    private CalculatorFeature calculatorFeature;
    private WebDriver driver;
    private WebDriverWait wait;

    By exactly = By.xpath("//span[@class='scieq' and text()='=']");

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.calculator.net");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.manage().window().minimize();
        }
    }

    //дано
    @Given("i have a calculator")
    public void i_have_a_calculator() {
        calculatorFeature = new CalculatorFeature();
    }


    //сложение
    @When("i add {int} and {int}")
    public void sum(int num1, int num2) {
        By plus = By.xpath("//span[@class='sciop' and text()='+']");
        driver.findElement(getValue(num1)).click();
        driver.findElement(plus).click();
        driver.findElement(getValue(num2)).click();
        driver.findElement(exactly).click();

        calculatorFeature.sum(num1, num2);
    }

    //вычитыние
    @When("i minus {int} and {int}")
    public void minus(int num1, int num2) {
        By minus = By.xpath("//span[@class='sciop' and text()='-']");

        driver.findElement(getValue(num1)).click();
        driver.findElement(minus).click();
        driver.findElement(getValue(num2)).click();
        driver.findElement(exactly).click();

        calculatorFeature.minus(num1, num2);
    }


    //умножение
    @When("i multiply {int} and {int}")
    public void multiply(int num1, int num2) {
        By multiply = By.xpath("//span(@class='sciop' and text()='*')");

        driver.findElement(getValue(num1)).click();
        driver.findElement(multiply).click();
        driver.findElement(getValue(num2)).click();
        driver.findElement(exactly).click();

        calculatorFeature.multiply(num1, num2);
    }


    //деление
    @When("i divide {int} and {int}")
    public void divide(int num1, int num2) {
        By multiply = By.xpath("//span(@class='sciop' and text()='/')");

        driver.findElement(getValue(num1)).click();
        driver.findElement(multiply).click();
        driver.findElement(getValue(num2)).click();
        driver.findElement(exactly).click();

        calculatorFeature.divide(num1, num2);
    }


    //ожидаемый результат
    @Then("result should be {int}")
    public void result_should_be(int expectedResult) {
        Assertions.assertEquals(String.valueOf(expectedResult), getActualResult());
    }

    //дополнительная проверка
    @And("result not null")
    public void result_not_null() {
        Assertions.assertNotNull(String.valueOf(getActualResult()));
    }


    public By getValue(int value) {
        return By.xpath("//span[@class='scinm' and text()='"
                + value + "']");
    }

    public String getActualResult() {
        By actualResult = By.xpath("//div[@id='sciOutPut']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(actualResult)).getText().strip();
    }
}

// написать свой ui тест, для приложение
