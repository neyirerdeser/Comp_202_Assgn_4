//Student Name: Neyir Erdeser
//Student Number: 260736004
public class Reservation {
  private String name;
  private Room roomReserved;
  
  // constructor to assign attributes to desired values
  public Reservation(Room roomWanted, String costumerName) {
    this.name = costumerName;
    this.roomReserved = roomWanted;
  }
  // get methods for the attributes - since they're private
  public String getName() {
    return this.name;
  }
  public Room getRoom() {
    return this.roomReserved;
  }
}