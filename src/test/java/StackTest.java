import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


//Class:             Data Structures Section 03
//Term:              Spring: 2022
//Name:
//Program Number:    assignment3
//IDE:               Eclipse
//DATE:              02 25,2022
//JRE:               15.0.1%
// I'm providing this file just so you can see how I actually tested my functions


public class StackTest{

    @Test
    @DisplayName("Test putting in one object. Testing with: list size, peek, pop")
    void TestingPushOneObj() {
        MyStack<String> mylist = new MyStack<>();
        mylist.push("Something");
        assertTrue(mylist.peek().equals("Something"));
        assertTrue(mylist.size == 1);
    }
    @Test
    @DisplayName("Test Putting in two Objects")
    void TestingPushTwoObjs() {
        MyStack<String> mylist = new MyStack<>();
        mylist.push("Something");
        assertTrue(mylist.peek().equals("Something"));
        assertTrue(mylist.size == 1);
        mylist.push("Else");
        assertTrue(mylist.peek().equals("Else"));
        assertTrue(mylist.size == 2);

        assertTrue(mylist.pop().equals("Else"));
        assertTrue(mylist.size == 1);

        assertTrue(mylist.pop().equals("Something"));
        assertTrue(mylist.size == 0);


    }
    @Test
    @DisplayName("Testing is it a number for all numbers")
    void isNumberTesting() {
        for(int i = 0; i <=9; i++){

            assertTrue( Expr.isNumber((char) (i+'0') ) == true );
        }
    }
    @Test
    @DisplayName("Testing function responds false")
    void isNumberFalse() {
        assertTrue(Expr.isNumber('*') == false);
        assertTrue(Expr.isNumber('/') == false);
        assertTrue(Expr.isNumber('+') == false);
        assertTrue(Expr.isNumber('-') == false);

    }
    @Test
    @DisplayName("Testing internal Evalutate function")
    void EvaluatFunctionTesting() {
        assertTrue(Expr.Evaluate(1, 2, '*')==2);
        assertTrue(Expr.Evaluate(1, 2, '/')==1d/2);
        assertTrue(Expr.Evaluate(3, 4, '+')==7);
        assertTrue(Expr.Evaluate(5, 5, '-')==0);
    }

    @Test
    @DisplayName("Attemping to show that something has the right value")
    void ShowingEval() {
        System.out.println( Expr.infixToPostfix("(7+3)*(3-1)/2"));
        System.out.println( Expr.infixToPostfix("(5-6)/4*2-(5+2)"));
        System.out.println( Expr.infixToPostfix("3+2^(2+3)"));

    }

    @Test
    @DisplayName("Testing postfix function with values from word doc")
    void Testinginfixtopostfixconversion() {
        assertTrue( Expr.infixToPostfix("(7+3)*(3-1)/2").equals("73+31-*2/"));
        assertTrue( Expr.infixToPostfix("(5-6)/4*2-(5+2)").equals("56-4/2*52+-"));
        assertTrue( Expr.infixToPostfix("3+2^(2+3)").equals("3223+^+"));

    }
    @Test
    @DisplayName("Testing postfix evalutation function with values from word doc")
    void TestingPostfixSolutions() {
        assertTrue( Double.compare(Expr.postfixEval(("73+31-*2/")) ,  10.0) == 0);
        assertTrue( Double.compare(Expr.postfixEval(("56-4/2*52+-")), -7.5) == 0);
        assertTrue( Double.compare(Expr.postfixEval(("3223+^+")), 35.0) == 0 );
    }

}

