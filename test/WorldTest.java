import interfaces.DateTimeInterface;
import model.MockDateTimeTest;
import model.Person;
import model.World;
import org.junit.Assert;
import org.junit.Test;
import storage.LocalPersonStorage;


public class WorldTest {

    private LocalPersonStorage storage = new LocalPersonStorage();
    private DateTimeInterface dateTime = new MockDateTimeTest();
    private World world = new World(storage, dateTime);



    @Test
    public void shouldGreetPersonByName_WhenThereIsOnePersonInWorld() {

        String expectedGreeting = "Hello fiona - the time on the server is time on this date";

        String actualGreeting = world.greet();

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }

    @Test
    public void whenThereAreTwoPeopleInWorld_ShouldGreetBothPeopleSeparatedByTheWordAnd() {
        Person Renae = new Person("Renae");
        storage.addPerson(Renae);

        String expectedGreeting = "Hello fiona and renae - the time on the server is time on " +
                "this date";

        String actualGreeting = world.greet();

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }

    @Test
    public void whenThereAreTwoPeopleInWorldAndOneIsRemoved_ShouldGreetTheOneRemainingPeople() {
        Person Renae = new Person("Renae");
        Person Bianca = new Person("Bianca");
        storage.addPerson(Bianca);
        storage.addPerson(Renae);
        storage.removePerson(Renae);

        String expectedGreeting = "Hello fiona and bianca - the time on the server is time on this date";

        String actualGreeting = world.greet();

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }

    @Test
    public void whenAPersonsNameIsChanged_NewNameWillBeOutputted() {
        Person Renae = new Person("Renae");
        Person Bianca = new Person("Bianca");
        storage.addPerson(Bianca);
        storage.addPerson(Renae);
        storage.changePerson(Renae, new Person("Anton"));

        String expectedGreeting = "Hello fiona, bianca and anton - the time on the server is time on this date";

        String actualGreeting = world.greet();

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }


    @Test(expected = IllegalArgumentException.class)
    public void personAlreadyExists() {
        Person Fiona = new Person("fiona");
        storage.addPerson(Fiona);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nameFieldIsEmptyWhenAddingPerson() {
        Person noName = new Person("");
        storage.addPerson(noName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void personDoesNotExistToRemove() {
        Person Bianca = new Person("bianca");
        Person Renae = new Person("renae");
        storage.changePerson(Renae, Bianca);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nameFieldIsEmptyWhenChangingToNewPerson() {
        Person Bianca = new Person("");
        Person Renae = new Person("renae");
        storage.changePerson(Renae, Bianca);
    }

    @Test(expected = IllegalArgumentException.class)
    public void personAlreadyExistsWhenChangingToNewPerson() {
        Person Bianca = new Person("bianca");
        Person Renae = new Person("renae");
        storage.addPerson(Renae);
        storage.addPerson(Bianca);
        storage.changePerson(Renae, Bianca);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotRemoveFiona() {
        Person Fiona = new Person("fiona");
        storage.addPerson(Fiona);
        storage.removePerson(Fiona);
    }


}
