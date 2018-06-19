package Percolation;

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
 * @version 6/15/18 @ 8:55 AM
 */

public class Percolation {

    // Instance variables
    private WeightedQuickUnionUF topUF;                 // top UF object, used for isFull()
    private WeightedQuickUnionUF backwashUF;            // top & bottom UF object w/ backwash, shows percolates()
    private boolean[] openSites;                        // array of open sites
    private final int SIZE, TOP_INDEX, BOTTOM_INDEX;    // the size of the grid, top node, bottom node
    private int numOpen;                                // number of open sites



    /**
     * Constructor
     * that creates an n-by-n grid with all sites blocked
     */
    public Percolation(int n) throws IllegalArgumentException
    {
        if (n <= 0) throw new IllegalArgumentException("N cannot be <= 0");

        SIZE = n * n;               // initializes the size of the grid, plus the two extra nodes
        TOP_INDEX = 0;
        BOTTOM_INDEX = SIZE + 1;

        // Initialize union-find data structures



    }

    /**
     * Validates a given index (must be between 1 and n)
     * @param row - value to test
     * @param col = value to test
     */
    private void validateIndex(int row, int col) throws IndexOutOfBoundsException
    {
        if ( row < 1 || row > SIZE || col < 1 || col > SIZE)
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

    }

    /**
     * Open site (row, col) if not open already
     * @param row - row coordinate
     * @param col - column coordinate
     */
    public void open(int row, int col)
    {

    }

    /**
     * is site (row, col) open?
     * @param row - row coordinate
     * @param col - column coordinate
     * @return is site open
     */
    public boolean isOpen(int row, int col)
    {

    }

    /**
     * is site (row, col) connected to the top by neighboring sites?
     * @param row - row coordinate
     * @param col - column coordinate
     * @return is site full
     */
    public boolean isFull(int row, int col)
    {

    }

    /**
     * @return number of open sites
     */
    public int numberOfOpenSites() { return openSites.length; }

    /**
     * @return does the grid percolate
     */
    public boolean percolates()
    {

    }

    /** Optional Test Client */
    public static void main(String[] args)
    {

    }
}
