package cucumber;

import org.example.Calculator;

public class CalculatorFeature {
  private Calculator calc;

    public CalculatorFeature() {
        this.calc = new Calculator();
    }

    public int sum(int a, int b) {
     return calc.sum(a, b);
    }

    public int minus(int a, int b) {
      return calc.minus(a, b);
    }

    public int multiply(int a, int b) {
      return calc.multiply(a, b);
    }

    public int divide(int a, int b) {
      return calc.divide(a, b);
    }
}
