//Student Name: Neyir Erdeser
//Student Number: 260736004
public class Room {
  private String type;
  private double price;
  private boolean availability;
  
  public Room(String type) {
    // setting all the attributes inside the if blocks,
    // so they ONLY get assigned IF the word for the type is valid (double, queen or king)
    // throws the exception if none of the words match the criteria
    if (type.equals("double")) {
      this.type = type;
      this.price = 90;
      this.availability = true;
    } else if (type.equals("queen")) {
      this.type = type;
      this.price = 110;
      this.availability = true;
    } else if (type.equals("king")) {
      this.type = type;
      this.price = 150;
      this.availability = true;
    } else
      throw new IllegalArgumentException("room type is not supported");
  }
  // get methods for all the attributes (because they're private)
  public String getType() {
    return this.type;
  }
  public double getPrice() {
    return this.price;
  }
  public boolean getAvailability() {
    return this.availability;
  }
  // this method will change the availability from available to unavailable and from unavailable to available
  public void changeAvailability() {
    this.availability = !this.availability;
  }
  // returns the first room in the given type that is available
  public static Room findAvailableRoom(Room[]rooms, String type) {
    for(int i=0; i<rooms.length; i++) {
      if (rooms[i].type.equals(type)&&rooms[i].availability)
        return rooms[i];
    }
    // if the code reaches this point (doesnt return a room in the loop)
    // it means there isnt a room available in that type
    return null;
  }
}