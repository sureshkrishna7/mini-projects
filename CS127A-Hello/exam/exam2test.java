public class exam2test
{
    public static void main(String[] args)
    {
        int[] foo = {1,2,3,4,5,0};
        int[] bar = {1,2,3,4,5,0};
        
        if(same(foo,bar) == true)
        {
            System.out.println("Success");
        }
        else
        {
            System.out.println("Failure");
        }
        
    }
    public static boolean same(int[] num, int[] num2)
    {
        if(num.length != num2.length)
        {
            return false;
        }
        
        int count =0;
        for(int i=0;i<num.length;i++)
        {
            if(num[i] == num2[i])
            {
                count++;
            }
        }
        if(count == num.length)
        {
            System.out.println("Count = "+count);
            System.out.println("num.length = "+num.length);
            return true;
        }
        else
        {
            return false;
        }
            
    }
}