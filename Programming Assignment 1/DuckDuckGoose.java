/**
* Sofiya Semenova
* 21a PA1
* sofiya@brandeis.edu
*/
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

import java.io.*;
import java.util.Scanner;

/**
* Class DuckDuckGoose is the client code for problem 3.
* The class plays a game of duck duck goose, taking a circle of people
* and their movements around the circle from two files and outputting the final position of everyone.
* I use a circularly linked list to create the circle of people
* because order doesn't really matter in our circle. We have the position that Sandro starts at
* but after that, it's a circle without an end and people need to be able to freely move in either direction
* of the circle, and potentially multiple revolutions around the circle.
*/
public class DuckDuckGoose {
  /* @param: none
  * @return: none
  * Runtime: O(1)
  * The main method just creates a circularly linked list called circle
  * then calls the method inputPlayers to input the circle of players based off of circle.txt
  * and then calls playGame to actually play the game.
  */
  public static void main(String[] args) throws FileNotFoundException {
    MyCircularLinkedList<String> circle = new MyCircularLinkedList<String>();
    inputPlayers(circle);
    playGame(circle);
  }

  /**
  * @param: MyCircularLinkedList<String>
  * @return: void
  * Runtime: O(n), with n being the amount of people in the circle
  * InputPlayers uses a scanner to read the file circle.txt
  * and adds each person to the list.
  */
  public static void inputPlayers(MyCircularLinkedList<String> circle) {
    try {
      Scanner readCircle = new Scanner(new File("Circle.txt"));

      while (readCircle.hasNext())
        circle.insert(readCircle.next());
    } catch (FileNotFoundException e) {
      System.out.println("Circle.txt not found");
    }
  }

  /**
  * @param: MyCircularLinkedList<String>
  * @return: void
  * Runtime: O(n), with n being the amount of numbers (amount of switches caused by a goose) in game.txt
  * PlayGame reads the file game.txt, moves the current "it" over as many times as the file says, and then swaps "it" with the person at that node
  * It then prints out the last "it" and the circle of people.
  */
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
