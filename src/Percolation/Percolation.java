package Percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Percolation
 * Purpose: Model of percolation
 * system
 *
 * Definitions:
 *
 * open site - able to connect to nearby sites
 *
 * full site - an open site that is connected to the top
 * by connection to other open sites
 *
 * backwash - some open sites connected to bottom
 * that are not connected to top can be described as
 * full bc they have the same identifiers with the
 * actual full site if system percolates
 *
 * percolates - if top and bottom are connected by open sites
 *
 * @author Denielle Kirk Abaquita
 * @version 6/21/18 @ 11:25 AM
 */

public class Percolation {

    // Instance variables
    private WeightedQuickUnionUF topUF;                     // top UF object, used for isFull()
    private WeightedQuickUnionUF backwashUF;                // top & bottom UF object w/ backwash, shows percolates()
    private boolean[] openSites;                            // array of open sites
    private final int n, TOP_INDEX, BOTTOM_INDEX;           // the size of the grid, top node, bottom node
    private int numOpen = 0;                                // number of open sites

    /**
     * Constructor
     * that creates an n-by-n grid with all sites blocked
     */
    public Percolation(int n) throws IllegalArgumentException
    {
        if (n <= 0) throw new IllegalArgumentException("N cannot be <= 0");

        this.n = n;
        int SIZE = (n + 2) * (n + 2);
        TOP_INDEX = 0;                          // top virtual node
        BOTTOM_INDEX = SIZE - 1;                // bottom virtual node

        openSites = new boolean[SIZE];          // initialize open sites list
        for (int i = 0; i < SIZE; i++)
        {
            openSites[i] = false;               // all sites are closed by default
        }

        // Initialize union-find data structures
        topUF = new WeightedQuickUnionUF(SIZE);
        backwashUF = new WeightedQuickUnionUF(SIZE);

        // Union corresponding sites (inclusive of 1 and n)
        for (int i = 1; i <= n; i++)
        {
            topUF.union(TOP_INDEX, xyto1D(0, i));               // Top UF object for is in isFull(), no backwash

            backwashUF.union(TOP_INDEX, xyto1D(0, i));          // Fully connected UF object so show percolates()
            backwashUF.union(BOTTOM_INDEX, xyto1D(n, i));
        }
    }

    /**
     * Validates a given index (must be between 1 and n)
     * @param row - value to test
     * @param col = value to test
     */
    private void validateIndex(int row, int col) throws IndexOutOfBoundsException
    {
        if ( row < 1 || row > n || col < 1 || col > n)
            throw new IndexOutOfBoundsException("Index is not between 1 and n, inclusive.");
    }

    /**
     * Maps 2D coordinates to a 1D coordinate union find index
     * @param row - index of the row [1,n]
     * @param col - index of the column [1,n]
     * @return the 1D union find index
     */
    private int xyto1D(int row, int col)
    {
        return (col + 2) + row * n;     // converts the 2D coordinate to a unique 1D identifier
    }

    /**
     * Open site (row, col) if not open already
     * @param row - row coordinate
     * @param col - column coordinate
     */
    public void open(int row, int col)
    {
        validateIndex(row, col);
        if (isOpen(row, col)) return;               // return if the site is already open

        int site1D = xyto1D(row, col);         // variables holds the 1D index of site
        openSites[site1D] = true;              // open the site by changing value at the index to true

        // Connection of first row to top virtual node
        if (row == 1)
        {
            topUF.union(TOP_INDEX, xyto1D(row, col));
            backwashUF.union(TOP_INDEX, xyto1D(row, col));
        }

        // Connection to top site if open
        if (row > 1 && isOpen(row - 1, col))
        {
            topUF.union(site1D, xyto1D(row - 1, col));
            backwashUF.union(site1D, xyto1D(row - 1, col));
        }
        
        // Connection to right site if open
        if (col < n && isOpen(row, col + 1))
        {
            topUF.union(site1D, xyto1D(row, col + 1));
            backwashUF.union(site1D, xyto1D(row, col + 1));
        }

        // Connection to bottom site if open
        if (row < n && isOpen(row + 1, col))
        {
            topUF.union(site1D, xyto1D(row + 1, col));
            backwashUF.union(site1D, xyto1D(row + 1, col));
        }

        // Connection to left site if open
        if (col > 1 && isOpen(row, col - 1))
        {
            topUF.union(site1D, xyto1D(row, col - 1));
            backwashUF.union(site1D, xyto1D(row, col - 1));
        }

        numOpen++;                                  // increment number of open sites
    }

    /**
     * is site (row, col) open?
     * @param row - row coordinate
     * @param col - column coordinate
     * @return is site open
     */
    public boolean isOpen(int row, int col)
    {
        validateIndex(row, col);

        int indexOfSite = xyto1D(row, col);

        return openSites[indexOfSite];
    }

    /**
     * is site (row, col) connected to the top by neighboring sites (ie TOP_INDEX)?
     * @param row - row coordinate
     * @param col - column coordinate
     * @return is site full
     */
    public boolean isFull(int row, int col)
    {
        validateIndex(row, col);

        int indexOfSite = xyto1D(row, col);                 // convert to 1D coordinate

        return topUF.connected(TOP_INDEX, indexOfSite);     // returns if site is connected to the top index
    }

    /**
     * @return number of open sites
     */
    public int numberOfOpenSites() { return numOpen; }

    /**
     * @return does the grid percolate
     */
    public boolean percolates()
    {
        return backwashUF.connected(TOP_INDEX, BOTTOM_INDEX);       // are top and bottom virtual sites connected?
    }

    /** Optional Test Client */
    public static void main(String[] args)
    {

    }
}
