import org.junit.Assert;
import org.junit.Test;

public class WorldTest {

    LocalPersonStorage storage = new LocalPersonStorage();
    World world = new World(storage);


    @Test
    public void shouldGreetPersonByName_WhenThereIsOnePersonInWorld() {

        String expectedGreeting = "Hello Fiona - the time on the server is 01:49pm on 01 August " +
                "2019";

        String actualGreeting = world.greet();

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }

    @Test
    public void whenThereAreTwoPeopleInWorld_ShouldGreetBothPeopleSeparatedByTheWordAnd() {
        Person Renae = new Person("Renae");
        storage.addPerson(Renae);

        String expectedGreeting = "Hello Fiona and Renae - the time on the server is 01:49pm on " +
                "01 August " +
                "2019";


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

        String expectedGreeting = "Hello Fiona and Bianca - the time on the server is 01:55pm on " +
                "01 August 2019";


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

        String expectedGreeting = "Hello Fiona, Bianca and Anton - the time on the server is " +
                "01:58pm on " +
                "01 August 2019";


        String actualGreeting = world.greet();

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }

}
