import org.junit.jupiter.api.Test;
import static org.example.LevenshteinDistance.*;

public class LevenshteinPerformanceTest {

    @Test
    public void testPerformanceOptimizedLongText() {
        String s1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        String s2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tempor incididunt ut labore et dolore magna aliqua.";

        int iterations = 10000; // 10 bin tekrar
        long totalTimeNaive = 0;
        long totalTimeOptimized = 0;

        int resultNaive = 0;
        int resultOptimized = 0;

        for (int i = 0; i < iterations; i++) {
            // Naive algoritma
            long startNaive = System.nanoTime();
            resultNaive = calculate(s1, s2);
            long endNaive = System.nanoTime();
            totalTimeNaive += (endNaive - startNaive);

            // Optimized algoritma
            long startOpt = System.nanoTime();
            resultOptimized = calculateOptimized(s1, s2);
            long endOpt = System.nanoTime();
            totalTimeOptimized += (endOpt - startOpt);
        }

        double avgTimeNaiveMs = totalTimeNaive / (iterations * 1_000_000.0);
        double avgTimeOptimizedMs = totalTimeOptimized / (iterations * 1_000_000.0);

        System.out.println("Naive Levenshtein Distance: " + resultNaive);
        System.out.println("Optimized Levenshtein Distance: " + resultOptimized);
        System.out.println("Average Naive execution time (ms): " + avgTimeNaiveMs);
        System.out.println("Average Optimized execution time (ms): " + avgTimeOptimizedMs);
    }
}
