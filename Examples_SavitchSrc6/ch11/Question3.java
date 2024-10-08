public class Question3
{
    public static void main(String[] args)
    {
         displaySharps(3);
    }
	
	/**
	 Precondition: n >= 1.
	 Displays the symbol '#' n times on one line
	 and then advances to the next line.
	*/
	public static void displaySharps(int n)
	{
		if (n <= 1)
			System.out.println('#');
		else
		{
			System.out.print('#');
			displaySharps(n - 1); 
		}
	}
}