/*Proj4_Gradient
 *
 * cs127a Fall 15, Project 04
 * 
 * Author: Suresh Krishna Devendran
 * 
 * SL Name: Jon Weiser
 * 
 * ------
 * Draw a gradient square
 */

public class Proj4_Gradient
{
    public static void main(String[] args)
    {
        
        if (args.length == 0)                  //If there is no values inserted then it prints out 
        {System.out.println("Type in a value");// this error message
         return;                               //and it terminates the code.
        }
        
        int z;                                 //This initializes the int Z
        z = Integer.parseInt(args[0]);         // and makes it into a argument.
        
        if (z > 255 || z < 0)                                         //The value that you enter should be between than 0 and 255 
        {System.out.println("ERROR: Type in values between 0 to 255");//if not it prints out the error message.
         return;                                                      //and it terminates the code.
        }
        
        StdDraw.show(0);                        // This command makes the program run all at once
        
        StdDraw.setScale(0,255);                // sets the scale from 0 and 255
        StdDraw.clear();  
        for(int x=0; x<255;x++)                 //This is the loop that makes thousands of squares.
           for (int i=0; i<255; i++)
        {  StdDraw.setPenColor(i,x,z);
           StdDraw.filledSquare(i,x,1);
        }
        StdDraw.show(0);
    }
}