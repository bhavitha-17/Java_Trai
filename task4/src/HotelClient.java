public class HotelClient {
    public static void main(String[] args) {
        Guest[] guests = new Guest[2];
        guests[0] = new Guest(1, "John", "Doe", "john.doe@example.com");
        guests[1] = new Guest(2, "Jane", "Doe", "jane.doe@example.com");

        Hotel hotel = new Hotel("My Hotel", guests);

        // Find a guest by ID
        Guest guest = hotel.findGuestById(1);
        System.out.println(guest.getFirstName() + " " + guest.getLastName());

        // Add a new guest
        Guest newGuest = new Guest(3, "Peter", "Parker", "peter.parker@example.com");
        hotel.addGuest(newGuest);

        // Remove a guest
        hotel.removeGuestById(2);

        // Print all guests
        Guest[] allGuests = hotel.getGuests();
        for (Guest g : allGuests) {
            System.out.println(g.getFirstName() + " " + g.getLastName());
        }
    }
}