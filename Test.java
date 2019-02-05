public class Test {
  public static void main(String []args) {
    // ROOM
    Room rr1 = new Room("king");
    Room rr2 = new Room("queen");
    Room rr3 = new Room("double");
    //rr3.changeAvailability();
    Room[]rooms = {rr1,rr2,rr3};
    Room rr4 = Room.findAvailableRoom(rooms, "queen");
    System.out.println(rr1.getType());
    System.out.println(rr1.getPrice());
    System.out.println(rr1.getAvailability());
    System.out.println(rr2.getType());
    System.out.println(rr2.getPrice());
    System.out.println(rr2.getAvailability());
    System.out.println(rr3.getType());
    System.out.println(rr3.getPrice());
    System.out.println(rr3.getAvailability());
    System.out.println(rr4.getType());
    System.out.println(rr4.getPrice());
    System.out.println(rr4.getAvailability());
    // RESERVATION
    Reservation rs1 = new Reservation(rr1, "neyir");
    Reservation rs2 = new Reservation(Room.findAvailableRoom(rooms, "queen"), "john");
    Reservation rs3 = new Reservation(rr3, "baran");
    // HOTEL
    Hotel h = new Hotel("paradise",rooms);
    System.out.println(h);
    h.createReservation("neyir", "king");
    h.createReservation("baran", "queen");
    h.createReservation("baran", "double");   
    h.cancelReservation("neyir","king");
    h.printInvoice("baran");
    System.out.println(h);

    
  }
  // array printer
  public static void print(Reservation[]a) {
      for(int i=0; i<a.length; i++) {
        System.out.println(i+1+". "+a[i]);
      }
    }
}