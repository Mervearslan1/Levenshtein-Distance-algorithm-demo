import org.example.LevenshteinDistance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LevenshteinDistanceTest {
    @Test
    void testEqualStrings() {
        assertEquals(0, LevenshteinDistance.calculate("java", "java"));
    }

    @Test
    void testEmptyStrings() {
        assertEquals(4, LevenshteinDistance.calculate("", "test"));
    }

    @Test
    void testSingleCharDifference() {
        assertEquals(1, LevenshteinDistance.calculate("a", "b"));
    }

    @Test
    void testKnownExample() {
        assertEquals(3, LevenshteinDistance.calculate("kitten", "sitting"));
    }
}


