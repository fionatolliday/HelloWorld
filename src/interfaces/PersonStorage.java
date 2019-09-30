package interfaces;

import model.Person;

import java.util.List;

public interface PersonStorage {

     List<Person> getPeople();

    void addPerson(Person person);

    void changePerson(Person currentPerson, Person newName);

    void removePerson(Person person);

}
