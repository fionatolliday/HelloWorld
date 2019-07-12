import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class WorldTest {

    World world = new World(new Person("Fiona"));

//    @Test
//    public void shouldGreetPersonByName_WhenThereIsOnePersonInWorld() {
//        Person fiona = new Person("Fiona");
//
//        List<Person> people = new ArrayList<>();
//        people.add(fiona);
//
//        String expectedGreeting = "Hello Fiona - the time on the server is 10:48pm on 14 March " +
//                "2018";
//        String actualGreeting = world.greet(people);
//
//        Assert.assertEquals(expectedGreeting, actualGreeting);
//    }
//
//    @Test
//    public void whenThereAreTwoPeopleInWorld_ShouldGreetBothPeopleSeperatedByTheWordAnd() {
//        world.addPerson(new Person("Renae"));
//
//        String expectedGreeting = "Hello Fiona and Renae - the time on the server is 10:48pm on " +
//                "14 March" +
//                " " +
//                "2018";
//
//
//        String actualGreeting = world.greet(world.people);
//
//        Assert.assertEquals(expectedGreeting, actualGreeting);
//    }
//
//    @Test
//    public void whenTwoOrMorePeopleInWorld_ShouldRemoveOnePerson() {
//        world.addPerson(new Person("Renae"));
//        world.removePerson(new Person("Renae"));
//
//        String expectedGreeting = "Hello Fiona - the time on the server is 10:48pm on " +
//                "14 March" +
//                " " +
//                "2018";
//
//
//        String actualGreeting = world.greet(world.people);
//
//        Assert.assertEquals(expectedGreeting, actualGreeting);
//    }


    @Test
    public void whenThereAreThreePlusPeopleInWorld_ShouldGreetPeopleSeperatedByCommasWithTheWordAndBetweenTheFinalTwoNames() {
        world.addPerson(new Person("Renae"));
        world.addPerson(new Person("Bianca"));

        String expectedGreeting = "Hello Fiona, Renae and Bianca - the time on the server is " +
                "10:48pm on 14 March 2018";

        String actualGreeting = world.greet(world.people);

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }
}