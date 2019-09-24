package model;
import interfaces.DateTimeInterface;
import interfaces.PersonStorage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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


//    public String dateTime() {
//        LocalDateTime myDateObj = LocalDateTime.now();
//
//        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("hh:mma");
//        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd MMMM yyyy");
//
//        String time = myDateObj.format(formattedTime);
//        String date = myDateObj.format(formattedDate);
//
//        return " - the time on the server is " + time + " on " + date;
//    }



    public String greet() {
        List<String> names = getNamesOfPeople();
        List<Person> people = storage.getPeople();
        String nameString = names.size() > 1
                ? String.join(", ", names.subList(0, people.size() - 1))
                .concat(String.format("%s and ", people.size() > 2 ? "" : ""))
                .concat(names.get(people.size() - 1))
                : names.get(0);

        return "Hello " + nameString + dateTime.getDateTime();
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
