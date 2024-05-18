public class PrimMST{

    static final int V=5;
    static final int INT_MAX=Integer.MAX_VALUE;

    static boolean isValidEdge(boolean[] inMST,int u,int v){

        if(u==v)
            return false;
        if(inMST[u] == false && inMST[v] == false )
            return false;
        else if(inMST[u] == true && inMST[v]== true)
            return false;
        return true;
    }

    static void primMST(int[][] cost){
        boolean[] inMST = new boolean[V];

        inMST[0]=true;

        int edgeCount=0,mincost=0;

        while(edgeCount < V-1){

            int min=INT_MAX,a=-1,b=-1;

            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    if(cost[i][j]<min){
                        if(isValidEdge(inMST, i, j)){
                            min=cost[i][j];
                            a=i;
                            b=j;
                        }
                    }
                }
            }
            if(a!=-1 && b!=-1){
                System.out.printf("Edge %d:(%d,%d) cost: %d\n",edgeCount++,a,b,min);
                mincost=mincost+min;
                inMST[a]=inMST[b]=true;
            }
            
        }
        System.out.println("Minimum cost of tree is: "+mincost);
    }

    public static void main(String[] args) {

        int cost[][] = {{ INT_MAX, 2, INT_MAX, 6, INT_MAX },
					{ 2, INT_MAX, 3, 8, 5 },
					{ INT_MAX, 3, INT_MAX, INT_MAX, 7 },
					{ 6, 8, INT_MAX, INT_MAX, 9 },
					{ INT_MAX, 5, 7, 9, INT_MAX }};

	    primMST(cost);
    }

}
