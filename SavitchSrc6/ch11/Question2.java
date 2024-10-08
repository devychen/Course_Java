public class Question2
{
    public static void main(String[] args)
    {
         methodB(3);
    }
    public static void methodB(int n)
    {
        if (n < 1)
            System.out.println('B');
        else
        {
            //The following two lines are the reverse of
            //what they are in Self-Test Question 1.
            System.out.println('R');
            methodB(n - 1);
        }
    }
}