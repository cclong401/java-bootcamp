public class PerformanceTest {

    private static class SampleObject {
        private final int value;
        private final byte[] data = new byte[64];

        SampleObject(int value) {
            this.value = value;
        }
    }

    static void main(String[] args) {
        System.out.println("===== Performance Measurement =====");
        MemoryMonitor.printMemoryReport("Start");

        int[] objectCounts = {10, 100, 1_000, 100_000, 1_000_000};

        System.out.println();
        System.out.printf("%-12s %-14s %-18s%n", "Objects", "Used Memory", "Execution Time");
        System.out.println("--------------------------------------------------");

        for (int count : objectCounts) {
            runAllocationTest(count);
        }

        System.out.println();
        System.out.println("Additional measurements:");
        measureLoopExecution();
        measureArrayAllocation();
        measureLargeByteArray();
    }

    private static void runAllocationTest(int count) {
        MemoryMonitor.triggerGarbageCollection();
        long memoryBefore = MemoryMonitor.getUsedMemoryBytes();
        double start = System.nanoTime();

        // allocate SampleObject[count], fill each slot
        SampleObject[] sampleObjects = new SampleObject[count];
        for (int i = 0; i < count; i++) {
            sampleObjects[i] = new SampleObject(i);
        }

        // measure elapsed ms + memoryUsed; printf row; null array + GC
        double elapsedMs = (System.nanoTime() - start) / 1_000_000;
        long memoryAfter = MemoryMonitor.getUsedMemoryBytes();
        sampleObjects = null;
        MemoryMonitor.triggerGarbageCollection();
        System.out.printf("%-12s %-14s MB %-18s ms%n", count, memoryAfter/1_000_000, elapsedMs);
    }

    private static void measureLoopExecution() {
        // loop 10_000_000 iterations summing i into sum; print elapsed ms
        System.out.println("===== Loop Execution =====");
        double sum = 0;
        double startTime = System.nanoTime();
        for (int i = 0; i < 10_000_000; i++) {
            sum += i;
        }
        double elapsedMs = (System.nanoTime() - startTime) / 1_000_000;

        System.out.println("Total sum: " + sum);
        System.out.println("Elapsed time: " + elapsedMs);
    }

    private static void measureArrayAllocation() {
        // allocate int[1_000_000], fill with i, print elapsed ms
        System.out.println("===== Array Allocation =====");
        double startTime = System.nanoTime();
        int[] array = new int[10_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        double elapsedMs =  (System.nanoTime() - startTime) / 1_000_000;
        System.out.println("Elapsed ms: " + elapsedMs);
    }

    private static void measureLargeByteArray() {
        System.out.println("===== Large Byte Array =====");
        MemoryMonitor.printMemoryReport("Before Large byte[]");
        // allocate 10 MB byte[]; print After report; null + GC; print After Releasing
        byte[] bytes = new byte[1_000_000];
        MemoryMonitor.printMemoryReport("After Large byte[]");
        bytes = null;
        MemoryMonitor.triggerGarbageCollection();
        MemoryMonitor.printMemoryReport("After Garbage Collection");
    }
}
