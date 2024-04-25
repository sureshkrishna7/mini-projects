/*Proj6_InteractiveDraw
 *
 * cs127a Fall 15, Project 06
 * 
 * Author: Suresh Krishna Devendran
 * 
 * SL Name: Jon Weiser
 * 
 * ------
 * Read commands from the keyboard and draw to the screen.
 */
import java.util.Scanner;
public class Proj6_InteractiveDraw
{
    public static void main(String[] args)
    {
        final int MAX_WORDS = 20;               //setting a constant to value 10.
        String[] words = new String[MAX_WORDS]; //an array of strings named 'words' with the maximum limit being 20.
        int count = 0;                          //integer 'count' starting with zero.
        
        StdDraw.setScale(-50,50);       //sets the scale from -50 to 50.
        
        //setting COLORS to their respective names for more clarity.
        String red = "red";             //sets the word 'red' to a string named red.
        String green = "green";         //sets the word 'green' to a string named green.
        String blue = "blue";           //sets the word 'blue' to a string named blue.
        String white = "white";         //sets the word 'white' to a string named white.
        String black = "black";         //sets the word 'black' to a string named black.
        
        //setting SHAPES to their respective names for more clarity.
        String circle = "circle";       //sets the word 'circle' to a string named circle.
        String square = "square";       //sets the word 'square' to a string named square.
        String rectangle = "rectangle"; //sets the word 'rectangle' to a string named rectagle.
        
        Scanner in = new Scanner(System.in);
        while(in.hasNext())                                                  //loop to ensure that the program keeps on running as long as there is an another word typed.
        {
            
            words[count] = in.nextLine();                                    //gets the next word and stores it into the array of strings.
            int idx = words[count].indexOf(' ');                             //gets the index of blank space.
            if (idx < 0)                                                     //if there is no blank space, indexOf returns -1 and goes inside the if statement.
            {
                System.out.println("ERROR:line doesn't contain any spaces"); //if the condition is true it prints out the error message.
                continue;                                                    //skips back to the begining of the loop.
            }
            String sub1 = words[count].substring(0,idx);                       //breaks the text and stores the first word into the substring.
            String sub2 = words[count].substring(idx+1,words[count].length()); //breaks the text and stores the word after the blank space index.
  
            if (sub1.equals(red))                //checks if the first word equals 'red'.
            {StdDraw.setPenColor(StdDraw.RED);   //if so sets the pen color to red.
            }
            if (sub1.equals(green))              //checks if the first word equals 'green'.
            {StdDraw.setPenColor(StdDraw.GREEN); //if so sets the pen color to green.
            }
            if (sub1.equals(blue))               //checks if the first word equals 'blue'.
            {StdDraw.setPenColor(StdDraw.BLUE);  //if so sets the pen color to blue.
            }
            if (sub1.equals(white))              //checks if the first word equals 'white'.
            {StdDraw.setPenColor(StdDraw.WHITE); //if so sets the pen color to white.
            }
            if (sub1.equals(black))              //checks if the first word equals 'black'.
            {StdDraw.setPenColor(StdDraw.BLACK); //if so sets the pen color to black.
            }
            //if everything is false it goes inside this if statement and prints out the error message.
            if (sub1.equals(red) == false && sub1.equals(green) == false && sub1.equals(blue) == false && sub1.equals(white) == false && sub1.equals(black) == false)
            {System.out.println("ERROR: color not supported. Instead try red, green, blue, white or black."); 
             continue; //skips back to the begining of the loop.                                                                                    
            } 
            
            if (sub2.equals(circle))         //checks if the second word equals 'circle'.
            {StdDraw.circle(-10,0,35);       //if so then draws a circle with the specified measurements.
            }
            if (sub2.equals(square))         //checks if the second word equals 'square'.
            {StdDraw.square(10,-15,25);      //if so then draws a square with the specified measurements.
            }
            if (sub2.equals(rectangle))      //checks if the second word equals 'rectangle'.
            {StdDraw.rectangle(-5,20,35,15); //if so then draws a rectangle with the specified measurements.
            }
            //if everything is false it goes inside this if statement and prints out the error message.
            if (sub2.equals(circle) == false && sub2.equals(square) == false && sub2.equals(rectangle) == false)
            {System.out.println("ERROR: shape not supported. Instead try circle, square or rectangle.");
             continue; //skips back to the begining of the loop.
            }
            System.out.println("First word = "+sub1);          //prints out the broken first word.
            System.out.println("Second word = "+sub2);         //prints out the broken second word.
            
            count++;                                           //increments the count by one.
        }
    }
}