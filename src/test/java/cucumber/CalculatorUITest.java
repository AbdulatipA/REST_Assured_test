package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorUITest {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By firstNumberInput = By.cssSelector("#number1Field");
    private final By secondNumberInput = By.cssSelector("#number2Field");
    private final By selectOperation = By.cssSelector("#selectOperationDropdown");
    private final By calculateButton = By.cssSelector("#calculateButton");
    private final By answer = By.cssSelector("#numberAnswerField");

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    //дано
    @Given("i open calculator page")
    public void i_open_calculator_page() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html?utm_source=chatgpt.com");
    }


    //сложение
    @When("i enter {int} and {int} and select add operation")
    public void sum(int num1, int num2) {
        By plus = By.xpath("//option[text()='Add']");

        inputNumber(firstNumberInput, num1);
        inputNumber(secondNumberInput, num2);

        clickByLocator(selectOperation);
        clickByLocator(plus);
        clickByLocator(calculateButton);
    }

    //вычитание
    @When("i enter {int} and {int} and select subtract operation")
    public void subtract(int num1, int num2) {
        By subtract = By.xpath("//option[text()='Subtract']");

        inputNumber(firstNumberInput, num1);
        inputNumber(secondNumberInput, num2);

        clickByLocator(selectOperation);
        clickByLocator(subtract);
        clickByLocator(calculateButton);
    }

    //умножение
    @When("i enter {int} and {int} and select multiply operation")
    public void multiply(int num1, int num2) {
        By multiply = By.xpath("//option[text()='Multiply']");

        inputNumber(firstNumberInput, num1);
        inputNumber(secondNumberInput, num2);

        clickByLocator(selectOperation);
        clickByLocator(multiply);
        clickByLocator(calculateButton);
    }

    //деление
    @When("i enter {int} and {int} and select divide operation")
    public void divide(int num1, int num2) {
        By divide = By.xpath("//option[text()='Divide']");

        inputNumber(firstNumberInput, num1);
        inputNumber(secondNumberInput, num2);

        clickByLocator(selectOperation);
        clickByLocator(divide);
        clickByLocator(calculateButton);
    }

    //конкатенация
    @When("i enter {string} and {string} and select concatenate operation")
    public void concatenate(String num1, String num2) {
        By concat = By.xpath("//option[text()='Concatenate']");

        inputNumber(firstNumberInput, num1);
        inputNumber(secondNumberInput, num2);

        clickByLocator(selectOperation);
        clickByLocator(concat);
        clickByLocator(calculateButton);
    }


    //результат под конкатенацию
    @Then("page result should be {string}")
    public void result_should_be(String expectedResult) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(answer));
        WebElement element = driver.findElement(answer);
        String actualSrt = element.getAttribute("value");

        Assertions.assertEquals(expectedResult, actualSrt);
    }

    //результат под остальные методы
    @Then("page result should be {int}")
    public void result_should_be(int expectedResult) {
        String expectedSrt = String.valueOf(expectedResult);

        wait.until(ExpectedConditions.visibilityOfElementLocated(answer));
        WebElement element = driver.findElement(answer);
        String actualSrt = element.getAttribute("value");

        Assertions.assertEquals(expectedSrt, actualSrt);
    }

    //работа с инпутом
    public void inputNumber(By field, int number) {

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(field));

        input.clear();
        input.sendKeys(String.valueOf(number));
    }

    //работа с инпутом под конкатенацию
    public void inputNumber(By field, String numberStr) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(field));
        input.clear();
        input.sendKeys(numberStr);
    }

    //клик по локаторам
    public void clickByLocator(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
