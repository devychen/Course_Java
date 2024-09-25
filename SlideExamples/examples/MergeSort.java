package examples;


/**
 Class for sorting an array of integers from smallest to largest
 using the merge sort algorithm.
 */
public class MergeSort
{
    /**
     Precondition: Every indexed variable of the array a has a value.
     Postcondition: a[0] <= a[1] <= ... <= a[a.length - 1].
     */
    public static void sort(int[] a)
    {
        if (a.length >= 2)
        {
            int halfLength = a.length / 2;
            int[] firstHalf = new int[halfLength];
            int[] lastHalf = new int[a.length - halfLength];
            divide(a, firstHalf, lastHalf);
            sort(firstHalf);
            sort(lastHalf);
            merge(a, firstHalf, lastHalf);
        }
        //else do nothing. a.length == 1, so a is sorted.
    }

    //Precondition: a.length = firstHalf.length + lastHalf.length.
    //Postcondition: All the elements of a are divided
    //between the arrays firstHalf and lastHalf.
    private static void divide(int[] a, int[] firstHalf, int[] lastHalf)
    {
        for (int i = 0; i < firstHalf.length; i++)
            firstHalf[i] = a[i];
        for (int i = 0; i < lastHalf.length; i++)
            lastHalf[i] = a[firstHalf.length + i];
    }

    //Precondition: Arrays firstHalf and lastHalf are sorted from
    //smallest to largest; a.length = firstHalf.length + lastHalf.length.
    //Postcondition: Array a contains all the values from firstHalf
    //and lastHalf and is sorted from smallest to largest.
    private static void merge(int[] a, int[] firstHalf, int[] lastHalf)
    {
        int firstHalfIndex = 0, lastHalfIndex = 0, aIndex = 0;

        // NOTE 比较两个子数组的当前元素，谁小就放到 a 数组中
        while ((firstHalfIndex < firstHalf.length) &&
                (lastHalfIndex < lastHalf.length))
        {
            if (firstHalf[firstHalfIndex] < lastHalf[lastHalfIndex])
            {
                a[aIndex] = firstHalf[firstHalfIndex];
                firstHalfIndex++;
            }
            else
            {
                a[aIndex] = lastHalf[lastHalfIndex];
                lastHalfIndex++;
            }
            aIndex++;
        }
        //At least one of firstHalf and lastHalf has been
        //completely copied to a.

        // NOTE 如果 firstHalf 中还有剩余元素，继续复制到 a 中
        //Copy rest of firstHalf, if any.
        while (firstHalfIndex < firstHalf.length)
        {
            a[aIndex] = firstHalf[firstHalfIndex];
            aIndex++;
            firstHalfIndex++;
        }

        // NOTE 如果 lastHalf 中还有剩余元素，继续复制到 a 中
        //Copy rest of lastHalf, if any.
        while (lastHalfIndex < lastHalf.length)
        {
            a[aIndex] = lastHalf[lastHalfIndex];
            aIndex++;
            lastHalfIndex++;
        }
    }
}
