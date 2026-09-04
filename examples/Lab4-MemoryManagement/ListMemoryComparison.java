import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListMemoryComparison {

    static void main(String[] args) {
        System.out.println("===== Bonus: ArrayList vs LinkedList =====");
        int count = 100_000;

        MemoryMonitor.triggerGarbageCollection();
        long before = MemoryMonitor.getUsedMemoryBytes();
        List<Integer> arrayList = new ArrayList<>();
        // add 0..count-1 to arrayList; measure memory delta into arrayListMemory
        for (int i = 0; i < count-1; i++) {
            arrayList.add(i);
        }
        long arrayListMemory = MemoryMonitor.getUsedMemoryBytes();
        System.out.printf("ArrayList memory approx : %.2f MB%n",
                MemoryMonitor.toMegabytesDouble(arrayListMemory));

        arrayList = null;
        MemoryMonitor.triggerGarbageCollection();

        before = MemoryMonitor.getUsedMemoryBytes();
        List<Integer> linkedList = new LinkedList<>();
        // add 0..count-1 to linkedList; measure memory delta into linkedListMemory
        for (int i = 0; i < count-1; i++) {
            linkedList.add(i);
        }
        long linkedListMemory = MemoryMonitor.getUsedMemoryBytes();
        System.out.printf("LinkedList memory approx : %.2f MB%n",
                MemoryMonitor.toMegabytesDouble(linkedListMemory));

        System.out.println();
        System.out.println("ArrayList usually uses less memory per element than LinkedList node overhead.");
    }
}
