import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/*
* Sofiya Semenova
* 21a PA1
* sofiya@brandeis.edu
*/
import java.io.*;
import java.util.Scanner;

public class DuckDuckGoose {
  public static void main(String[] args) throws FileNotFoundException {
    MyCircularLinkedList<String> circle = new MyCircularLinkedList<String>();
    inputPlayers(circle);
    playGame(circle);
  }

  public static void inputPlayers(MyCircularLinkedList<String> circle) {
    try {
      Scanner readCircle = new Scanner(new File("Circle.txt"));

      while (readCircle.hasNext())
        circle.insert(readCircle.next());
    } catch (FileNotFoundException e) {
      System.out.println("Circle.txt not found");
    }
  }

  public static void playGame(MyCircularLinkedList<String> circle) {
    try {
      Scanner readGame = new Scanner(new File("Game.txt"));
      String temp;
      String it = readGame.next();

      while (readGame.hasNextInt()) {
        temp = circle.shiftNodeTo(readGame.nextInt());
        circle.setValueOfCurrent(it);
        it = temp;
      };

      System.out.println(it + " is it!");
      System.out.println(circle.toString());
    } catch (FileNotFoundException e) {
      System.out.println("Game.txt not found");
    }
  }

}
