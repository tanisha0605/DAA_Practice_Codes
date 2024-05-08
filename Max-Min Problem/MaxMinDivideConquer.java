public class MaxMinDivideConquer {

    static class Pair {
        int max;
        int min;
    }

    static Pair maxMinDivideConquer(int[] arr, int low, int high) {
        Pair result = new Pair();
        Pair left, right;
        int mid;
        
        if (low == high) {
            result.max = arr[low];
            result.min = arr[low];
            return result;
        }
        
        if (high == low + 1) {
            if (arr[low] < arr[high]) {
                result.min = arr[low];
                result.max = arr[high];
            } else {
                result.min = arr[high];
                result.max = arr[low];
            }
            return result;
        }
       
        mid = (low + high) / 2;
        left = maxMinDivideConquer(arr, low, mid);
        right = maxMinDivideConquer(arr, mid + 1, high);
        
        result.max = Math.max(left.max, right.max);
        result.min = Math.min(left.min, right.min);
        
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {6, 4, 26, 14, 33, 64, 46};
        Pair result = maxMinDivideConquer(arr, 0, arr.length - 1);
        System.out.println("Maximum element is: " + result.max);
        System.out.println("Minimum element is: " + result.min);
    }
}