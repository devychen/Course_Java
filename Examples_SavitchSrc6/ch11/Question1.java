
public class Question1
{
    public static void main(String[] args)
    {
         methodA(3);
    }
    public static void methodA(int n)
    {
        if (n < 1)
            System.out.println('B');
        else
        {
            methodA(n - 1);
            System.out.println('R');
        }
    }
}