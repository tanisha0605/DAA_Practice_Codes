public class RabinKarpSearch {
    static final int d = 256;

    static void search(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int h = 1;
        int p = 0;
        int t = 0;

        for (int i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        for (int i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (int i = 0; i <= N - M; i++) {
            if (p == t) {
                int j;
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                if (t < 0)
                    t = (t + q);
            }
        }
    }

    public static void main(String[] args) {
        String txt = "Mamlayalayalam";
        String pat = "alaya";
        int q = 101;
        search(pat, txt, q);
    }
}

