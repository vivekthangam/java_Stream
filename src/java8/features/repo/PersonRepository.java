package java8.features.repo;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonRepository {
    private List<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public List<Person> getAllPersons() {
        return persons;
    }

    public PersonRepository() {
        persons.add(new Person("Alice", 170, 50000, "Female", 0, List.of("Reading", "Painting")));
        persons.add(new Person("Bob", 180, 60000, "Male", 2, List.of("Swimming", "Hiking"), Optional.of(new Address("123 Main St", "New York", "NY", "10001"))));
        persons.add(new Person("Charlie", 175, 55000, "Male", 1, List.of("Cycling", "Cooking")));
        persons.add(new Person("David", 165, 45000, "Male", 3, List.of("Photography", "Gardening"), Optional.of(new Address("456 Oak Ave", "Los Angeles", "CA", "90001"))));
        persons.add(new Person("Emily", 160, 40000, "Female", 2, List.of("Dancing", "Singing")));
        persons.add(new Person("Frank", 185, 70000, "Male", 1, List.of("Golf", "Chess"), Optional.of(new Address("789 Pine Rd", "Chicago", "IL", "60601"))));
        persons.add(new Person("Grace", 168, 48000, "Female", 0, List.of("Yoga", "Meditation")));
        persons.add(new Person("Henry", 175, 60000, "Male", 2, List.of("Running", "Camping"), Optional.of(new Address("567 Elm St", "San Francisco", "CA", "94101"))));
        persons.add(new Person("Isabella", 162, 42000, "Female", 1, List.of("Painting", "Cooking")));
        persons.add(new Person("Jack", 178, 65000, "Male", 0, List.of("Fishing", "Reading"), Optional.of(new Address("234 Cedar Ave", "Miami", "FL", "33101"))));
        persons.add(new Person("Katherine", 170, 52000, "Female", 3, List.of("Writing", "Drawing")));
        persons.add(new Person("Liam", 175, 58000, "Male", 2, List.of("Skiing", "Snowboarding"), Optional.of(new Address("890 Maple Rd", "Seattle", "WA", "98101"))));
        persons.add(new Person("Mia", 163, 45000, "Female", 1, List.of("Swimming", "Shopping")));
        persons.add(new Person("Nathan", 182, 62000, "Male", 1, List.of("Hiking", "Cycling"), Optional.of(new Address("678 Birch St", "Denver", "CO", "80201"))));
        persons.add(new Person("Olivia", 166, 49000, "Female", 0, List.of("Photography", "Travelling")));
        persons.add(new Person("Peter", 177, 68000, "Male", 2, List.of("Gardening", "Cooking"), Optional.of(new Address("456 Oak Ave", "Boston", "MA", "02101"))));
        persons.add(new Person("Quinn", 170, 54000, "Female", 2, List.of("Reading", "Running")));
        persons.add(new Person("Ryan", 180, 100000, "Male", 0, List.of("Golf", "Fishing"), Optional.of(new Address("789 Pine Rd", "Austin", "TX", "73301"))));
        persons.add(new Person("Sophia", 165, 47000, "Female", 1, List.of("Writing", "Painting")));
        persons.add(new Person("Thomas", 178, 63000, "Male", 3, List.of("Camping", "Hiking"), Optional.of(new Address("567 Elm St", "Portland", "OR", "97201"))));
        persons.add(new Person("Ursula", 172, 56000, "Female", 0, List.of("Dancing", "Singing")));

        // Add more persons here as needed
    }


    public Optional<Person> getPersonByName(String name) {
        return persons.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst();
    }

    public List<Person> getPersonsByCity(String city) {
        List<Person> personsByCity = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAddress().isPresent() && person.getAddress().get().getCity().equals(city)) {
                personsByCity.add(person);
            }
        }
        return personsByCity;
    }
}