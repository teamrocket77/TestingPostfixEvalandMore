import java.util.Scanner;


//Class:             Data Structures Section 03
//Term:              Spring: 2022
//Name:
//Program Number:    assignment3
//IDE:               Eclipse
//DATE:              02 25,2022
//JRE:               15.0.1%


class TestStack{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int UserOption = -1;
        String UserInputforForStack = "";
        System.out.println("Hello");
        MyStack<String> myStack = new MyStack<String>();
        String prompt = ""
                + "-----MAIN MENU-----\n"
                + "0 - Exit Program\n"
                + "1 - Push\n"
                + "2 - Pop\n"
                + "3 - Peek (Top)\n"
                + "4 - Size\n"
                + "5 - Is Empty?\n"
                + "6 - Print Stack\n"
                + "Chose Menu:";
        /*
         * Basic while loop:
         * 	Look for user input
         * 	if it is anything other than a y
         * 		return
         * End while
         */
        while(true){
            System.out.print(prompt);
            UserOption = Integer.parseInt(scanner.next());
            switch(UserOption){
                case 0:
                    System.out.println("Exiting Now");
                    System.exit(0);
                    break;
                case 1:
                    UserInputforForStack = scanner.next();
                    myStack.push(UserInputforForStack);
                    break;
                case 2:
                    System.out.println(myStack.pop());
                    break;
                case 3:
                    System.out.println(myStack.peek());
                    break;
                case 4:
                    System.out.println(myStack.size());
                    break;
                case 5:
                    System.out.println( myStack.isEmpty() ? " The Stack is empty" : "The stack isn't empty");
                    break;
                case 6:
                    System.out.println(myStack);
                    break;
                default:
                    System.out.println("Sorry that's not a valid option");
            }


        }
    }

}

