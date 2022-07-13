package infixToPostfix;

import java.util.Stack;

public class InfixToPostfix {
    private static final Stack<Character> operatorStack = new Stack<>();
    /**
     * Convert expression from infix to postfix
     * @param infixExpression input expression
     * @return expression in postfix notation
     */
    public static String convertToPostfix(String infixExpression){
        final String enhanced = enhance(infixExpression);
        final StringBuilder resultStringBuilder = new StringBuilder();
        for (int i=0;i<enhanced.length(); i++){
            final char c = enhanced.charAt(i);
            if (c == '_' || Character.isLetterOrDigit(c) || c=='.')
                resultStringBuilder.append(c);
            else if (isLeftParenthesis(c)) {
                if (i>0 && (!isOperator(enhanced.charAt(i-1)) && !isLeftParenthesis(enhanced.charAt(i-1))))
                    throw new IllegalArgumentException("There should be an operator before a left parentheses, at position: " + i + " of string: " + enhanced);
                operatorStack.push(c);
            }else if (isOperator(c)) {
                if (i==0 || i==enhanced.length()-1)
                    throw new IllegalArgumentException("The operator should not be at the start or end of the expression, at position: " + i);
                if (isOperator(enhanced.charAt(i+1)))
                    throw new IllegalArgumentException("Two operators should not occur consecutively, at position: " + i);
                while (!operatorStack.isEmpty() && !isLeftParenthesis(operatorStack.peek()) && hasHigherPrecedence(operatorStack.peek(), c))
                    resultStringBuilder.append(operatorStack.pop());
                operatorStack.push(c);
            }else if (isRightParenthesis(c)){
                if (i>0 && isOperator(enhanced.charAt(i-1)))
                    throw new IllegalArgumentException("There should not be an operator, at position: " + (i-1));
                while (!operatorStack.isEmpty() && !isLeftParenthesis(operatorStack.peek()))
                    resultStringBuilder.append(operatorStack.pop());
                final Character poppedChar = operatorStack.pop();
                if (!isLeftParenthesis(poppedChar)){
                    throw new IllegalArgumentException("The expression might be malformed!");
                }
            }
        }
        while (!operatorStack.isEmpty()){
            final Character pop = operatorStack.pop();
            if (isLeftParenthesis(pop))
                throw new IllegalArgumentException("The expression might contain extra left parentheses");
            resultStringBuilder.append(pop);
        }
        return resultStringBuilder.toString();

    }

    /**
     * checks if the first character has higher precedence compared to the second
     * @param first first math symbol
     * @param second second math symbol
     * @return true if the fist character has higher precedence than the second, otherwise false
     * */
    public static boolean hasHigherPrecedence(Character first, Character second){

        if (first == null || second == null){
            throw new UnsupportedOperationException("The characters cannot be null!");
        }
        return priorityLevelOfOperator(first)-priorityLevelOfOperator(second)>=0;
    }

    /**
     * Sets a priority for symbols
     * @param c math symbol
     * @return priority
     */
    private static int priorityLevelOfOperator(Character c){
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    /**
     * Checking if a symbol is a left parenthesis
     * @param c math symbol
     * @return true if the math symbol is a left parenthesis
     */
    private static boolean isLeftParenthesis(Character c){
        return c=='(' || c=='{' || c=='[';
    }

    /**
     * Checking if a symbol is a right parenthesis
     * @param c math symbol
     * @return true if the math symbol is a right parenthesis
     */
    private static boolean isRightParenthesis(Character c){
        return c==')' || c=='}' || c==']';
    }

    /**
     * Checking if a symbol is a operator
     * @param c math symbol
     * @return true if the math symbol is a operator
     */
    public static boolean isOperator(char c) {
        return c=='-' || c== '+' || c=='*' || c=='/' || c=='^';
    }
    /**
     * puts an underscore '_' at the beginning of each word that is not a operator, so as to make it easy to identify a number
     * e.g 25*34-(23+1) becomes _25*_34-(_23+_1)
     * */
    public static String enhance(String input){
        StringBuilder string = new StringBuilder();
        char c=' ';
        boolean dot=false;
        boolean operator = false;
        for(int i=0; i<input.length();i++){
            c=input.charAt(i);
            if(isLeftParenthesis(c) || isRightParenthesis(c) || isOperator(c)){
                string.append(c);
                dot=false;
                operator=false;
            } else if(c=='.'){
                string.append(c);
                dot=true;
            } else if(Character.isDigit(c)) {
                if (dot) {
                    string.append(c);
                } else if (operator) {
                    string.append(c);
                } else {
                    string.append('_').append(c);
                    operator = true;
                }
            } else
                throw new IllegalArgumentException("incorrect");
        }
        return string.toString();
    }
}
