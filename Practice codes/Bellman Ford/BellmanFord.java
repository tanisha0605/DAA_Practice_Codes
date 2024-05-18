import java.util.Arrays;

public class BellmanFord {
    static class Edge{
        int source;
        int destination;
        int weight;

        Edge(int source,int destination,int weight){
            this.source=source;
            this.destination=destination;
            this.weight=weight;
        }
    }
    static int[] bellmanford(Edge[] edges,int V,int source){
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source]=0;
        //relax V-1 times
        for(int i=0;i<V-1;i++){
            for(Edge edge : edges){
                if(dist[edge.source] != Integer.MAX_VALUE && dist[edge.source] + edge.weight < dist[edge.destination]){
                    dist[edge.destination]=dist[edge.source] + edge.weight;
                }
            }
            
        }
        for(Edge edge : edges){
            if(dist[edge.source] != Integer.MAX_VALUE && dist[edge.source] + edge.weight < dist[edge.destination]){
                System.out.println("Graph contains negative weight cycle");
                return null;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V=5;
        int source=0;
        Edge[] edges = {
            new Edge(0, 1, 5),
            new Edge(0, 2, 4),
            new Edge(1, 3, 3),
            new Edge(2, 1, 6),
            new Edge(3, 2, 2),
            new Edge(3, 4, 2),
            new Edge(4, 0, 3)
    };
        int[] dist=bellmanford(edges, V, source);
        if(dist!=null){
            System.out.println("The minimum distance of all vertices from source: "+ source);
            for(int i=0;i<V;i++){
                System.out.println("Vertex " +i+ "\tDistance: "+dist[i]);
            }
        }
    }
}
