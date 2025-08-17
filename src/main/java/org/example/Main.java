package org.example;

import static org.example.LevenshteinDistance.*;

public class Main {
    public static void main(String[] args) {
        String s1 = "kitten";
        String s2 = "sitting";

        int distance = calculate(s1, s2);
        int distanceOpt = calculateOptimized(s1, s2);

        System.out.println("Naive Levenshtein Distance: " + distance);
        System.out.println("Optimized Levenshtein Distance: " + distanceOpt);
    }
}
