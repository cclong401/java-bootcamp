public class StringBuilderComparison {
    // time String + in a loop vs StringBuilder.append for same N
    // print both durations; note which creates more temporaries
    private static final int ITERATIONS = 50_000;

    static String withString() {
        String result = "";
        for (int i = 0; i < ITERATIONS; i++) {
            result += "x";
        }
        return result;
    }

    static String withBuilder() {
        StringBuilder result = new StringBuilder(ITERATIONS);
        for (int i = 0; i < ITERATIONS; i++) {
            result.append('x');
        }
        return result.toString();
    }

    static void main(String[] args) {
        double startTime = System.nanoTime();
        String withString = withString();
        double withStringTime = System.nanoTime() - startTime;

        double beforeBuilderTime = System.nanoTime();
        String withBuilder = withBuilder();
        double withBuilderTime = System.nanoTime() - beforeBuilderTime;

        System.out.printf(
                "String: %d chars, %.3f ms.%nStringBuilder: %d chars, %.3f ms.",
                withString.length(), withStringTime/1_000_000, withBuilder.length(), withBuilderTime/1_000_000
        );
    }
}
