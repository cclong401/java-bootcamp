import java.lang.ref.WeakReference;

public class WeakReferenceDemo {

    static void main(String[] args) {
        System.out.println("===== Weak Reference Demonstration =====");

        System.out.println("--- Strong Reference ---");
        Person strongPerson = new Person("Strong User", 40);
        System.out.println("Before GC : " + strongPerson);
        MemoryMonitor.triggerGarbageCollection();
        System.out.println("After GC  : " + strongPerson);
        System.out.println("Object remains because a strong reference still exists.");

        System.out.println();
        System.out.println("--- Weak Reference ---");
        // create Person weakTarget; wrap in WeakReference<Person>
        Person weakTarget = new Person("Weak User", 40);
        WeakReference<Person> weakReference = new WeakReference<>(weakTarget);
        // null weakTarget; trigger GC; print WeakReference.get() result
        weakTarget = null;
        MemoryMonitor.triggerGarbageCollection();
        System.out.println(weakReference.get());
    }
}
