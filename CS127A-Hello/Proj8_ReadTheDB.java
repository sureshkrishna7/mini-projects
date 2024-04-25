/*Proj8_ReadTheDB
 *
 * cs127a Fall 15, Project 08
 * 
 * Author: Suresh Krishna Devendran
 * 
 * SL Name: Jon Weiser
 * 
 * ------
 * Using Scanner to read text files.
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Proj8_ReadTheDB
{
    public static void main(String[] args) throws FileNotFoundException
    {   
        if (args.length == 0)                                  //checks if there is a command-line argument.
        {
            System.out.println("ERROR: Give in a file name."); //prints out the error if there is none.
            return;                                            //terminates the program.
        }
        
        String[] lastName = new String[1000];  //setting an array of size 1000 for the last name.
        String[] firstName = new String[1000]; //setting an array of size 1000 for the first name.
        int[] age = new int[1000];             //setting an array of size 1000 for the age.
        
        Scanner fileIn = new Scanner(new File(args[0])); //creating a new scanner object.
        int i = 0;                                       //initializing integer i as zero.
        int error = 0;                                   //initializing integer error as zero.
        
        while(fileIn.hasNext()) //a loop to check if there is a next line.
        {   
            if(i == lastName.length)                                       //checks if the program reached the end of the array limit.
            {
                System.out.println("ERROR: Maximum array limit reached."); //prints out the error message.
                break;                                                     //breaks the loop if it reached the end.
            }
            
            String word = fileIn.nextLine(); //sets the first line into a string named word.
            
            if (word.length() == 0) //checks if there is an empty line.
            {
                continue;           //skips the empty line silently.
            }
            
            if(word.indexOf(' ') == -1)                                       //checks if there is only one word.
            {
                System.out.println("ERROR: Line "+(i+error+1)+" is in wrong format."); //prints out the error.
                error++;                                                      //increments the error count.
                continue;                                                     //prints out the error and continues. 
                
            }

            lastName[i] = word.substring(0,word.indexOf(' '));        //cuts the last name from the entire string.
            word = word.substring(word.indexOf(' ')+1,word.length()); //cutshort the entire string to a smaller string.
            
            
            if(word.indexOf(' ') == -1)                                                              //checks if there is a space in between.
            {
                System.out.println("ERROR: Line "+(i+error+1)+" is in wrong format."); //prints out the error message.
                error++;                                                                             //increments the error count.
                continue;                                                                            //prints out the error and continues.
                
            }

            if(word.indexOf(' ') == 0)                                                         //checks if there are lots of spaces.
            {
                System.out.println("ERROR: Line "+(i+error+1)+" is in wrong format."); //prints out the error.
                error++;                                                                       //increments the error count.
                continue;                                                                      //prints out the error and continues.
            }

            firstName[i] = word.substring(0,word.indexOf(' '));       //cuts the first name from the entire string.
            word = word.substring(word.indexOf(' ')+1,word.length()); //cutshort the entire string to a smaller string.

            if(word.indexOf(' ') >= 0)                                                         //checks if there are lots of spaces.
            {
                System.out.println("ERROR: Line "+(i+error+1)+" is in wrong format."); //prints out the error.
                error++;                                                                       //increments the error count.
                continue;                                                                      //prints out the error and continues.
            }
            age[i] = Integer.parseInt(word); //looks for an integer in the string.

            i++; //increments the i count by 1.
        }
        fileIn.close(); //closes the scanner.
        
        String[] retval1 = new String[i]; //creating a new array with size i.
        String[] retval2 = new String[i]; //creating a new array with size i.
        int[] retval3 = new int[i];       //creating a new array with size i.

        for (int copy_len = 0; copy_len < i; copy_len++) //a for loop which runs till i.
        {
            retval1[copy_len] = firstName[copy_len];     //copies the first name array to retval1 array.
            retval2[copy_len] = lastName[copy_len];      //copies the last name array to retval2 array.
            retval3[copy_len] = age[copy_len];           //copies the age array to retval3 array.
            
            System.out.println("First Name = "+retval1[copy_len]+", Last Name = "+retval2[copy_len]+", Age = "+retval3[copy_len]); //prints out the entire database.
        }
        System.out.println("You have "+error+" errors in your file.");                     //prints out the number of errors in the file.
        System.out.println("You have "+i+" records in your arrays excluding the errors."); //prints out the number of records excluding the errors.
    }
}