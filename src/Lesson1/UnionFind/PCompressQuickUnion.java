package Lesson1.UnionFind;

/**
 * PCompressQuickUnion (Path compression w/ Weighted Quick Union)
 * Purpose: Improves upon the
 * weighted quick union algorithm.
 *
 * Function: If the tree has multiple
 * levels, this algorithm works to
 * compress the tree into a smaller,
 * compact tree with less levels.
 *
 * ** ARRAY DATA TYPE VERSION **
 *
 * Worst Case Time: N + M lg* N
 * M union-find operations on a set of N objects
 * lg is log base 2
 *
 * @author Denielle Kirk Abaquita
 * @version 6/15/18 @ 7:57 AM
 */

public class PCompressQuickUnion {

    private int[] id, sz;

    /** Constructor */
    public PCompressQuickUnion(int N) {

        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < id.length; i++)
        {
            id[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * Finds the root of the given integer
     * @param i - child
     * @return ultimate parent
     */
    private int root(int i)
    {
        // iterates until a root is found (8:8, 7:7, etc.)
        while (i != id[i])
        {
            id[i] = id[id[i]];      // every node points to its grandparent
            i = id[i];
        }

        return i;
    }

    /**
     * @return the number of compononents
     */
    public int count() { return id.length; }

    /**
     * Unifies two components together while taking into
     * account the sizes of each component
     *
     * ex) (comp:root) 1:1 and 2:2 -> 1:2 and 2:2
     *
     * @param p - first component
     * @param q - second component
     */
    public void union(int p, int q)
    {
        int pRoot = root(p);
        int qRoot = root(q);

        if (pRoot == qRoot) return;

        // adds smaller roots to bigger roots & updates the sz[] array
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }

    /**
     * Checks if the two components are connected
     * @param p - first comp
     * @param q - second comp
     * @return are the two component connected?
     */
    public boolean connected(int p, int q) { return root(p) == root(q); }

}
