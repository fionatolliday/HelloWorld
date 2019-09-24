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
        storage.removePerson("renae");

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

}
