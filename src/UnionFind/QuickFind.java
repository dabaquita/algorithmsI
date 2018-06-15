package UnionFind;

/**
 * QuickFind
 * Purpose: Implementation example for solving the
 * dynamic connectivity problem.
 *
 * ** ARRAY DATA TYPE VERSION **
 *
 * *** SLOW FOR HUGE PROBLEMS ***
 *
 * Quadratic time
 *
 * Worst Case Time: M N
 * M union-find operations on a set of N objects
 *
 * @author Denielle Kirk Abaquita
 * @version 6/12/18 @ 8:14 AM
 */

public class QuickFind {

    private int[] id;

    /** Constructor */
    public QuickFind(int N) {

        id = new int[N];

        for (int i = 0; i < id.length; i++)
            id[i] = i;
    }

    /**
     * Precondition: p has to be from 0 to id.length - 1
     * @param p - number to find
     * @return the identifier of the number
     */
    public int find(int p) {
        if (p < id.length && p >= 0)
            return id[p];

        System.out.println("The value to be found must be within range.");
        return -1;
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

        // values must to be taken out to maintain consistency
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++)
        {
            if (id[i] == pid)
                id[i] = qid;
        }
    }

    /**
     * Checks of the two components are connected
     * @param p - first comp
     * @param q - second comp
     * @return are the two components connected?
     */
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }


}
