public class exam3ques9
{
    public static void main(String[] args)
    {
        long foo = ;

        if(isPrime(foo))
        {
            System.out.println("Success");
        }
        else
        {
            System.out.println("Failure");
        }
    }
    public static boolean isPrime(long num)
    {
        for(int i=2; i<num; i++)
        {
            if(num != i)
            {
                if(num%i == 0)
                {
                    return false;
                }
            }
        }
        return true;     
    } 
}