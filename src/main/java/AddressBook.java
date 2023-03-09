import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBook {
    private Map<String, Address> book;

    public AddressBook() {
        book = new HashMap<>();
    }

    public void addPerson(String surname, String street, int houseNumber, int apartmentNumber) {
        Address address = new Address(street, houseNumber, apartmentNumber);
        book.put(surname, address);
    }

    public void deletePerson(String surname) {
        book.remove(surname);
    }

    public void changeAddress(String surname, String street, int houseNumber, int apartmentNumber) {
        Address address = book.get(surname);
        address.setStreet(street);
        address.setHouseNumber(houseNumber);
        address.setApartmentNumber(apartmentNumber);
    }

    public Address getAddress(String surname) {
        return book.get(surname);
    }

    public List<String> getPeopleOnStreet(String street) {
        List<String> people = new ArrayList<>();
        for (Map.Entry<String, Address> entry : book.entrySet()) {
            if (entry.getValue().getStreet().equals(street)) {
                people.add(entry.getKey());
            }
        }
        return people;
    }

    public List<String> getPeopleOnHouse(int houseNumber) {
        List<String> people = new ArrayList<>();
        for (Map.Entry<String, Address> entry : book.entrySet()) {
            if (entry.getValue().getHouseNumber() == houseNumber) {
                people.add(entry.getKey());
            }
        }
        return people;
    }
}
//A KAK