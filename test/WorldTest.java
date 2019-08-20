import org.junit.Assert;
import org.junit.Test;

public class WorldTest {

    LocalPersonStorage storage = new LocalPersonStorage();
    World world = new World(storage);
//    read the time on the server here for the tests.


    @Test
    public void shouldGreetPersonByName_WhenThereIsOnePersonInWorld() {

        String expectedGreeting = "Hello fiona - the time on the server is 02:40pm on 19 August " +
                "2019";

        String actualGreeting = world.greet();

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }

    @Test
    public void whenThereAreTwoPeopleInWorld_ShouldGreetBothPeopleSeparatedByTheWordAnd() {
        Person Renae = new Person("Renae");
        storage.addPerson(Renae);

        String expectedGreeting = "Hello fiona and renae - the time on the server is 02:40pm on " +
                "19 August 2019";


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

        String expectedGreeting = "Hello fiona and bianca - the time on the server is 02:40pm on " +
                "19 August 2019";


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

        String expectedGreeting = "Hello fiona, bianca and anton - the time on the server is " +
                "02:40pm on 19 August 2019";


        String actualGreeting = world.greet();

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }

}
