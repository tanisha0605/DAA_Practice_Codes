import java.util.Arrays;

public class FibonacciMemoization {
    static int fib(int n,int[] lookupTable){
        if(lookupTable[n] != -1){
            return lookupTable[n];
        }
        int result;
        if(n<=1){
            result=n;
        }else{
            result=fib(n-2, lookupTable) + fib(n-1, lookupTable);
        }
        lookupTable[n]=result;
        return result;
    }
    public static void main(String[] args) {
        int n=15;
        int lookupTable[] = new int[n+1];
        Arrays.fill(lookupTable,-1);
        System.out.println("Fibonacci number at " +n+ ": " +fib(n,lookupTable));
        for(int i=0;i<=n;i++){
            System.out.println(lookupTable[i]);
        }
    }
}
