/*Proj3_Squares
 *
 * cs127a Fall 15, Project 03
 * 
 * Author: Suresh Krishna Devendran
 * 
 * SL Name: Jon Weiser
 * 
 * ------
 * Print out a series of squares
 */
public class Proj3_Squares
{
    public static void main(String[] args)
    {
        {
            if (args.length == 0 || args.length == 1)
            {
                System.out.println("ERROR: Exactly two arguments must be given: <start> <end>");
             return;
            }
        }
        
       int x = Integer.parseInt(args[0]);
       int y = Integer.parseInt(args[1]);
       int z = (y-x);

        {
            if (x>y)
                System.out.println("ERROR: The start value must be <= the end!");
            
        }
        for( int i=0; i<=z; i++)
        { 
           System.out.println("The square of "+(x+i)+" is "+((x+i)*(x+i))+".");
        }
    }   
}