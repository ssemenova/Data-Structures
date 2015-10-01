/*
* Sofiya Semenova
* 21a PA1
* sofiya@brandeis.edu
*/
import java.io.*;
import java.util.Scanner;

public class PostfixCalculator {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String exp = "";

    while (!exp.equals("quit")) {
      MyStack<Double> expStack = new MyStack<Double>();
      exp = "";

      while(!exp.equals("clear") && !exp.equals("quit")) {
        System.out.println("Enter number or operator");
        exp = in.next();
        processInput(expStack, exp);
      }
    }
  }

  public static void processInput(MyStack<Double> expStack, String exp) {
    double temp1, temp2, result;

    if (exp.equals("*") || exp.equals("/") || exp.equals("+") || exp.equals("-")) {
      if(expStack.size() == 0 || expStack.size() == 1) {
        System.out.println("Stack has no numbers to perform operations on - input some numbers first!");
      } else {
        temp1 = expStack.pop();
        temp2 = expStack.pop();

        if (exp.equals("*"))
          result = temp2 * temp1;
        else if (exp.equals("/"))
          result = temp2 / temp1;
        else if (exp.equals("+"))
          result = temp2 + temp1;
        else
          result = temp2 - temp1;

        expStack.push(result);
        System.out.println("The current value is: " + result);
      }
    } else if (!exp.equals("clear") && !exp.equals("quit")){
      try {
        expStack.push(Double.parseDouble(exp));
      } catch (java.lang.NumberFormatException e) {
        System.out.println("Not a valid input");
      }
    }
  }
}
