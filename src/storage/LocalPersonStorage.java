package storage;

import interfaces.PersonStorage;
import model.Person;

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

        if (isNameValid(newName)) {

            try {
                removePerson(currentPerson);
            } catch (Exception e) {
                throw new IllegalArgumentException("Person does not exist to change. Please try " +
                        "another name.");
            }
        }
            try {
                addPerson(newName);
            } catch (Exception e) {
                if (isNameFieldEmpty(newName)) {
                    throw new IllegalArgumentException("No name added. Please type a name");
                } else if (peopleMap.containsKey(newName.getName())) {
                    throw new IllegalArgumentException("Person already exists. Please choose " +
                            "another.");
                }
            }
    }

    @Override
    public void removePerson(Person person) {
        String name = person.getName();

        if(name.equals("fiona")) {
            throw new IllegalArgumentException(
                    "Fiona cannot be deleted or changed");
        }

       if (peopleMap.containsKey(name)) {
            peopleMap.remove(name);
        } else throw new IllegalArgumentException(
                "Person does not exist");
    }

    private boolean isNameValid(Person specifiedName) {
        String name = specifiedName.getName();

        if (isNameFieldEmpty(specifiedName)) {
            return false;
        }
        if (name == "fiona") {
            return false;
        }
        if (peopleMap.containsKey(name)) {
            return false;
        }
        return true;
    }

    private boolean isNameFieldEmpty(Person personName) {
        String name = personName.getName();
        if (name.isEmpty()) {
            return true;
        }
        return false;
    }

}
