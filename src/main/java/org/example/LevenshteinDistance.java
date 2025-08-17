package org.example;

public class LevenshteinDistance {

    /**
     * Levenshtein Distance algoritması
     * @param s1 İlk string
     * @param s2 İkinci string
     * @return İki string arasındaki edit mesafesi
     */
    public static int calculate(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Input strings must not be null");
        }

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        // İlk satır ve sütun dolduruluyor
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Silme
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Ekleme
        }

        // DP tablosu dolduruluyor
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;

                dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j] + 1,      // Silme
                                dp[i][j - 1] + 1),     // Ekleme
                        dp[i - 1][j - 1] + cost         // Yerine koyma
                );
            }
        }

        return dp[m][n];
    }

    /**
     * Bellek optimizasyonlu versiyon (O(min(m, n)) bellek kullanır)
     */
    public static int calculateOptimized(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Input strings must not be null");
        }

        int m = s1.length();
        int n = s2.length();

        // Kısa string satır olarak seçiliyor
        if (m < n) {
            return calculateOptimized(s2, s1);
        }

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                curr[j] = Math.min(
                        Math.min(prev[j] + 1, curr[j - 1] + 1),
                        prev[j - 1] + cost
                );
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}
