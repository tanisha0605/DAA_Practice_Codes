import java.util.Vector;

public class CoinChangeGreedy1{
    static int deno[]={1, 2, 5, 10, 20, 50, 100, 500, 1000};
    static int n=deno.length;
    static void findAns(int V){

        Vector<Integer> answer =new Vector<>();
        for(int i=n-1; i>=0 ; i--){
            while(V >= deno[i]){
                V -= deno[i];
                answer.add(deno[i]);
            }
        }
        for(int i=0;i<answer.size();i++){
            System.out.print(" " +answer.elementAt(i));
        }
    }
    public static void main(String[] args) {
        int n=1113;
        System.out.print(
			"Following is minimal number "
			+"of change for " + n + ": ");
        findAns(n);
    }
}
