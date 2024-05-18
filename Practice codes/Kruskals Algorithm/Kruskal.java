
public class Kruskal {
    static final int V=5;
    static final int INF=Integer.MAX_VALUE;
    static int[] parent=new int[V];

    static int find(int i){

        while(parent[i]!=i)
            i=parent[i];
        return i;
    }
    static void union(int i,int j){
        int irep=find(i);
        int jrep=find(j);

        parent[irep]=jrep;
    }

    static void kruskal(int[][] cost){
        int mincost=0;

        for(int i=0;i<V;i++)
            parent[i]=i;

        int edgecount=0;
        while(edgecount< V-1){
            int min=INF,a=-1,b=-1;
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    if(find(i) != find(j) && cost[i][j]<min){
                        min=cost[i][j];
                        a=i;
                        b=j;
                    }
                }
            }
            union(a, b);
		    System.out.printf("Edge %d:(%d, %d) cost:%d \n",edgecount++, a, b, min);
		    mincost += min;
        }
        System.out.printf("\n Minimum cost= %d \n", mincost);
    }
public static void main(String[] args) 
{
/* Let us create the following graph
		2 3
	(0)--(1)--(2)
	| / \ |
	6| 8/ \5 |7
	| /	 \ |
	(3)-------(4)
			9		 */
	int cost[][] = {
		{ INF, 2, INF, 6, INF },
		{ 2, INF, 3, 8, 5 },
		{ INF, 3, INF, INF, 7 },
		{ 6, 8, INF, INF, 9 },
		{ INF, 5, 7, 9, INF },
	};

	// Print the solution
	kruskal(cost);
	}

}
