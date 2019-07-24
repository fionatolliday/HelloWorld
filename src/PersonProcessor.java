import java.util.ArrayList;
import java.util.List;

public class PersonProcessor {


    public List<Person> addPerson(List<Person> people, Person person) {
        if (isPersonInList(people, person)) {
            throw new IllegalArgumentException("Person already exists. Please choose " +
                    "another.");
        }
        else people.add(person);

        return people;
    }

    public List<Person> removePerson(List<Person> people, Person person) {
        people.remove(person);
        return people;
    }

    private int getIndexOfPerson(List<Person> people, Person currentName){
        int indexOfName = people.indexOf(currentName);

        return indexOfName;
    }


    public List<Person> changePersonName(List<Person> people, Person currentPerson,
                                         Person newName) {
 
        people.set(getIndexOfPerson(people, currentPerson), newName);

        return people;
    }

    public boolean isPersonInList(List<Person> people, Person person) {
        return people.contains(person);
    }


}
