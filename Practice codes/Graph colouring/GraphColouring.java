
public class GraphColouring {
    static void addNode(int x,int y,int[][] graph){
        graph[x][y]=1;
        graph[y][x]=1;

    }
    static boolean isSafe(int x,int col,int[][] graph,int[] colour){
        for(int i:graph[x]){
            if(graph[x][i] == 1 && colour[i]== col){
                return false;
            }
        }return true;
    }

    static boolean canColor(int x,int[] colour,int[][] graph,int n,int m){
       if(x==n) return true;

       for(int i=1;i<=m;i++){
        if(isSafe(x, i, graph, colour)){
            colour[x]=i;
            if(canColor(x+1, colour, graph, n, m)) return true;
            colour[x]=0;
        }
       }return false;
    }
    public static void main(String[] args) {
        int[][] graph=new int[4][4];

        addNode(0, 1, graph);
        addNode(1, 2, graph);
        addNode(2, 3, graph);
        addNode(3, 0, graph);
        addNode(2, 0, graph);

        int[] colour= new int[4];

        boolean ans=canColor(0, colour, graph, 4, 3);

        if (!ans) {
            System.out.println("No, we can't color the graph with 3 colors.");
        } else{
            for(int i:colour){
                System.out.print(i +" ");
            }
        }
    }
}
