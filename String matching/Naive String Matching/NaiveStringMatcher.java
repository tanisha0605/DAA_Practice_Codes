public class NaiveStringMatcher {

    public static void naiveStringMatcher(String text, String pattern) {
        int n = text.length(); // Length of the text
        int m = pattern.length(); // Length of the pattern

        // Loop through the text from the beginning to the point where the remaining substring is at least as long as the pattern
        for (int shift = 0; shift <= n - m; shift++) {
            // Check if the substring of text starting at 'shift' and of length 'm' matches the pattern
            if (text.substring(shift, shift + m).equals(pattern)) {
                // If a match is found, print the shift (or index) where the pattern is found
                System.out.println("Pattern is present at location: " + shift);
            }
        }
    }

    public static void main(String[] args) {
        String text = "AABAACAADAABAAABAA";
        String pattern = "AABA";

        naiveStringMatcher(text, pattern);
    }
}
