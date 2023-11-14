package ro.scoalainformala;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create addresses
        Address address1 = new Address("Centru");
        Address address2 = new Address("Acasa");
        Address address3 = new Address("In oras");

        // Create hobbies
        Hobby hobby1 = new Hobby("Sala", 3);
        hobby1.addAddress(address1);
        hobby1.addAddress(address2);

        Hobby hobby2 = new Hobby("Inot", 2);
        hobby2.addAddress(address2);
        hobby2.addAddress(address3);

        // Create people
        Person person1 = new Person("Andrei", 30);
        Person person2 = new Person("Cristi", 25);
        Person person3 = new Person("Mihai", 35);

        // Create a HashMap to associate people with their hobbies
        Map<Person, List<Hobby>> personHobbiesMap = new HashMap<>();
        personHobbiesMap.put(person1, Arrays.asList(hobby1, hobby2));
        personHobbiesMap.put(person2, Arrays.asList(hobby1));
        personHobbiesMap.put(person3, Arrays.asList(hobby2));

        // Create TreeSet with custom comparators for sorting
        Comparator<Person> nameComparator = Comparator.comparing(Person::getName);
        Comparator<Person> ageComparator = Comparator.comparingInt(Person::getAge);
        TreeSet<Person> peopleByName = new TreeSet<>(nameComparator);
        TreeSet<Person> peopleByAge = new TreeSet<>(ageComparator);

        peopleByName.addAll(personHobbiesMap.keySet());
        peopleByAge.addAll(personHobbiesMap.keySet());

        // Print people sorted by name
        System.out.println("People Sorted by Name:");
        for (Person person : peopleByName) {
            System.out.println(person);
        }

        // Print people sorted by age
        System.out.println("\nPeople Sorted by Age:");
        for (Person person : peopleByAge) {
            System.out.println(person);
        }

        // Print hobbies and countries where they can be practiced for a certain person (e.g., Alice)
        Person targetPerson = person1;
        System.out.println("\nHobbies of " + targetPerson.getName() + ":");
        List<Hobby> hobbies = personHobbiesMap.get(targetPerson);
        if (hobbies != null) {
            for (Hobby hobby : hobbies) {
                System.out.println("Hobby: " + hobby);
                List<Address> addresses = hobby.getAddresses();
                for (Address address : addresses) {
                    System.out.println("Address: " + address);
                }
            }
        }

    }
}