public class UnionFind {
    private int[] parent;

    public UnionFind(int size){
        parent=new int[size];
        for(int i=0;i<size;i++){
            parent[i]=i;
        }
    }
    public int find(int i){
        while (parent[i]!=i){
            i=parent[i];
        }
        return i;
    }
    public void union(int i,int j){
        int irep=find(i);
        int jrep=find(j);

        parent[irep]=jrep;
    }
    public static void main(String[] args) {
        int size=5;
        UnionFind uf=new UnionFind(size);

        uf.union(1, 2);
        uf.union(3, 4);

        Boolean isSameSet = uf.find(1)==uf.find(2);
        Boolean isSameSet2 = uf.find(3)==uf.find(2);
        Boolean isSameSet3 = uf.find(3)==uf.find(4);
        System.out.println(isSameSet);
        System.out.println(isSameSet2);
        System.out.println(isSameSet3);
    }
}
