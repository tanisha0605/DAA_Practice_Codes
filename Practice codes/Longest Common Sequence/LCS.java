
public class LCS {
    static int LCSsolve(String X,String Y,int m,int n){
        if(n==0 || m==0){
            return 0;
        }if(X.charAt(m-1) == Y.charAt(n-1))
            return 1+ LCSsolve(X, Y, m-1, n-1);
        else{
            return max(LCSsolve(X, Y, m-1, n),LCSsolve(X, Y, m, n-1));
        }
    }
    static int max(int a,int b){
        return (a>b) ? a : b;
    }
    public static void main(String[] args) {
        String S1="Malyalama";
        String S2="alaya";
        int m=S1.length();
        int n=S2.length();
        int ans = LCSsolve(S1, S2, m, n);
        System.out.println("Longest Common Sequence is: "+ ans);
    }
}
