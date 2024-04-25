import java.util.Scanner;
public class Exam2test2
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        
        while(in.hasNextLine())
        {
            System.out.println("Length of word = "+in.nextLine().length());
        }
    }
}