import java.util.ArrayList;

public class kmp {
    public static void main(String[] args) {
        String s = "AABAACAADAABAABA";
        String pattern = "AABA";
        kmp(s, pattern);
    }

    public static void kmp(String s, String pattern) {

        int lengthOfPattern = pattern.length();
        int lengthOFString = s.length();

        int[] lps = failure(pattern);
        int i = 0; // length of String s
        int j = 0; // length of String pattern
        for (int each : failure(pattern)) {
            System.out.print(each);
        }
        System.out.println();
        while (i < lengthOFString) {

            if (pattern.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
            if (j == lengthOfPattern) {
                System.out.println("Tim thay pattern tai index: " + (i - j));
                j = lps[j - 1];

            }
            // abcdabcd
            // abcd
        }
    }

    public static int[] failure(String pattern) {
        int lengthOfPattern = pattern.length();
        int[] lps = new int[lengthOfPattern]; // lps = longest prefix suffix
        lps[0] = 0;
        int i = 0;
        int j = 1;
        while (j < lengthOfPattern) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                lps[j] = i;
                j++;
            } else {
                if (i == 0) {
                    j++;
                } else {
                    i = lps[i - 1];
                }
            }
        }
        return lps;
    }
}