public interface Calculator {
    double calculate(double x, double y);
}

public class Addition implements Calculator {
    @Override
    public double calculate(double x, double y) {
        return x + y;
    }
}

public class Multiplication implements Calculator {
    @Override
    public double calculate(double x, double y) {
        return x * y;
    }
}

public class Division implements Calculator {
    @Override
    public double calculate(double x, double y) {
        if (y == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return x / y;
    }
}

public interface Logger {
    void log(String message);
}

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

public class Main {
    private final Calculator calculator;
    private final Logger logger;

    public Main(Calculator calculator, Logger logger) {
        this.calculator = calculator;
        this.logger = logger;
    }

    public double performCalculation(double x, double y) {
        double result = calculator.calculate(x, y);
        logger.log("Calculation: " + x + " op " + y + " = " + result);
        return result;
    }

    public static void main(String[] args) {
        Calculator calculator = new Addition(); // Можно использовать любую реализацию Calculator
        Logger logger = new ConsoleLogger(); // Можно использовать любую реализацию Logger

        Main app = new Main(calculator, logger);
        double result = app.performCalculation(10, 5);
        System.out.println("Result: " + result);
    }
}
