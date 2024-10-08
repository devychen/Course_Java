public class Question4
{
    public static void main(String[] args)
    {
        System.out.println(mysteryValue(3));
    }
    public static int mysteryValue(int n)
    {
        if (n <= 1)
            return 1;
        else
            return (mysteryValue(n - 1) + n);
    }
}