/*Proj9_SimpleDB
 *
 * cs127a Fall 15, Project 09
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
public class Proj9_SimpleDB
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
        }
        
        System.out.println("You have "+error+" errors in your file.");                     //prints out the number of errors in the file.
        System.out.println("You have "+i+" records in your arrays excluding the errors."); //prints out the number of records excluding the errors.
        
        Scanner search = new Scanner(System.in); //creating a new scanner object.
        
        while(search.hasNextLine()) //loop if there is a next line typed.
        {
            String command = search.nextLine();            //sets the entire line to a string named command.
            
            if(command.equals("listAll"))                  //checks if the command word equals listAll.
            {    listAll(retval1,retval2,retval3,i,error); //calls listAll method.
                 continue;                                 //if this statement runs it continues back to the begining of the loop.
            }

            if(command.indexOf(' ')>-1)                                  //checks if there is a space.
            {
                String pop = command.substring(0,command.indexOf(' '));  //breaks the first part to a string named pop.
                String rock = command.substring(command.indexOf(' ')+1); //breaks the second part to a string named rock.
               
                
                if(pop.equals("lastName"))                         //checks if the first part equals lastName.
                {    findByLastName(retval1,retval2,retval3,rock); //calls findByLastName method.
                }
                
                if(pop.equals("firstName"))                         //checks if the first part equals firstName.
                {    findByFirstName(retval1,retval2,retval3,rock); //calls findByFirstName method.
                }
                
                if(pop.equals("age"))                         //checks if the first part equals age.
                {    findByAge(retval1,retval2,retval3,rock); //calls findByAge method.
                }
            }
            
            if(command.indexOf(' ') == -1)                        //if there is no space found.
            {
                System.out.println("ERROR: invalid line typed."); //prints out the error message.
            }
        }
    }
    
    public static void listAll(String[] a, String[] b, int[] c,int num,int error)
    {
        for(int i = 0; i<a.length ; i++)                                                     //for loop to print out all the databases.
        {
            System.out.println("Last Name = "+b[i]+", First Name = "+a[i]+", Age = "+c[i]);  //prints out all the databases.
        }
        System.out.println("You have "+error+" errors in your file.");                       //prints out the number of errors in the file.
        System.out.println("You have "+num+" records in your arrays excluding the errors."); //prints out the number of records excluding the errors.
    }
    
    public static void findByLastName(String[] a, String[] b, int[] c, String rock)
    {
        int none = 0; //integer which counts after each iteration of the loop.
        
        for(int i = 0; i<b.length; i++)                                                         //loop runs till the length of the array of last names.
        {
            if(rock.equals(b[i]))                                                               //checks if the given name equals the name inside the file.
            {
                System.out.println("Last Name = "+b[i]+", First Name = "+a[i]+", Age = "+c[i]); //prints out all the databases.
                none++;                                                                         //increments none by one when the loop runs each time.
            }
        }
        
        if(none == 0)                                                                 //if the loop never runs
        {System.out.println("ERROR: No records found matching the last name given."); //its prints out the error message.
        }
        
        if(none > 0)                                                                      //if the loop ever runs
        {System.out.println("You have "+none+" record(s) matching the last name given."); //it prints out how many times it ran.
        }
    }
    public static void findByFirstName(String[] a, String[] b, int[] c, String rock)
    {
        int none = 0; //integer which counts after each iteration of the loop.
        
        for(int i = 0; i<a.length; i++)                                                         //loop runs till the length of the array of first names.
        {
            if(rock.equals(a[i]))                                                               //checks if the given name equals the name inside the file.
            {
                System.out.println("First Name = "+a[i]+", Last Name = "+b[i]+", Age = "+c[i]); //prints out all the databases.
                none++;                                                                         //increments none by one when the loop runs each time.
            }
        }
        
        if(none == 0)                                                                  //if the loop never runs
        {System.out.println("ERROR: No records found matching the first name given."); //its prints out the error message.
        }
        
        if(none > 0)                                                                      //if the loop ever runs
        {System.out.println("You have "+none+" record(s) matching the fist name given."); //it prints out how many times it ran.
        }
    }
    public static void findByAge(String[] a, String[] b, int[] c, String rock)
    {
        int none = 0; //integer which counts after each iteration of the loop.
        
        int age = Integer.parseInt(rock); //converting the string to an int.
        
        for(int i = 0; i<c.length; i++)                                                         //loop runs till the length of the array of ages.
        {
            if(age == c[i])                                                                     //checks if the given name equals the name inside the file.
            {
                System.out.println("Age = "+c[i]+", First Name = "+a[i]+", Last Name = "+b[i]); //prints out all the databases.
                none++;                                                                         //increments none by one when the loop runs each time.
            }
        } 
        
        if(none == 0)                                                           //if the loop never runs
        {System.out.println("ERROR: No records found matching the age given."); //its prints out the error message.
        }
        
        if(none > 0)                                                                //if the loop ever runs
        {System.out.println("You have "+none+" record(s) matching the age given."); //it prints out how many times it ran.
        }
    }
}