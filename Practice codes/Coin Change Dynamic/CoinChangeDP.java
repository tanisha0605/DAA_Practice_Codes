import java.util.ArrayList;
import java.util.List;
public class CoinChangeDP {
    static void CoinChange(int[] coins,int amount){
        int n=coins.length;
        int[][] CCP =new int[n+1][amount+1];
        int[][] coinsUsed =new int[n+1][amount+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(j==0){
                    CCP[i][j]=0;
                }else if(i==0){
                    CCP[i][j]=Integer.MAX_VALUE -1;
                }else{
                    if(coins[i-1] <= j){
                        if(CCP[i-1][j] > 1 + CCP[i][j-coins[i-1]]){
                            CCP[i][j]= 1+ CCP[i][j-coins[i-1]];
                            coinsUsed[i][j]=coins[i-1];
                        }else{
                            CCP[i][j]=CCP[i-1][j];
                            coinsUsed[i][j]=coinsUsed[i-1][j];
                        }
                    }else{
                        CCP[i][j]=CCP[i-1][j];
                        coinsUsed[i][j]=coinsUsed[i-1][j];
                    }
                }
                
            }
        }
        if (CCP[n][amount] >= Integer.MAX_VALUE - 1) {
            System.out.println("Amount cannot be made with the given coins.");
        } else {
            System.out.println("Minimum number of coins needed: " + CCP[n][amount]);
            System.out.print("Coins used: ");
            printCoins(coinsUsed, coins, n, amount);
            System.out.println();
        }
    }
    static void printCoins(int[][] coinsUsed,int[] coins,int n,int amount){
        List<Integer> coinsList = new ArrayList<>();
        int i=n;
        int j=amount;

        while(i>0 && j>0){
            if(coinsUsed[i][j] != 0){
                coinsList.add(coinsUsed[i][j]);
                j-=coinsUsed[i][j];
            }else{
                i--;
            }
        }
        for(int coin:coinsList){
            System.out.print(coin + " ");
        }
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 50};
        int amount = 100;

        CoinChange(coins, amount);
    }
}
