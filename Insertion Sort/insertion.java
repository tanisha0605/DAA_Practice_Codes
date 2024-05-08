class insertion
{
    void sort(int a[],int n){
        for(int i=1;i<n;i++){
            int key=a[i];
            int window=i;
            while(window>0 && a[window-1]>key){
                a[window]=a[window-1];
                window--;
            }
            a[window]=key;
        }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6 };
        int n=arr.length;
        insertion ob = new insertion();
        ob.sort(arr,n);

        printArray(arr);
    }
}