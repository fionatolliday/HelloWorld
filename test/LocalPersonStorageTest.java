import model.Person;
import org.junit.Assert;
import org.junit.Test;
import storage.LocalPersonStorage;

import java.util.Arrays;
import java.util.List;

public class LocalPersonStorageTest {

    LocalPersonStorage storage = new LocalPersonStorage();

    @Test
    public void whenTwoOrMorePeopleInArray_ShouldRemoveOnePerson() {
        Person Renae = new Person("Renae");
        Person Bianca = new Person("Bianca");

        storage.addPerson(Renae);
        storage.addPerson(Bianca);

        storage.removePerson("renae");


        List<Person> expectedListOfPeople = Arrays.asList(Bianca);
        List<Person> actualListOfPeople = storage.getPeople();

        Assert.assertEquals(expectedListOfPeople, actualListOfPeople);
    }

}