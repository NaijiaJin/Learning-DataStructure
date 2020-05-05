
public class UnionFind {

    // TODO - Add instance variables?
    private int size;
    int[] ds;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {

        ds= new int[n];
        size=n;
        for(int i=0;i<n;i++)
        {
            ds[i]=-1;
        }

    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex)  {
        if(vertex>size||vertex<0)
        {
            try {
                throw new IllegalAccessException ("this is not a valid index");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        // TODO
        int p=0;
        while(ds[p]>0)
        {
            p=ds[p];
        }
        return -ds[p];
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {

            return ds[v1];

    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO
        if(find(v1)==find(v2))
        {
            return true;
        }
        else
        return false;
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        // TODO
        validate(v1);
        validate(v2);
        int s1=sizeOf(v1);
        int s2=sizeOf(v2);
        if(s1<=s2)
        {
            ds[find(v1)]=find(v2);
            ds[find(v2)]=-(s1+s2);

        }
        else
        {
            ds[find(v2)]=find(v1);
            ds[find(v1)]=-(s1+s2);
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        // TODO
        while(parent(vertex)>0)
        {
            vertex=parent(vertex);
        }
        return vertex;
    }

}















