import java.util.Objects;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    
    public int hashCode() {
        return Objects.hash(name, age); 
    }
}

public class HashCode1 {
    public static void main(String[] args) {
        Person person = new Person("OM", 19);
        System.out.println("Hash Code: " + person.hashCode());
    }
}
