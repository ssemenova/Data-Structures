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

public class Mailroom {
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

  public static double removePerson(MyQueue<Integer> queue, double sum, double time) {
    if (!queue.empty())
      sum += time - queue.dequeue() - 5;

    return sum;
  }

  public static void addPerson(MyQueue<Integer> queue, int nextPerson, Scanner readFile, int time) {
    while (nextPerson <= time && readFile.hasNext()) {
      if (queue.size() < 10)
        queue.enqueue(nextPerson);
      nextPerson = readFile.nextInt();
    }
  }

  public static double remainder(MyQueue<Integer> queue, int time) {
    int sum = 0;

    while (!queue.empty()) {
      sum += time - queue.dequeue();
      time += 5;
    }

    return sum;
  }
}
