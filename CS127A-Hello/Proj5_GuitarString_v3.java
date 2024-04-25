
/*Proj5_GuitarString_v3
 *
 * cs127a Fall 15, Project 05
 * 
 * Author: Suresh Krishna Devendran
 * 
 * SL Name: Jon Weiser
 * 
 * ------
 * Draw a Guitar string pattern, animate it and play with it with the help of a mouse.
 */

import java.util.Random;
public class Proj5_GuitarString_v3
{
    public static void main(String[] args)
    { 
       double[] velocity = new double[100]; //allocates a double of size 100 with name velocity.
       double[] yValue = new double[100];   //allocates a double of size 100 with name yValue.
       yValue[0] = 0;                       //sets the first value to zero.           
   
       StdDraw.setXscale(-50,51);   //sets the x scale from -50 to 51, so that there is a single space from the horizonatal line from left and right.         
       StdDraw.setYscale(-100,100); //sets the y scale from -100 to 100.       

       Random rand = new Random();  //creating a random object.
     /*
       for (int i=1; i<100; i++)                   //a loop to generate all the random values for the graph.
       {
           yValue[i] = (rand.nextDouble()*100)-50; //allocating random values to individual array of elements.
       }
*/
      while (true)                   //an infinite loop to draw and redraw the graph.
       {
           StdDraw.clear();          //clears the screen after it has drawn, to look like its an animation.  
           StdDraw.line(-49,0,50,0); //draws an horizontal line from -49 to 50 so that there is a space on left and right of the line.

           for (int b=1; b<velocity.length-1; b++)                                         //a loop to update the velocity values.
           {
               velocity[b] = velocity[b] + 0.01*(yValue[b-1] + yValue[b+1] - 2*yValue[b]); //equation to update the velocity values.   
           }
           for (int c=0; c<100; c++)                      //a loop to update the yValues. 
           {
               yValue[c] = 0.999*yValue[c] + velocity[c]; //equation to update the yValues.
           }
           if (StdDraw.mousePressed() == true){                              //checks if the mouse was clicked and if it was it goes inside the if statement.
                   int x = (int)(StdDraw.mouseX()+.5);                       //gets the x coordinate and converts it into a int from a double.
                   if (x<-48 || x>50){                                       //checks if the mouse was clicked outside the range.
                       System.out.println("Please click between the range"); //if it did it prints out this message and doesn't terminate the program.
                       continue;                                             //to ensure that the loop continues without throwing the out of bounds error.
                   }
                   int y = (int)(StdDraw.mouseY()+.5);                       //gets the y coordinate and converts it into a int from a double. 
                   yValue[x+48] = y;                                         //this makes sure that the new height corresponds to the correct x coordinate.
           }
           for (int d=1; d<100; d++)                                 //a loop to draw each line in the graph.
           {
               yValue[0]=0;                                          //sets the first value to zero.
               yValue[99]=0;                                         //sets the last value to zero.
               StdDraw.line((d-50), yValue[d-1],(d-50)+1,yValue[d]); //draws each line in the graph.
           }
           StdDraw.show(0); //this makes all the lines to appear all at once.
       }
       
    }
}