package Sorts;

/**
 * SelectionSort
 * Function:
 *
 * Find smallest item of array, exchange it with first entry
 * Find nex smallest, exchange it with second entry
 * Continue until sorted
 *
 * @author Denielle Kirk Abaquita
 * @version 2019-01-17 @ 18:19
 */

public class SelectionSort
{

    /**
     * Finds the index of the minimum int in an int array
     * @param array - given
     * @return index of minimum value in array
     */
    static int findMinIndex(int[] array, int startIndex)
    {
        int min = Integer.MAX_VALUE, minIndex = 0;
        
        // Iterate over entire array and find min and minIndex
        for (int i = startIndex; i < array.length; i++)
        {
            if (array[i] < min)
            {
                min = array[i];
                minIndex = i;
            }
        }
        
        return minIndex;
    }

    /**
     * Effectively swaps the two values in an array
     * @param array - given
     * @param i - first index
     * @param j - second index
     */
    static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Checks if the array is sorted in ascending order
     * @param array - given array to check
     * @return true if ascending, false if not
     */
    static boolean isSortedAscending(int[] array)
    {
        // Iterate over entire array and check if ascending
        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] > array[i + 1])
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Efficient, method oriented ascneding selection sort
     * @param array - given
     * @return newly sorted array
     */
    static int[] selectionAscending(int[] array)
    {
        int minIndex = 0;

        // Check if array is already sorted
        if (isSortedAscending(array))
        {
            return array;
        }

        // Iterate over entire array
        for (int i = 0; i < array.length; i++)
        {
            minIndex = findMinIndex(array, i);
            swap(array, minIndex, i);
        }

        return array;
    }

    /**
     * Code comapcted into one method
     * @param array - original, unsorted array
     * @return sorted array
     */
    int[] selectionAscending2(int[] array)
    {
        int min = Integer.MAX_VALUE, minIndex = 0, temp;

        // Check if array is already sorted
        if (isSortedAscending(array))
        {
            return array;
        }

        // Iterate over entire array (except last index since there is no need)
        for (int i = 0; i < array.length - 1; i++)
        {
            // Iterate over part of the array to find min
            for (int j = i; j < array.length; j++)
            {
                if (array[j] < min)
                {
                    min = array[j];
                    minIndex = j;
                }
            }

            // Swap the current index with the min value's index
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        return array;
    }

    /**
     * Print array!
     * @param array - array to be printed
     */
    public static void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.printf("Array[%d] = %d\n", i, array[i]);
        }
    }

    /**
     * Test method
     */
    public static void main(String[] args)
    {
        int[] array = {1, 4, 3, 5, 2};

        printArray(array);

        array = selectionAscending(array);
        System.out.println();

        printArray(array);

        // Test the second selection sort method
        int[] array2 = {1, 4, 3, 5, 2};
        System.out.println();

        printArray(array2);

        array = selectionAscending(array2);
        System.out.println();

        printArray(array2);

    }

}
