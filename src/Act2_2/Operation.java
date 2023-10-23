package Act2_2;

import java.io.Serializable;

public class Operation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private double operand1;
    private double operand2;
    private char operator;

    public Operation(double operand1, double operand2, char operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    public double performOperation() {
        double result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    throw new ArithmeticException("Division by zero!");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
        return result;
    }
}
  

