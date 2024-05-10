public class SelectionSort {
    // Function to swap two elements in an array
    static void swap(int[] arr, int xp, int yp) {
        int temp = arr[xp];
        arr[xp] = arr[yp];
        arr[yp] = temp;
    }

    // Function to perform selection sort
    static void selectionSort(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            int min_index=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min_index]){
                    min_index=j;
                }
                
            }
            swap(arr,min_index,i);
        }
    }

    // Function to print array
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11, 78, 21, 9, 45, 66, 90};
        System.out.println("Original array:");
        printArray(arr);
        
        selectionSort(arr);
        
        System.out.println("Sorted array:");
        printArray(arr);
    }
}

