/*Proj3_Repeat
 *
 * cs127a Fall 15, Project 03
 * 
 * Author: Suresh Krishna Devendran
 * 
 * SL Name: Jon Weiser
 * 
 * ------
 * To repeat a set of words over and over
 */

public class Proj3_Repeat
{
    public static void main(String[] args)
    {
      
        String a;
        String b;
        String c;
        int x;
        int y;
        int z;

         if (args.length == 0)
         {
            System.out.println("No arguments were given.");
            return;
         } 
        a = (args[0]);
        x = Integer.parseInt(args[1]);
         if (args.length == 2)
         {      for ( int i = 0; i < x; i++)
               {
                  System.out.println(a);
               }       
               return;
         }
        b = (args[2]);
        y = Integer.parseInt(args[3]);
         if (args.length == 4)
         {      for ( int i = 0; i < x; i++)
               {
                  System.out.println(a);
               }       
            
               for ( int i = 0; i < y; i++)
               {
                  System.out.println(b);
               } 
               return;
         }
        c = (args[4]);
        z = Integer.parseInt(args[5]);
         if (args.length == 6)
         {    for ( int i = 0; i < x; i++)
               {
                  System.out.println(a);
               }       
            
               for ( int i = 0; i < y; i++)
               {
                  System.out.println(b);
               }            

               for ( int i = 0; i < z; i++)
               {
                   System.out.println(c);
               }         
               return;
         }    
    }
}