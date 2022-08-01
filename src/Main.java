import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        final String path = "C:\\Users\\FORMULA\\IdeaProjects\\SimpleCalculator\\out\\";
        String readPath = path + "toCalculate.txt";
        String writePath  = path + "answer.txt";


        File inputFile = new File(readPath);
        File outputFile = new File(writePath);
        Scanner sc = new Scanner(inputFile);
        String str = sc.nextLine();
        sc.close();
        if (!outputFile.exists()) outputFile.createNewFile();
        else System.out.println("File exists");
        PrintWriter pw = new PrintWriter(outputFile);


        String [] symbols = str.split(" ");
        double a = 0.0;
        double b = 0.0;
        boolean wasException = false;

        try {
            a = Double.valueOf(symbols[0]);
            b = Double.valueOf(symbols[2]);
        } catch (NumberFormatException e) {
            System.out.println("Error! Not number");
            pw.println("Error! Not number");
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
                pw.println("Operation Error!");
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
                pw.println("Error! Division by zero");
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
           pw.println(result);



       }
        pw.flush();
        pw.close();
    }
}
