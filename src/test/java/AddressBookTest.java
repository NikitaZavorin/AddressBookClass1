import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressBookTest {
    @Test
    public void testAddPerson() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson("Заворин", "Екатериненская", 6, 5);
        Address address = addressBook.getAddress("Заворин");
        assertEquals("Екатериненская", address.getStreet());
        assertEquals(6, address.getHouseNumber());
        assertEquals(5, address.getApartmentNumber());
    }

    @Test
    public void testGetAddress() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson("Заворин", "Екатериненская", 6, 5);
        Address address = addressBook.getAddress("Заворин");
        assertEquals("Екатериненская", address.getStreet());
        assertEquals(6, address.getHouseNumber());
        assertEquals(5, address.getApartmentNumber());
    }

    @Test
    public void testDeletePerson() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson("Заворин", "Екатериненская", 6, 5);
        addressBook.deletePerson("Заворин");
        assertEquals(null, addressBook.getAddress("Заворин"));
    }

    @Test
    public void testChangeAddress() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson("Заворин", "Екатериненская", 6, 5);
        Address address = addressBook.getAddress("Заворин");
        addressBook.changeAddress("Заворин", "Стрижова", 1, 40);
        assertEquals("Стрижова", address.getStreet());
    }

    @Test
    public void testGetPeopleOnStreet() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson("Заворин", "Екатериненская", 6, 5);
        addressBook.addPerson("Зенкин", "Стрижова", 1, 40);
        addressBook.addPerson("Казанников", "Екатериненская", 6, 13);
        assertEquals(List.of("Заворин", "Казанников"), addressBook.getPeopleOnStreet("Екатериненская"));
    }

    @Test
    public void testGetPeopleOnHouse() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson("Заворин", "Екатериненская", 6, 5);
        addressBook.addPerson("Зенкин", "Стрижова", 1, 40);
        addressBook.addPerson("Казанников", "Екатериненская", 6, 13);
        assertEquals(List.of("Заворин", "Казанников"), addressBook.getPeopleOnHouse(6));
    }
}
