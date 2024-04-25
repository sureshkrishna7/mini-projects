public class Exam2test3
{
    public static void main(String[] args) 
    {
        int x = Integer.parseInt(args[0]);
        
        for(int i=0;i<101;i++)
        {
            System.out.println("Multiple of "+i+" and "+x+" is "+i*x);
        }
    }
}