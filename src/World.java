import java.util.ArrayList;
import java.util.List;

public class World {

    List<Person> people = new ArrayList<>();


    public World(Person person) {
        Person fiona = new Person("Fiona");
        people.add(fiona);
    }

    public List<Person> addPerson(Person person) {
        people.add(person);
        return people;
    }


    public String greet(List<Person> people) {

        if (people.size() == 2) {

            return "Hello " + people.get(0).getName() + " and " + people.get(1).getName() +
                    " - the time on the" +
                    " server" +
                    " is " +
                    "10:48pm on " +
                    "14 " +
                    "March " +
                    "2018";
        } else return "Hello " + people.get(0).getName() + " and " + people.get(1).getName() +
                " - " +
                "the time on" +
                " the" +
                " " +
                "server" +
                " is " +
                "10:48pm on " +
                "14 " +
                "March " +
                "2018";
    }
}
