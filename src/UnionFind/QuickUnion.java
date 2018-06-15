package UnionFind;

/**
 * QuickUnion
 * Purpose: Implementation example for solving
 * the dynamic connectivity more efficiently than
 * quick find.
 *
 * ** ARRAY DATA TYPE VERSION **
 *
 * *** STILL SLOW - Can Iterate N Times ***
 *
 * @author Denielle Kirk Abaquita
 * @version 6/12/18 @ 9:27 AM
 */

public class QuickUnion {

    private int[] id;

    /** Constructor */
    public QuickUnion(int N) {

        id = new int[N];

        for (int i = 0; i < id.length; i++)
            id[i] = i;
    }

    /**
     * Finds the root of the given integer
     * @param i - child integer
     * @return ultimate parent integer
     */
    private int root(int i) {

        // iterates until a root is found (8:8, 7:7, etc.)
        while (i != id[i])
            i = id[i];

        return i;
    }

    /**
     * @return the number of components
     */
    public int count() { return id.length; }

    /**
     * Unifies two components together by changing the first
     * identifier to match the second's identifier
     *
     * ex) 1:1 and 2:2 -> 1:2 and 2:2
     *
     * @param p - first comp
     * @param q - second comp
     */
    public void union(int p, int q) {

        int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot] = qRoot;

    }

    /**
     * Checks of the two components are connected
     * @param p - first comp
     * @param q - second comp
     * @return are the two components connected?
     */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }


}
