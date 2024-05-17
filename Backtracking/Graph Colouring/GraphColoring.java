
public class GraphColoring{
    public static void addNode(int[][] graph, int x,int y)
    {
        graph[x][y]=1;
        graph[y][x]=1;
    }
    public static boolean isSafe(int col,int[] color,int x,int[][] graph)
    {
        for(int i:graph[x])
        {
            if(graph[x][i]==1&&color[i]==col)return false; 
            //If there exist a node between them 
            //and color is same give false
        }
        return true;
    }
    public static boolean canColor(int x,int[][] graph,int[] color,int n,int m)
    {
        if(x==n)return true; //Base case
        for(int i=1;i<=m;i++)
        {
            if(isSafe(i,color,x,graph))
            {
                color[x]=i;
                if (canColor(x+1,graph,color,n,m)) return true;
                color[x]=0;
            }
        }
        return false;
    }
public static void main (String args[])
{
    int[][] graph=new int[4][4];
    
    addNode(graph,0,1);
    addNode(graph,1,2);
    addNode(graph,2,3);
    addNode(graph,3,0);
    addNode(graph,2,0);
    //Dont populate diagonals
    int[] color=new int[4];
    boolean ans=canColor(0,graph,color,4,3); //4 is no of nodes,3 is max no colors,0 is startIndex
    if(!ans)System.out.println("No we cant color");
    else {
        System.out.println("Yes we can color it as:");
        for(int i:color)
        {
            System.out.print(i+" ");
        }
    }
}
}
