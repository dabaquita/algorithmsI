package Lesson1.Percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * PercolationStats
 * Purpose: Performs a series of
 * computational experiments in order
 * to calculate a percolation threshold value.
 *
 * @author Denielle Kirk Abaquita
 * @version 6/21/18 @ 12:06 PM
 */

public class PercolationStats {

    // Instance variables
    private double[] listP;            // holds the estimates of the percolation threshold

    /** CONSTRUCTOR
     * @param n - creates n-by-n grid, used for Percolation()
     * @param trials - number of independent experiments
     */
    public PercolationStats(int n, int trials)
    {
        listP = new double[trials];

        // Check parameters if within range
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("Value(s) not greater than 0.");

        for (int k = 0; k < trials; k++)
        {
            Percolation percolation = new Percolation(n);           // create new Percolation object

            // while system does not percolate, open random sites
            while (!percolation.percolates())
            {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n+ 1);

                percolation.open(row, col);                         // open the random site
            }

            listP[k] = (double) percolation.numberOfOpenSites() / (n * n);   // add estimate to list from number open / total
        }
    }

    /**
     * @return sample mean of percolation threshold
     */
    public double mean()
    {
        return StdStats.mean(listP);
    }

    /**
     * @return sample standard deviation of percolation threshold
     */
    public double stddev()
    {
        return StdStats.stddev(listP);
    }

    /**
     * @return low endpoint of 95% confidence interval
     */
    public double confidenceLo()
    {
        return mean() - (1.96 * stddev()) / Math.sqrt(listP.length);
    }

    /**
     * @return high endpoint of 95% confidence interval
     */
    public double confidenceHi()
    {
        return mean() + (1.96 * stddev()) / Math.sqrt(listP.length);
    }

    /** Test Client */
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        PercolationStats percolationStats = new PercolationStats(n, t);

        // print out results
        System.out.printf("%s%22s %1.5f", "mean", "=", percolationStats.mean());
        System.out.printf("\n%s%20s %1.5f", "stddev", "=", percolationStats.stddev());
        System.out.printf("\n%s%3s[%1.5f,%1.5f]", "95% confidence interval", "=",
                                        percolationStats.confidenceLo(), percolationStats.confidenceHi());
    }

}
