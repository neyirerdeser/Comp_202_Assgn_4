import java.util.Scanner;
import java.util.Random;
public class BookingSystem {  
  private static String[] typeOfRooms = {"double","queen","king"};
  private static Random r = new Random(123);
  //returns a random String from the above array. 
  private static String getRandomType(){
    int index = r.nextInt(typeOfRooms.length);
    return typeOfRooms[index];
  }
  //returns a random number of rooms between 5 and 50.
  private static int getRandomNumberOfRooms(){
    return r.nextInt(50)+1;
  }
  //End of provided code. 
  
  public static void main(String[] args){
    //Student Name: Neyir Erdeser
    //Student Number: 260736004
    
    // starting point
    // gets the name of the hotel
    // creates the hotel with given name and random number of room types
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to the COMP202 booking system");
    System.out.println("Please enter the name of the hotel you'd like to book");
    String hotelName = sc.nextLine();
    Room[]rooms = new Room[getRandomNumberOfRooms()];
    for(int i=0; i<rooms.length; i++) {
      Room r =  new Room(getRandomType());
      rooms[i] = r;
    }
    Hotel h = new Hotel(hotelName,rooms);
    // now that we have the hotel ready, we're going into the system's functions
    int choice = 0;
    // the loop will only exit if the user chooses the number assigned to exit option (5)
    // otherwise, if they enter an invalid number, the system will simply keep asking by displaying the options again
    // when a valid number is entered, 
    // it will go into the relative if block, 
    // ask user to give neccessary information using Scanner -if needed any
    // and call the appropriate method
    while(choice!=5) {
      welcomePage(hotelName);
      choice = sc.nextInt();
      if (choice == 1) {
        sc.nextLine();
        System.out.print("\nPlease enter your name: ");
        String name = sc.nextLine();
        System.out.print("\nWhat type of room would you like to reserve? ");
        String type = sc.nextLine();
        h.createReservation(name,type);
      } else if (choice == 2) {
        sc.nextLine();
        System.out.println("Please enter the name you used to make the reservation ");
        String name = sc.nextLine();
        System.out.println("What type of room did you reserve? ");
        String type = sc.nextLine();
        h.cancelReservation(name,type);
      } else if (choice == 3) {
        sc.nextLine();
        System.out.println("Please enter your name: ");
        String name = sc.nextLine();
        h.printInvoice(name);
      } else if (choice == 4) {
        System.out.println("Here is the hotel info\n"+h);
      }
    }
    // once the loop exits, the Scanner will be closed, goodbye message will be displayed and the code will quit
    sc.close();
    System.out.println("It was a pleasure doing business with you!");
  }
  // private helper method for the welcome screen
  private static void welcomePage(String hotelName) {
    System.out.println("\n\n*********************************************************************");
    System.out.println("Welcome to "+hotelName+". Chose one of the following options:");
    System.out.println("1) Make a reservation");
    System.out.println("2) Cancel a reservation");
    System.out.println("3) See an invoice");
    System.out.println("4) See hotel info");
    System.out.println("5) Exit the Booking System");
    System.out.println("*********************************************************************\n\n");
  }
}