
public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public Person(String name){
        this.name = name.toLowerCase();
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }


}
