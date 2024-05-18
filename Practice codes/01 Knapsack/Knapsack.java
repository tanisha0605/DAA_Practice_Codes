import java.util.*;
public class Knapsack {
    static class Result{
        int maxProfit;
        List<Integer> includedWeights;

        Result(int maxProfit,List<Integer> includedWeights){
            this.includedWeights=includedWeights;
            this.maxProfit=maxProfit;
        }
    }
    static Result knapsack(int[] p,int[] w,int M,int n){
        int[][] profit=new int[n+1][M+1];

        for(int i=0;i<=n ;i++){
            for(int j=0;j<=M;j++){
                if(i==0 || j==0)
                    profit[i][j]=0;
                else if(w[i-1] <= j)
                        profit[i][j]=Math.max(profit[i-1][j],profit[i-1][j-w[i-1]]+p[i-1]);
                else{
                        profit[i][j]=profit[i-1][j];
                }
            }
        }
        List<Integer> includedWeights = new ArrayList<>();
        int maxProfit=profit[n][M];
        int remainingWeight=M;
        for(int i=n; i>0 && maxProfit>0; i--){
            if(maxProfit != profit[i-1][remainingWeight]){
                includedWeights.add(w[i-1]);
                maxProfit-=p[i-1];
                remainingWeight-= w[i-1];
            }
        }
        return new Result(profit[n][M], includedWeights);
    }
    public static void main(String[] args) {
        
        int[] p = {60, 100, 120}; 
        int[] w = {10, 20, 30}; 
        int M = 50; 
        int n = p.length; 

        Result result = knapsack(p, w, M, n);
        System.out.println("Maximum profit: " + result.maxProfit);
        System.out.println("Weights included: " + result.includedWeights);
    }
}
