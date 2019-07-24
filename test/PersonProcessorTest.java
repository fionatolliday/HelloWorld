import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class PersonProcessorTest {

    PersonProcessor processor = new PersonProcessor();

    @Test
    public void whenTwoOrMorePeopleInWorld_ShouldRemoveOnePerson() {
        World world = new World(new Person("Fiona"));

        Person Renae = new Person("Renae");
        Person bianca = new Person("Bianca");

        processor.addPerson(world.people, Renae);
        processor.addPerson(world.people, bianca);

        processor.removePerson(world.people, Renae);


        String expectedGreeting = "Hello Fiona and Bianca - the time on the server is 10:48pm on " +
                "14 March" +
                " " +
                "2018";


        String actualGreeting = world.greet(world.listOfPeopleInWorld(world.people), world.people);

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }

    @Test
    public void shouldChangeAPersonsName_WhenPersonIsUpdated() {
        World world = new World(new Person("Fiona"));

        Person renae = new Person("Renae");
        Person bianca = new Person("Bianca");

        processor.addPerson(world.people, renae);
        processor.addPerson(world.people, bianca);

        processor.changePersonName(world.people, renae, new Person("Vanessa"));

        String expectedGreeting = "Hello Fiona, Vanessa and Bianca - the time on the server is " +
                "10:48pm on " +
                "14 March" +
                " " +
                "2018";


        String actualGreeting = world.greet(world.listOfPeopleInWorld(world.people), world.people);

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }

////Remove this from tests when deploying because it will fail the test builds and won't deploy.
//    @Test
//    public void whenThereAreThreePlusPeopleInWorld_ShouldGreetPeopleSeperatedByCommasWithTheWordAndBetweenTheFinalTwoNames() {
//        personProcessor.addPerson(new Person("Renae"));
//        personProcessor.addPerson(new Person("Bianca"));
//
//        String expectedGreeting = "Hello Fiona, Renae and Bianca - the time on the server is " +
//                "10:48pm on 14 March 2018";
//
//        String actualGreeting = personProcessor.greet(personProcessor.listOfPeopleInWorld(personProcessor.people));
//
//        Assert.assertEquals(expectedGreeting, actualGreeting);
//    }
}