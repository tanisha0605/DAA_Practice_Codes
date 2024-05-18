public class MaxMinDC {
    static class Pair{
        int max;
        int min;
    }
    static Pair MaxMinDivideConquer(int[] a,int low,int high){
        Pair result = new Pair();
        Pair left,right;
        int mid;

        if(low == high){
            result.max=a[low];
            result.min=a[low];
            
            return result;
        }
        else if(high==low+1){
            if(a[low] < a[high]){
                result.max=a[high];
                result.min=a[low];
            }
            else{
                result.max=a[low];
                result.min=a[high];
            }
            return result;
        }
        mid=(low+high)/2;
        left=MaxMinDivideConquer(a, low, mid);
        right=MaxMinDivideConquer(a, mid+1, high);

        result.max=Math.max(left.max, right.max);
        result.min=Math.min(left.min, right.min);

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {6, 4, 26, 14, 33, 64, 46};
        Pair result = MaxMinDivideConquer(arr, 0, arr.length - 1);
        System.out.println("Maximum element is: " + result.max);
        System.out.println("Minimum element is: " + result.min);
    }
}
