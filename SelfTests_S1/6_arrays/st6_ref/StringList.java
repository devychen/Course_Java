package st6_ref;

/**
 * Data Structures 2010 / 2011
 * ch07 Array as instance variable example
 */
public class StringList 
{   
    // initial size - if none is given in constructor
    public static int INITIAL_SIZE = 3;
    
    String[] list;  // array instance variable
    int numElements;  // number of elements currently in list
    
    public StringList()
    {
        numElements = 0;
        list = new String[INITIAL_SIZE];
    }
    
    public StringList(int initialSize)
    {
        numElements = 0;
        list = new String[initialSize];
    }
    
    public void add(String item)
    {    
        // transfer list to a larger array when full
        if (numElements == list.length)
        {
            String[] tmp = new String[numElements + INITIAL_SIZE];
            for (int i=0; i < numElements; i++)
            {
                tmp[i] = list[i];
            }
            list = tmp;
        }
        
        // add item
        list[numElements] = item;
        numElements++;
        
    }
    
    public boolean contains(String item)
    {
        boolean found = false;
        for (int i=0; (i < numElements) && !found; i++)
        {
            if (list[i].equalsIgnoreCase(item))
            {
                found = true;
            }           
        }
        return found;
    }
    
    public String get(int index)
    {
        String result = null;
        if ((index >= 0) && (index < numElements))
        {
            result = list[index];
        }
        return result;
    }
    
    public String toString()
    {
        String rval = "[";
        for (int i=0; i < numElements; i++)
        {
            rval += list[i] + ", ";
        }
        rval = rval.substring(0, rval.length()-2); //remove trailing ", "
        rval += "]";
        return rval;
    }
}