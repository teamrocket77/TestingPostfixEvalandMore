import java.util.Scanner;
//Class:             Data Structures Section 03
//Term:              Spring: 2022
//Name:
//Program Number:    assignment3
//IDE:               Eclipse
//DATE:              02 25,2022
//JRE:               15.0.1%

class Expr{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String prompt1 = "Enter an infix:";
        String prompt2 = "Do you want to continue";
        String Userinput = "y";
        /*
         * WHILE User input ==  y
         * 	OUPUT prompt1
         * 	GET Userinput = scan.nextline
         * 	OUTPUT: POSTFIFX Expression from Userinput
         * 	OUTPUT: Postfix Expression value
         * 	OUTPUT: prompt2
         * 	GET Userinput
         */
        while(Userinput.equals("y")){

            System.out.print(prompt1);
            Userinput = scanner.nextLine();
            Userinput = infixToPostfix(Userinput);
            System.out.println(String.format("Postfix Expression %s", Userinput));
            System.out.println(String.format("Result Value: %.2f", postfixEval(Userinput)));
            Userinput = "";
            System.out.print("Do you want to continue? (Y/N)");
            Userinput = scanner.nextLine();
            Userinput = Userinput.toLowerCase();

        }
    }

    public static Double postfixEval(String expression){
        /*
         * Evaluate Postfix
         * CREATE STACK CHAR_STACK
         * CREATE op1, op2
         * FOR CHAR C IN EXPRESSION:
         * 	if Isnumber(C):
         *		PUSH
         *	ELSE IF isOperator(C):
         *		op1 = pop
         *		op2 = pop
         *
         *		result = EVALUATE(op1, op2, C)
         * 		PUSH(result)
         *
         * 	return POP
         */
        MyStack<Double> internalStack = new MyStack<>();
        Double operand1, operand2;
        operand1 = null;
        operand2 = null;
        for(char c : expression.toCharArray()){
            if(isNumber(c)){

                operand1 = Double.valueOf(c- '0');
                internalStack.push(operand1);


            }
            else if (isOperator(c)){
                operand2 =   internalStack.pop() ;
                operand1 =   internalStack.pop() ;

                internalStack.push( Evaluate(operand1, operand2, c));
            }
            else {
                System.out.println("You attempted to pass an invalid expression");
            }


        }
        return internalStack.pop();

    }

    public static String infixToPostfix(String expression){
        String outputExpression = "";
        int charPrec = 0;
        /* CREATE STACK CHARSTACK
         * FOR C in expression:
         * 	if CharPrecedence == -1:
         * 		append to string
         *
         * 	if c == (
         * 		push c
         *
         * 	elif c == ):
         * 		pop all ops from stack and append to output string
         *
         * 	else:
         * 		compare operator precendce for the stack.peek method:
         * 		pop off all higher/equal value precedence
         *
         * while stack !isEmpty:
         * 	output string += stack.pop
         */

        MyStack<Character> charStack = new MyStack<Character>();
        for(char c : expression.toCharArray()){
            charPrec = Precedence(c);
            if(charPrec == -1){
                outputExpression += String.valueOf(c);
            }
            else if(c == '('){
                charStack.push(c);
            }
            else if (c == ')'){
                while(!charStack.isEmpty() && !charStack.peek().equals('(')){
                    outputExpression += charStack.pop();
                }
                charStack.pop();
            }
            else {
                while(!charStack.isEmpty() && charPrec <= Precedence(charStack.peek())){
                    outputExpression += charStack.pop();
                }
                charStack.push(c);
            }
        }
        while(!charStack.isEmpty()){
            outputExpression += charStack.pop();
        }
        return outputExpression;
    }

    public static int Precedence(char c){
        /* switch case for operator precedence*/
        switch(c){
            case ')':
            case '(':
                return -2;
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    //new func to discipher whether something is an operator
    public static boolean isOperator(char c){
        /* switch case involving all operator symbols*/
        switch(c){
            case ')':
            case '(':
            case '+':
            case '-':
            case '/':
            case '*':
            case '^':
                return true;
        }
        return false;
    }

    //is it a number
    public static boolean isNumber(char c){
        if(c >= '0' && c<='9'){
            return true;
        }
        return false;
    }

    public static Double Evaluate (double num1, double num2, char c){
        /* switch case involving operations
         * if char == +:
         * 	return num1 + num2
         * (...Repeat for other chars / - )
         */

        switch(c){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '/':
                return num1/num2;
            case '*':
                return num1*num2;
            case '^':
                return Math.pow(num1, num2);


        }
        return -1d;

    }

}
