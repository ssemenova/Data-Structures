/**
* Sofiya Semenova
* 21a PA1
* sofiya@brandeis.edu
*/
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
* Class DuckDuckGoose is the client code for problem 2.
* This program simulates a queue at the mailroom. To simulate the queue, I used a queue :)
* Since people enter the line in the back, but can only leave the line when they are at the front.
*/
public class Mailroom {
  /* @param: none
  * @return: none
  * Runtime: O(1)
  * The main method creates a scanner, calls simulation, and outputs the answer.
  */
  public static void main(String[] args) throws FileNotFoundException {
    Scanner console = new Scanner(System.in);
    System.out.println("Usdan Mailroom Simulation");
    System.out.print("  Please specify the input file: ");
    String fileName = console.next();

    try {
      Scanner readFile = new Scanner(new File(fileName));

      double results = simulation(readFile);

      System.out.println("Here are the results of the simulation: ");
      System.out.println("Average wait time: " + results);
    } catch (FileNotFoundException e ) {
      System.out.println("File not found");
    }
  }

  /* @param: Scanner
  * @return: double
  * Runtime: O(n) where n is the number of people who attempt to enter the queue
  * This method reads the file, enqueues a person when they arrive if there is room for them,
  * and dequeues the first person in the queue when five seconds have passed.
  */
  public static double simulation(Scanner readFile){
    MyQueue<Integer> queue = new MyQueue<Integer>();
    double sum = 0;
    int time = 0;
    int nextPerson;

    while (readFile.hasNextInt()) {
      nextPerson = readFile.nextInt();
      sum = removePerson(queue, sum, time);
      addPerson(queue, nextPerson, readFile, time);
      time += 5;
    }

    sum += remainder(queue, time);

    System.out.println(queue.count());
    return sum / queue.count();
  }

  /* @param: MyQueue<Integer>, double, double
  * @return: double
  * Runtime: O(1)
  * This method basically dequeues the first person, calculates the time they spent waiting, and returns the new sum.
  */
  public static double removePerson(MyQueue<Integer> queue, double sum, double time) {
    if (!queue.empty())
      sum += time - queue.dequeue() - 5;

    return sum;
  }

  /* @param: MyQueue<Integer>, int, scanner, time
  * @return: double
  * Runtime: O(n) where n is the number of people who arrive at the current time
  * This method basically enqueues everyone who arrives at the current time (which may be more than one person)
  * and keeps reading the file until no more new people show up.
  */
  public static void addPerson(MyQueue<Integer> queue, int nextPerson, Scanner readFile, int time) {
    while (nextPerson <= time && readFile.hasNext()) {
      if (queue.size() < 10)
        queue.enqueue(nextPerson);
      nextPerson = readFile.nextInt();
    }
  }

  /* @param: MyQueue<Integer>, int
  * @return: double
  * Runtime: O(n) where n is the number of people left in the queue
  * After people have stopped arriving and attempting to get in line, there are still people left in the line that need to be served
  * So all this method does is increment time, dequeue the first person every 5 seconds, and count the sum.
  */
  public static double remainder(MyQueue<Integer> queue, int time) {
    double sum = 0;

    while (!queue.empty()) {
      sum += time - queue.dequeue();
      time += 5;
    }

    return sum;
  }
}
