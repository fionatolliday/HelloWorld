import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class World {

    List<Person> people;


    public World(Person person) {
        this.people = new ArrayList<>();

        Person fiona = new Person("Fiona");
        people.add(fiona);

    }

    public boolean checkListForPerson(List<Person> people){
        for (Person person: people) {
            if(person.getName().equals(person)){
                return true;
            }
        } return true;
    }

    public List<Person> addPerson(Person person) {

        for (Person name : people) {
            if (!people.contains(name)){
                people.add(name);
            } else throw new IllegalArgumentException( "Person already exists. Please choose " +
                    "another.");
        }
        return people;
    }

    public List<Person> removePerson(Person person) {
        people.remove(person);
        return people;
    }


    public List<String> listOfNames(List<Person> people){
        List<String> names = new ArrayList<>();

        for (Person person : people) {
            names.add(person.getName());
        }

        return names;
    }

    public String dateTime(){
        LocalDateTime myDateObj = LocalDateTime.now();

        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("hh:mma");
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        String time = myDateObj.format(formattedTime);
        String date = myDateObj.format(formattedDate);

        return " - the time on the server is " + time + " on " + date;
    }


    public String greet(List<String> names) {
//        List<String> names = new ArrayList<>();
//
//        for (Person person : people) {
//            names.add(person.getName());
//        }

        String nameString = names.size() > 1
                ? String.join(", ", names.subList(0, people.size() - 1))
                .concat(String.format("%s and ", people.size() > 2 ? "" : ""))
                .concat(names.get(people.size() - 1))
                : names.get(0);

        return "Hello " + nameString + dateTime();
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