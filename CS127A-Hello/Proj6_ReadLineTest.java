/*Proj6_ReadLineTest
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
public class Proj6_ReadLineTest
{
    public static void main(String[] args)
    {
        final int MAX_WORDS = 10;               //setting a constant to value 10.
        String[] words = new String[MAX_WORDS]; //an array of strings named 'words' with the maximum limit being 10.
        int count = 0;                          //integer 'count' starting with zero.
        
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
            System.out.println("First word = "+sub1);                          //prints out the broken first word.
            System.out.println("Second word = "+sub2);                         //prints out the broken second word.
            count++;                                                           //increments the count by one.
        }
    }
}