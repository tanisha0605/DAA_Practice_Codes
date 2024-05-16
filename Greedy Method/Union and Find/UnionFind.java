public class UnionFind { 
	private int[] parent; 

	public UnionFind(int size) { 
		// Initialize the parent array with each element as its own representative 
		parent = new int[size]; 
		for (int i = 0; i < size; i++) { 
			parent[i] = i; 
		} 
	} 

	// Find the representative (root) of the set that includes element i 
	public int find(int i) { 
		if (parent[i] == i) { 
			return i; // i is the representative of its own set 
		} 
		// Recursively find the representative of the parent until reaching the root 
		parent[i] = find(parent[i]); // Path compression 
		return parent[i]; 
	} 

	// Unite (merge) the set that includes element i and the set that includes element j 
	public void union(int i, int j) { 
		int irep = find(i); // Find the representative of set containing i 
		int jrep = find(j); // Find the representative of set containing j 

		// Make the representative of i's set be the representative of j's set 
		parent[irep] = jrep; 
	} 

	public static void main(String[] args) { 
		int size = 5; // Replace with your desired size 
		UnionFind uf = new UnionFind(size); 

		// Perform union operations as needed 
		uf.union(1, 2); 
		uf.union(3, 4); 

		// Check if elements are in the same set 
		boolean inSameSet = uf.find(1) == uf.find(2); 
		boolean inSameSet2 = uf.find(3) == uf.find(2); 
		boolean inSameSet3 = uf.find(3) == uf.find(4); 
		System.out.println("Are 1 and 2 in the same set? " + inSameSet); 
		System.out.println("Are 3 and 2 in the same set? " + inSameSet2); 
		System.out.println("Are 3 and 4 in the same set? " + inSameSet3); 
	} 
} 