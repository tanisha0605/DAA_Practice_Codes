
class BinarySearch {


	int binarySearch(int arr[], int l, int r, int x)
	{
		if (r >= l) {
			int mid = (l + r) / 2;

			if (arr[mid] == x)
				return mid;

			if (arr[mid] > x)
				return binarySearch(arr, l, mid - 1, x);

			return binarySearch(arr, mid + 1, r, x);
		}

		return -1;
	}

	public static void main(String args[])
	{
		BinarySearch ob = new BinarySearch();

		int arr[] = { 2, 3, 4, 6, 10, 22, 25, 30, 36, 40 ,45 ,50 };
		int n = arr.length;
		int x = 2;
		int result = ob.binarySearch(arr, 0, n - 1, x);

		if (result == -1)
			System.out.println("Element is not present in array");
		else
			System.out.println("Element is present at index " + result);
	}
}

