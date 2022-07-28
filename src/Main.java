import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\Users\\FORMULA\\IdeaProjects\\SimpleCalculator\\out\\toCalculate.txt";

        File inputFile = new File(path);
        Scanner sc = new Scanner(inputFile);

        String str = sc.nextLine();

        sc.close();
        String [] symbols = str.split(" ");
        double a = 0.0;
        double b = 0.0;
        boolean wasException = false;

        try {
            a = Double.valueOf(symbols[0]);
            b = Double.valueOf(symbols[2]);
        } catch (NumberFormatException e) {
            System.out.println("Error! Not number");
            wasException = true;
        }


            ArrayList<Character> arithmeticOperations = new ArrayList<>();
            arithmeticOperations.add('+');
            arithmeticOperations.add('-');
            arithmeticOperations.add('*');
            arithmeticOperations.add('/');
            char[] operation = symbols[1].toCharArray();
        if (!wasException) {
            try {

                if (operation.length != 1) {
                    throw new ArithmeticException("Operation Error!");
                } else if (!arithmeticOperations.contains(operation[0])) {
                    throw new ArithmeticException("Operation Error!");
                }

            } catch (ArithmeticException e) {
                System.out.println("Operation Error!");
                wasException = true;
            }
        }
        if (!wasException) {
            try {
                if (operation[0] == '/' && b == 0) {
                    throw new ArithmeticException("Error! Division by zero");
                }
            } catch (ArithmeticException e) {
                System.out.println("Error! Division by zero");
                wasException = true;
            }
        }

       if (!wasException) {
           double result = 0.0;
           switch (operation[0]) {
               case '+': {
                   result = a + b;
                   break;
               }
               case '-': {
                   result = a - b;
                   break;
               }
               case '*': {
                   result = a * b;
                   break;
               }
               case '/': {
                   result = a / b;
                   break;
               }
           }
           System.out.println(result);
       }
    }
}
