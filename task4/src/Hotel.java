public class Hotel {
    private String name;
    private Guest[] guests;

    public Hotel(String name, Guest[] guests) {
        this.name = name;
        this.guests = guests;
    }

    public String getName() {
        return name;
    }

    public Guest[] getGuests() {
        return guests;
    }

    public Guest findGuestById(long id) {
        for (Guest guest : guests) {
            if (guest.getId() == id) {
                return guest;
            }
        }
        return null;
    }

    public void addGuest(Guest guest) {
        Guest[] newGuests = new Guest[guests.length + 1];
        for (int i = 0; i < guests.length; i++) {
            newGuests[i] = guests[i];
        }
        newGuests[guests.length] = guest;
        guests = newGuests;
    }

    public void removeGuestById(long id) {
        Guest[] newGuests = new Guest[guests.length - 1];
        int index = 0;
        for (Guest guest : guests) {
            if (guest.getId() != id) {
                newGuests[index] = guest;
                index++;
            }
        }
        guests = newGuests;
    }

}
