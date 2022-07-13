package calculate;

import java.util.Stack;
import static infixToPostfix.InfixToPostfix.isOperator;

public class Calculate {
    static Stack<Double> operandStack = new Stack<>();
    /**
     * Compute the expression in RPN
     * @param postfixexp input expression in RPN
     * @return the computed expression
     */
    public static double calculate(String postfixexp){

        boolean isUnderscore = false;
        StringBuilder numberString = new StringBuilder();
        for (int i=0; i<postfixexp.length(); i++){
            if (postfixexp.charAt(i)=='_') {
                isUnderscore = true;
                if (i> 0 && numberString.length()>0)
                    operandStack.push(Double.parseDouble(numberString.toString()));
                numberString.delete(0, numberString.length());
                continue;
            }
            else if(postfixexp.charAt(i) == '.'){
                numberString.append(postfixexp.charAt(i));
                continue;
            }
            final boolean isOperator = isOperator(postfixexp.charAt(i));
            if (isUnderscore){
                if (!isOperator) {
                    numberString.append(postfixexp.charAt(i));
                    continue;
                } else {
                    operandStack.push(Double.parseDouble(numberString.toString()));
                    numberString.delete(0, numberString.length());
                    isUnderscore = false;
                }
            } if (isOperator) {
                final double res = evaluate(operandStack.pop(), operandStack.pop(), postfixexp.charAt(i));
                operandStack.push(res);
            }
        }
        return operandStack.pop();
    }

    /**
     * Performs a math calculation on the given math symbol
     * @param second second number
     * @param first first number
     * @param operator math symbol
     * @return result of the mathematical operation
     */
    private static double evaluate (Double second, Double first,char operator){
        return switch (operator) {
            case '+' -> first + second;
            case '-' -> first - second;
            case '*' -> first * second;
            case '/' -> first / second;
            case '^' -> Math.pow(first, second);
            default -> throw new IllegalArgumentException("Operator not defined for " + operator);
        };
    }
}

