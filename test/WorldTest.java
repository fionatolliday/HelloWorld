import model.Person;
import model.World;
import org.junit.Assert;
import org.junit.Test;
import storage.LocalPersonStorage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WorldTest {

    private LocalPersonStorage storage = new LocalPersonStorage();
    private World world = new World(storage);

    private String dateTime() {
        LocalDateTime myDateObj = LocalDateTime.now();

        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("hh:mma");
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        String time = myDateObj.format(formattedTime);
        String date = myDateObj.format(formattedDate);

        return " - the time on the server is " + time + " on " + date;
    }


    @Test
    public void shouldGreetPersonByName_WhenThereIsOnePersonInWorld() {

        String expectedGreeting = "Hello fiona" + dateTime();

        String actualGreeting = world.greet();

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }

    @Test
    public void whenThereAreTwoPeopleInWorld_ShouldGreetBothPeopleSeparatedByTheWordAnd() {
        Person Renae = new Person("Renae");
        storage.addPerson(Renae);

        String expectedGreeting = "Hello fiona and renae" + dateTime();


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

        String expectedGreeting = "Hello fiona and bianca" + dateTime();


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

        String expectedGreeting = "Hello fiona, bianca and anton" + dateTime();


        String actualGreeting = world.greet();

        Assert.assertEquals(expectedGreeting, actualGreeting);
    }

}
