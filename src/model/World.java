package model;
import interfaces.DateTimeInterface;
import interfaces.PersonStorage;
import java.util.ArrayList;
import java.util.List;

public class World {

    private PersonStorage storage;
    private DateTimeInterface dateTime;

    public World(PersonStorage storage, DateTimeInterface dateTime) {
        this.storage = storage;
        this.dateTime = dateTime;
        Person fiona = new Person("fiona");
        this.storage.addPerson(fiona);
    }

    public List<String> getNamesOfPeople() {
        List<String> names = new ArrayList<>();
        for (Person person : storage.getPeople()) {
            String name = person.getName();
            names.add(name);
        }
        return names;
    }

    public String greet() {
        List<String> names = getNamesOfPeople();
        int numberOfNamesStored = names.size();


        if (numberOfNamesStored == 2) {
            String twoNamesInArray = String.join(" and ", names);
            return "Hello " + twoNamesInArray + dateTime.getDateTime();
        }

        if (numberOfNamesStored > 2) {

            int indexOfFinalName = names.size() - 1;
            List<String> arrayMinusFinalName = names.subList(0, names.size() - 1);
            String namesMinusFinal = String.join(", ", arrayMinusFinalName);
            String finalName = names.get(indexOfFinalName);

            return "Hello " + namesMinusFinal + " and " + finalName + dateTime.getDateTime();
        }

        else {
            String firstName = names.get(0);
            return "Hello " + firstName + dateTime.getDateTime();
        }
    }


    @Override
    public String toString() {
        return "World{" +
                "storage=" + storage.getPeople() +
                ", dateTime=" + dateTime.getDateTime() +
                '}';
    }


    public PersonStorage getPersonStorage() {
        return storage;
    }

}
