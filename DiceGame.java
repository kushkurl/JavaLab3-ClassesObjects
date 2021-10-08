//Kushagra Kurl
//A00246944
//MAPD: MOBILE APPLICATION DEVELOPMENT - fall 2021
//This is JAV-1001 - 91349 - App Development for Android - 202109 - 001 lab 3 - Classes/ Objects

import java.util.Scanner;
import java.util.Random;

class die {
  private String type;
  public int noOfSides;
  public int current_side;

  //default constructor
  public die() {
    noOfSides = 6;
    type = "d" + 6;
    current_side = (int)Math.floor(Math.random()*(6)+1);
  }

  //parameterized constructor with 1 parameters
  public die(int sides) {
    noOfSides = sides;
    type = "d" + sides;
    current_side = (int)Math.floor(Math.random()*(sides)+1);
  }

  //parameterized constructor with 2 parameters
  public die(int sides, int randomSide) {
    noOfSides = sides;
    type = "d" + sides;
    current_side = randomSide;
  }

//class method to display die properties
  public void displayDieProperties() {
    System.out.println("This is a " + this.type + " die.");
    System.out.println("It has " + this.noOfSides + " sides.");
    System.out.println("Current side of the die is: " + this.current_side);
  }

  //function to roll a die
  public void rollDice() {
    this.current_side = (int)Math.floor(Math.random()*(this.noOfSides)+1);
  }
}

public class DiceGame {
  public static void main(String[] args) {
    System.out.println("Creating a default d6 die....");
    die d1 = new die();
    System.out.println("Creating a d8 die....");
    die d2 = new die(8);
    System.out.println("Creating another d12 die....");
    die d3 = new die(12,3);
    //displaying die properties
    d1.displayDieProperties();
    d2.displayDieProperties();
    d3.displayDieProperties();

    System.out.println("Do you wish to change number of sides for a die? y/n");
    Scanner sin = new Scanner(System.in);
    String str = sin.next();
    char choice = str.charAt(0);

    //changing die face and sides
    if(choice == 'y'){
      System.out.println("Please enter the number of sides: ");
      int newSides = sin.nextInt();
      d1.noOfSides = newSides;
      d1.displayDieProperties();
      //d1.type = "d" + newSides;
      //this will not work as type attribute of class die is private and cannot be accessed outised of the class
      System.out.println("Warning die type and number of sides miss match!");
    }

    //rolling each of the three die and display new UP side
    System.out.println("Rolling d" + d1.noOfSides + " Die");
    d1.rollDice();
    System.out.println("New value of die d" + d1.noOfSides + " is " + d1.current_side);

    System.out.println("Rolling d" + d2.noOfSides + " Die");
    d2.rollDice();
    System.out.println("New value of die d" + d2.noOfSides + " is " + d2.current_side);

    System.out.println("Rolling d" + d3.noOfSides + " Die");
    d3.rollDice();
    System.out.println("New value of die d" + d3.noOfSides + " is " + d3.current_side);

    //YAHTZEE! Game
    //creating 5 d6 die and roll them to get YAHTZEE!
    System.out.println("Creating 5 d6 die");
    die[] d = new die[5];
    //initializing each object
    d[0] = new die();
    d[1] = new die();
    d[2] = new die();
    d[3] = new die();
    d[4] = new die();
    int numberOfRolls = 1;
    boolean isBingo = false;
    //running this loop till we get all the faces same for 5 dies
    while(!isBingo) {
      d[0].rollDice();
      d[1].rollDice();
      d[2].rollDice();
      d[3].rollDice();
      d[4].rollDice();
      if((d[0].current_side == d[1].current_side) && (d[0].current_side == d[2].current_side) && (d[0].current_side == d[3].current_side)  && (d[0].current_side == d[4].current_side))
        isBingo = true;
      numberOfRolls++;
    }
    System.out.println("YAHTZEE! It took " + numberOfRolls + " rolls");
  }
}
