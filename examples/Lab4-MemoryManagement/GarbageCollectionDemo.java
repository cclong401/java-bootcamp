public class GarbageCollectionDemo {

    private static class DemoObject {
        private final String label;
        private final byte[] payload = new byte[128];

        DemoObject(String label) {
            this.label = label;
        }
    }

    static void main(String[] args) {
        System.out.println("===== Garbage Collection Demonstration =====");
        long startTime = System.nanoTime();

        MemoryMonitor.printMemoryReport("Before Allocation");

        DemoObject[] objects = new DemoObject[100000];
        System.out.println("Creating Objects...");
        // fill objects[i] = new DemoObject("Object-" + i)
        double objectsCreated = 0;
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new DemoObject("Object-" + i);
            objectsCreated++;
        }
        // print Objects Created count; printMemoryReport After Allocation
        System.out.println("Objects created: " + objectsCreated);
        MemoryMonitor.printMemoryReport("After Allocation");

        // set objects = null; trigger GC; print After GC report + elapsed ms
        // Tip: elapsedMillis = (System.nanoTime() - startTime) / 1_000_000
        objects = null;
        MemoryMonitor.triggerGarbageCollection();
        MemoryMonitor.printMemoryReport("After Garbage Collection");
        double elapsedMs = (System.nanoTime() - startTime) / 1000000.0;
        System.out.println("Elapsed ms: " + elapsedMs);
    }
}
