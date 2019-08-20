import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocalPersonStorage implements PersonStorage {

    private HashMap<String, Person> peopleMap;


    public LocalPersonStorage() {
        this.peopleMap = new HashMap<>();
    }


    @Override
    public List<Person> getPeople() {
        return new ArrayList<>(peopleMap.values());
    }


    @Override
    public void addPerson(Person person) {
        if (peopleMap.containsKey(person.getName())) {
            throw new IllegalArgumentException("Person already exists. Please choose " +
                    "another.");
        }
        if (isNameFieldEmpty(person)) {
            throw new IllegalArgumentException("No name added. Please type a name");
        } else peopleMap.put(person.getName(), person);
        System.out.println("OK, person/s added");
    }

    @Override
    public void changePerson(Person currentPerson, Person newName) {
        removePerson(currentPerson.getName());
        try {
            addPerson(newName);
        } catch (Exception e) {
            throw new IllegalArgumentException("No name added. Please type a name");
        }
    }

    @Override
    public void removePerson(String name) {
        if(name.equals("fiona")) {
            throw new IllegalArgumentException(
                    "Fiona cannot be deleted or changed");
        }

       if (peopleMap.containsKey(name)) {
            peopleMap.remove(name.toLowerCase());
        } else throw new IllegalArgumentException(
                "Person does not exist");
    }

    private boolean isNameFieldEmpty(Person personName) {
        String name = personName.getName();
        if (name.isEmpty()) {
            return true;
        }
        return false;
    }
}
