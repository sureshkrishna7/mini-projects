public class exam3
{
    public static void main(String[] args)
    {
        int[] foo = {1,2,3,4,5};
        int[] bar = {11,7,8,9,10};
        if(checkArray(foo,bar))
        {
            System.out.println("Success");
        }
        else
        {
            System.out.println("Failure");
        }
    }
    public static boolean checkArray(int[] foo, int[] bar)
    {
        for(int i=0; i<foo.length; i++)
        {
            int num = foo[i];
            for(int a=0; a<bar.length; a++)
            {
                if(num == bar[a])
                {
                    return true;
                }
            }
        }
        return false;
    }
}