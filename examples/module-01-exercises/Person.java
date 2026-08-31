public class Person {
    // Provided boilerplate fields — focus on constructor + display + new
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println(name + " is " + age + " years old");
    }

    static void main(String[] args) {
        Person Aman = new Person("Aman", 21);
        Aman.display();
    }
}
