public class KMPSearch {
    static void computeLPSArray(String pat, int M, int[] lps) {
        int j = 0;
        lps[0] = 0;
        int i = 1;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(j)) {
                lps[i] = j+1;
                i++;j++;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }

    static void KMPSearcher(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int[] lps = new int[M];
        computeLPSArray(pat, M, lps);
        int i = 0, j = 0;
        while ((N - i) >= (M - j)) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j > 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    public static void main(String[] args) {
        String txt = "Mamlayalayalam";
        String pat = "alaya";
        KMPSearcher(pat, txt);
    }
}

