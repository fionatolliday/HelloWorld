
public class Person {

    public String getName() {

        return name;
    }

    private String name;

    public Person(String name){

        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
