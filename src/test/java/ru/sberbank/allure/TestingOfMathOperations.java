package ru.sberbank.allure;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

/**
 * Testing of arithmetic operations.
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 10.02.2017.
 */
@RunWith(value = Parameterized.class)
public class TestingOfMathOperations {
    /**
     * first String operand.
     */
    private String operand1;
    /**
     * second String operand.
     */
    private String operand2;
    /**
     * String operator.
     */
    private String operations;
    /**
     * String result.
     */
    private String result;

    /**
     * Constructor for the class TestingOfMathOperations.
     * @param operand1 - first value.
     * @param operand2 - second value.
     * @param operations - operator.
     * @param result - result.
     */
    public TestingOfMathOperations(String operand1, String operand2, String operations, String result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operations = operations;
        this.result = result;
    }

    /**
     * @return collection
     */
    @Parameterized.Parameters
    public static List<String[]> getOperationColl() {
        List<String[]> collection = FileReaders.readFile("src\\main\\resources\\file");
        return collection;
    }

    /**
     * The method of testing of arithmetic operations.
     */
    @Test
    public void test() {
        if (operations.equals("+")) {
            info();
            final int expectedResult = Integer.parseInt(result);
            final int actualResult = Integer.parseInt(operand1) + Integer.parseInt(operand2);
            Assert.assertEquals(expectedResult, actualResult);
            System.out.println(String.format("Expected  value: %s, Actual value: %s", expectedResult, actualResult));
        } else if (operations.equals("-")) {
            info();
            final int expectedResult = Integer.parseInt(result);
            final int actualResult = Integer.parseInt(operand1) - Integer.parseInt(operand2);
            Assert.assertEquals(expectedResult, actualResult);
            System.out.println(String.format("Expected  value: %s, Actual value: %s", expectedResult, actualResult));
        } else if (operations.equals("*")) {
            info();
            final int expectedResult = Integer.parseInt(result);
            final int actualResult = Integer.parseInt(operand1) * Integer.parseInt(operand2);
            Assert.assertEquals(expectedResult, actualResult);
            System.out.println(String.format("Expected  value: %s, Actual value: %s", expectedResult, actualResult));
        } else if (operations.equals("/")) {
            info();
            final int expectedResult = Integer.parseInt(result);
            final int actualResult;
            try {
                actualResult = Integer.parseInt(operand1) / Integer.parseInt(operand2);
                Assert.assertEquals(expectedResult, actualResult);
                System.out.println(String.format("Expected  value: %s, Actual value: %s", expectedResult, actualResult));
            } catch (ArithmeticException ex) {
                System.out.println(String.format("Divide by zero error encountered."));
                Assert.fail();
            }
        }
    }

    /**
     * Method of output information.
     */
    public void info() {
        System.out.println(String.format("Test: %s %s %s = %s", operand1, operations, operand2, result));
    }
}
