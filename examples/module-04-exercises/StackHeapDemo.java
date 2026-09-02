public class StackHeapDemo {
    static class Person {
        String name;
        Person(String name) {
            this.name = name;
        }
    }

    static void printPerson(Person person) {
        // compute nameLength; print name + length
        int nameLength = person.name.length();
        System.out.println(person.name + " has " + nameLength + " letters.");
    }

    public static void main(String[] args) {
        // TODO: create Person on heap; call printPerson; print a local count
        int count = 1;

        Person person = new Person("Aman");

        printPerson(person);
        System.out.println("Count: " + count);
    }
}
