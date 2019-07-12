import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class World {

    List<Person> people;


    public World(Person person) {
        this.people = new ArrayList<>();

        Person fiona = new Person("Fiona");
        people.add(fiona);

    }

    public List<Person> addPerson(Person person) {
        people.add(person);
        return people;
    }

    public List<Person> removePerson(Person person) {
        people.remove(person);
//        int indexOfPersonToRemove = people.indexOf(name);
//        people.remove(indexOfPersonToRemove);

        return people;
    }


    public String greet(List<Person> people) {
        List<String> names = new ArrayList<>();

        for (Person person : people) {
            names.add(person.getName());
        }

        String nameString = names.size() > 1
                ? String.join(", ", names.subList(0, people.size() - 1))
                .concat(String.format("%s and ", people.size() > 2 ? "" : ""))
                .concat(names.get(people.size() - 1))
                : names.get(0);

        return "Hello " + nameString + " - the time on the server is 10:48pm on 14 March 2018";
    }


}


//    int num = 8;
//    String msg = "";
//          if(num > 10) {
//        msg = "Number is greater than 10";
//        }
//        else {
//        msg = "Number is less than or equal to 10";
//        }

//    final String msg = num > 10
//            ? "Number is greater than 10"
//            : "Number is less than or equal to 10";