
public class NaiveStringMatcher {
    public static void naivestring(String text,String pattern ){
        int n=text.length();
        int m=pattern.length();

        for(int shift=0;shift<=n-m;shift++){
            if(text.substring(shift, shift+m).equals(pattern)) 
                System.out.println("Pattern found at index: "+shift);
        }
    }
    public static void main(String[] args) {
        String text = "AABAACAADAABAAABAA";
        String pattern = "AABA";

        naivestring(text, pattern);

    }
}
