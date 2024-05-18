public class Djikstras {
    private static final int V=9;
    int minDistance(int distance[],Boolean pstSet[]){
        int min=Integer.MAX_VALUE,min_index=-1;
        for(int v=0;v<V;v++){
            if(pstSet[v] == false && distance[v]<=min){
                min=distance[v];
                min_index=v;
            }
        }
        return min_index;
    }
    void printSolution(int dist[])
    {
        System.out.println(
            "Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
    void djikstra(int graph[][],int src){
        int[] distance=new int[V];
        Boolean[] pstSet=new Boolean[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
            pstSet[i] = false;
        }
        distance[src]=0;

        for(int count=0; count<V-1; count++){
            int u=minDistance(distance, pstSet);
            pstSet[u]=true;
            for(int v=0;v<V;v++){
                if(!pstSet[v] && graph[u][v]!= 0 && distance[u]!= Integer.MAX_VALUE && distance[u]+graph[u][v]<distance[v]){
                    distance[v]=distance[u]+graph[u][v];
                }
            }
        }
        printSolution(distance);
    }
    public static void main(String[] args)
    {
        int graph[][]= new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                    { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                    { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                    { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                    { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                    { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                    { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                    { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                    { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
   
        Djikstras  t = new Djikstras();

        t.djikstra(graph, 0);
    }
}
