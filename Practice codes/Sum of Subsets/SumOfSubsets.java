
public class SumOfSubsets {
    static void printsubsets(int[] arr,int n,int index,int sum,int currSum,int[] subsets){
        if(currSum==sum){
            System.out.print("{");
            for(int i=0;i<index;i++){
                if(subsets[i]!=0)
                    System.out.print(subsets[i]+" ");
            }
            System.out.println(" }");
            return;
        }

        if(index == n || currSum > sum){
            return;
        }

        subsets[index]=arr[index];
        printsubsets(arr,n,index+1,sum,currSum+arr[index],subsets);

        subsets[index]=0;
        printsubsets(arr, n, index+1, sum, currSum, subsets);

    }
    public static void main(String[] args) {
        int[] arr ={2, 3, 5, 6, 8, 10};
        int n=arr.length;
        int sum=10;
        int[] subset =new int[n];

        printsubsets(arr, n, 0, sum, 0, subset);
    }
}
