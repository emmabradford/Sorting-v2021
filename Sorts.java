import java.util.ArrayList;
/**
 * This Sorts object represents a class that perform
 * Bubble, Selection, Insertion, Merge, Quick, and Heap sorts
 * 
 * @author  
 * @version 
 */
public class Sorts extends SortUtilities
{

    public Sorts(String[] array)
    {
        super(array);
    }

    // The array to be sorted is a String array called 'array'

    // Whenever you need to swap two elements in 'array', call the 'swap(int a, int b)' method 
    // where a and b are the indices of the elements in 'array' that need to be swapped.  Every
    // time 'swap' is called, a snapshot of the array is taken, which is later used to 
    // compare against an exemplar (test example) to see if all of the swaps are correct.

    // All of your sorting methods should utilize 'in-place' sorting, meaning that elements
    // are always swapped, rather than being copied out to a temporary variable, and then copied 
    // back later.

    // Feel free to write any private helper methods you wish to use

    public void bubbleSort()    // ascending, bubbling up from beginning to end
    {
        int curr = 0;
        while(curr < array.length-1)
        {
            for(int i = 1; i < array.length-curr; i++)
            {
                if(array[i].compareTo(array[i-1]) <0)
                {
                    swap(i, i-1);
                }
            }
            curr++;
        }
        // String[] s = super.array;
        // int n = s.length;
        // for(int i = 0; i < n-1; i++)
        // {
            // for(int k = 0; k < n - i - 1; k++)
            // {
                // if(s[k].compareTo(s[k+1]) > 0)
                // {
                    // super.swap(k, k+1);
                // }
            // }
        // }
    }

    public void selectionSort() // ascending, selecting the maximum values
    {
        String[] s = super.array;
        int and = super.array.length-1;
        
        for(int i = and; i >= 0; i--)
        {
            //int indexMax = i;
            // for(int k = i-1; k >= 0; k--) 
            // {
                // if(s[k].compareTo(s[indexMax]) > 0)
                // {
                    // indexMax = k;
                // }
            // }
            int indexMax = findMax(0, i);
            System.out.println(indexMax);
            if(indexMax !=  i){
                super.swap(i, indexMax);
            }
        }
    }
    
    public int findMax(int start, int end)
    {
    int indexMax = end;
            for(int k = end-1; k >= start; k--) 
            {
                if(array[k].compareTo(array[indexMax]) > 0)
                {
                    indexMax = k;
                }
            }
            return indexMax;
    }
    
   

    public void insertionSort() // ascending, inserting values on the front end
    {
        String[] s = super.array;
        int n = s.length;
        for(int i = 1; i < n; i++)
        {
            String a = s[i];
            int k = i - 1;
            while(k >= 0 && s[k].compareTo(a) > 0)
            {
                //s[k+1] = s[k];
                super.swap(k+1, k);
                k = k-1;
            }
            s[k + 1] = a;
        }
    }

    public void mergeSort() // ascending, working from front to back
    {
        //String[] temp = new String[array.length];
        mergeSort(0, array.length-1);
    }
    
    public void mergeSort( int f, int l)
    {
        String[] arr = array;
        if(f < l)
        {
            int middle = (l + f) / 2;
            mergeSort(f, middle);
            mergeSort(middle+1, l);
            merge(f, middle, middle+1, l);
        }
    }
    
    public void merge(int f, int m1,int m2, int l)
    {
        if(array[m2].compareTo(array[m1]) > 0)
        {
            return;
        }
        while(f <= m1 && m2 <= l)
        {
            if(array[m2].compareTo(array[f]) > 0)
            {
                f++;
            }
            else
            {
                for(int i = m2; i > f; i--)
                {
                    super.swap(i, i - 1);
                }
                f++;
                m1++;
                m2++;
            }
        }
    }
    
    public void quickSort() // ascending, working from front to back
    {
        quickSort(0, array.length-1);
    }
    
    public void quickSort(int f, int l)
    {
        if(f<l)
        {
            int splitPoint = split(f, l);
            quickSort(f, splitPoint-1);
            quickSort(splitPoint+1, l);
        }
    }
    
    public int split(int f, int l)
    {
        String splitVal = array[f];
        int saveFirst = f;
        f++;
        while(f <= l)
        {
            boolean onCorrectSide = true;
            while(onCorrectSide)
            {
                if(array[f].compareTo(splitVal) > 0)
                {
                    onCorrectSide = false;
                }
                else
                {
                    f++;
                    onCorrectSide = f <= l;
                }
                
            }
            onCorrectSide = f <= l;
            while(onCorrectSide)
            {
                if(array[l].compareTo(splitVal) <= 0)
                {
                    onCorrectSide = false;
                }
                else
                {
                    l--;
                    onCorrectSide = f <= l;
                }
            }
            if(f < l)
            {
                swap(f, l);
                f++;
                l--;
            }
        }
        if(saveFirst != l)
        {
            swap(saveFirst, l);
        }
        return l;
    }

    public void heapSort()  // ascending
    {
        // Note that the 'reheapDown' and 'newHole' methods are already provided
        // in the abstract parent class (SortUtilities) for your use.
        for(int index = array.length/2-1; index>=0; index--)
        {
            reheapDown(array[index],index, array.length - 1);
        }
        
        for(int index = array.length - 1; index>= 1; index-- )
        {
            swap(0, index);
            if(index < 5)
            {
                boolean sorted = true;
                String pprior = array[0];
                for (int i = 1; i <= index; i++)
                {
                    if(array[i].compareTo(pprior) < 0)
                    {
                        sorted = false;
                    }
                    pprior = array[i];
                }
                if(sorted)
                {
                    return;
                }
            }
            reheapDown(array[0], 0, index - 1);
        }
    }
}
