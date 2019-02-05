//Student Name: Neyir Erdeser
//Student Number: 260736004
import java.util.NoSuchElementException;
public class Hotel {
  private String name;
  private Room[]rooms;
  private Reservation[]reservations = new Reservation[0];
  // i set this array to length 0 for now
  // so when creating new arrays that are longer or shorter than this one it will not cause a NullPointerException
  
  // constructor to create a hotel with given name and a list of rooms
  public Hotel(String name, Room[]list) {
    this.name = name;
    Room[]rooms = new Room[list.length];
    for(int i=0; i<rooms.length; i++) {
      rooms[i] = list[i];
    }
    this.rooms = rooms;
  }
  // get method for the privte attribute, name
  private String getName() {
    return this.name;
  }
  // method to create an array 1 slot longer than the reservations attributes length
  // it copyies the whole reservations array into the new one,
  // and places the new reservation to the end of the array,
  // then assignes the new array to the attribute reservations
  private void addReservation(Reservation newReserv) {
    Reservation[]reservs = new Reservation[this.reservations.length+1];
    for(int i=0; i<this.reservations.length; i++) {
      reservs[i] = this.reservations[i];
    }
    reservs[reservs.length-1] = newReserv;
    this.reservations = reservs;
  }
  // method to create an array 1 slot shorter than the reservations attributes length
  // ONLY IF theres a reservation that matches the given criteria
  private void removeReservation(String name, String type) {
    // first find where the reservation is 
    // or wheter it exists. if it does not, the indexToBeCanceled value will stay -1
    // if it does, the for loop will change its value to the appropriate index number to be used later
    // and the room of the reservations availibility will be changed (to free/true)
    int indexToBeCanceled = -1;
    for(int i=0; i<this.reservations.length; i++) {
      if (reservations[i].getName().equals(name)&&reservations[i].getRoom().getType().equals(type)) {
        indexToBeCanceled = i;
        reservations[i].getRoom().changeAvailability();
        break;
      }
    }
    // if the reservation isn't there (indexToBeCanceled isn't assigned to be any valid index number), throw exception
    if(indexToBeCanceled<0)
      throw new NoSuchElementException("No reservation found.");
    // otherwise start the removal part - (it will simmply skip the element at that index while copying to the new array)
    Reservation[]reservs = new Reservation[this.reservations.length-1];
    // store the same reservartions into the new list upto the point you need to remove (skip) one
    int j=0;
    while(j<indexToBeCanceled) {
      reservs[j] = reservations[j];
      j++;
    }
    // then skip one in reservations and keep storing the rest
    for (int i=indexToBeCanceled; i<reservs.length; i++) {
      reservs[i] = reservations[i+1];
    }
    // assign the new array to the attribute
    this.reservations = reservs;
  }
  // method to create a reservation by using the addReservation method
  // checks whether the reservation can be made or not
  // gives an error message or makes the reservation and displays an info message accordingly
  public void createReservation(String name, String type) {
    if (Room.findAvailableRoom(this.rooms, type) == null)
      System.out.println("Sorry "+name+", we have no available rooms of the desired type.");
    else {
      Reservation newReserv = new Reservation(Room.findAvailableRoom(this.rooms, type), name);
      Room.findAvailableRoom(this.rooms, type).changeAvailability();
      addReservation(newReserv);
      System.out.println("\nYou have successfully reserved a "+type+" room under the name of "+name+". We look forward having you at "+getName()+"!");
    }    
  }
  // method to cancel a reservation by using the removeReservation method
  // checks whether the reservation exists or not
  // gives an error message or cancels the reservation and displays an info message accordingly
  public void cancelReservation(String name, String type) {
    try {
      removeReservation(name, type);   
      System.out.println("\n"+name+", your reservation for a "+type+" room has been successfully cancelled.");
    } catch (NoSuchElementException e) {
      System.out.println("There's no reservation for a "+type+" room under the name of "+name+".");
    }
  }
  // adds the prices of the reserved rooms for a given name
  // displays how much the person owes to the hotel
  public void printInvoice(String name) {
    double owes = 0;
    for(int i=0; i<reservations.length; i++) {
      if(reservations[i].getName().equals(name))
        owes += reservations[i].getRoom().getPrice();
    }
    if(owes==0)
      System.out.println("No reservations have been made at this name.");
    else
      System.out.println(name+"'s invoice is of $"+owes);
  }
  // counts how many available rooms there is of each type in a hotel
  // displays the hotel name and the number of available rooms
  public String toString() {
    int d = 0;
    int q = 0;
    int k = 0;
    for(int i=0; i<this.rooms.length; i++) {
      if (rooms[i].getType().equals("double")&&rooms[i].getAvailability())
        d++;
      else if (rooms[i].getType().equals("queen")&&rooms[i].getAvailability())
        q++;
      else if (rooms[i].getType().equals("king")&&rooms[i].getAvailability())
        k++;
    }
    return "Hotel Name \t: "+this.name+"\nAvailable Rooms\t: "+d+" double, "+q+" queen, "+k+" king.";
  }
}