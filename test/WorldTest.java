import org.junit.Assert;
import org.junit.Test;

public class WorldTest {

    World world = new World(new Person("Fiona"));

    @Test
    public void shouldGreetPersonByName_WhenThereIsOnePersonInWorld() {

        String expectedGreeting = "Hello Fiona - the time on the server is 10:48pm on 14 March " +
                "2018";

        String actualGreeting =
                world.greet(world.listOfPeopleInWorld(world.people), world.people);

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }

    @Test
    public void whenThereAreTwoPeopleInWorld_ShouldGreetBothPeopleSeparatedByTheWordAnd() {
        PersonProcessor processor = new PersonProcessor();

        Person Renae = new Person("Renae");
        processor.addPerson(world.people, Renae);

        String expectedGreeting = "Hello Fiona and Renae - the time on the server is 10:48pm on " +
                "14 March" +
                " " +
                "2018";


        String actualGreeting = world.greet(world.listOfPeopleInWorld(world.people), world.people);

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }


}
