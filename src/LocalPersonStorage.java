import java.util.ArrayList;
import java.util.List;

public class LocalPersonStorage implements PersonStorage {

    private List<Person> people;


    public LocalPersonStorage(){
        this.people = new ArrayList<>();
    }


    @Override
    public List<Person> getPeople() {
        return people;
    }


    @Override
    public void addPerson(Person person) {
        if (isPersonInList(people, person)) {
            throw new IllegalArgumentException("Person already exists. Please choose " +
                    "another.");
        }
        else people.add(person);
    }

    @Override
    public void changePerson(Person currentPerson, Person newName) {
        people.set(getIndexOfPerson(people, currentPerson), newName);
    }

    @Override
    public void removePerson(Person person) {
        people.remove(person);
    }


    private int getIndexOfPerson(List<Person> people, Person currentName){
        return people.indexOf(currentName);
    }


    private boolean isPersonInList(List<Person> people, Person person) {
        return people.contains(person);
    }


}
