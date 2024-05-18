import java.util.Scanner;

public class NQueen {
    static int[] x=new int[20];
    // row k , column i
    static boolean place(int k,int i){
        for(int j=1;j<=k-1;j++){
            if(x[j]==i || Math.abs(x[j]-i)== Math.abs(j-k)){
                return false;
            }
        }
        return true;
    }

    static void nqueen(int k,int n){
        for(int i=1;i<=n;i++){
            if(place(k, i)){
                x[k]=i;
                if(k==n){
                    System.out.print("Solution:");
                    for(int j=1;j<=n;j++){
                        
                        System.out.print(x[j] + " ");
                    }
                    System.out.println();
                }else{
                    nqueen(k+1, n);
                }
            }   
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter number of queens: ");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        if(n <= 0){
            System.out.println("Not a valid input");
        }
        nqueen(1, n);
    }
}
