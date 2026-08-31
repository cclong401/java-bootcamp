public class WoraProbe {
    public static void main(String[] args) {
        // TODO: print the OS name (hint: System.getProperty("os.name"))
        String osName = System.getProperty("os.name");
        System.out.println(osName);
                // TODO: print "Bytecode runs on: " + that OS name
                System.out.println("Bytecode runs on: " + osName);
    }
}