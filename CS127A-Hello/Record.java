/*Proj10_Record
 *
 * cs127a Fall 15, Project 10
 * 
 * Author: Suresh Krishna Devendran
 * 
 * SL Name: Jon Weiser
 * 
 * ------
 * Record class of objects.
 */
public class Record
{
    String firstName; //creating a string named firstName.
    String lastName;  //creating a string named lastName.
    int age;          //creating a string named age.
    
    public String toString() //creating a method called toString.
    {
        String person = firstName+" "+lastName+" "+age; //concatanates the strings into onw whole word.
        return person;                                  //returns the concatanated string.
    }
}