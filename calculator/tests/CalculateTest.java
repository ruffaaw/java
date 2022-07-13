import calculate.Calculate;
import infixToPostfix.InfixToPostfix;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CalculateTest {

    @Test
    public void calculate() {
        assertEquals(4.0, Calculate.calculate(InfixToPostfix.convertToPostfix("2*(3-(4/2))/0.5")));
        assertEquals(37.3, Calculate.calculate(InfixToPostfix.convertToPostfix("10.10*2+8.1+3^2")));
        assertEquals(37.4, Calculate.calculate(InfixToPostfix.convertToPostfix("85/5+42/7*(1+2.4)")));
        assertEquals(-158.9, Calculate.calculate(InfixToPostfix.convertToPostfix("2.2/2-(4^2)*10")));
    }
}