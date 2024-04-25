/*Proj5_GuitarString_v1
 *
 * cs127a Fall 15, Project 05
 * 
 * Author: Suresh Krishna Devendran
 * 
 * SL Name: Jon Weiser
 * 
 * ------
 * Draw a Guitar string pattern
 */

import java.util.Random;
public class Proj5_GuitarString_v1
{
    public static void main(String[] args)
    { 
       /*
       allocating an array of doubles which represent the
       height(yValue) of the string at a variety of points.
       */
       double[] yValue = new double[100];
       yValue[0] = 0;                     //the first value is set to zero.
       
       StdDraw.setXscale(-50,51);         //xscale set from -50 to 51,it gives us a space extra on both sides of the line.
       StdDraw.setYscale(-100,100);       //setting yscale from -100 to 100.
       StdDraw.setPenColor(StdDraw.BLUE); //setting the color of line to blue to make it more distinguishable.
       StdDraw.line(-49,0,50,0);          //the horizontal zero line drawn from -49 to 50, gives us a extra space on both ends.
       
       Random rand = new Random();        //creating a random object.
       
       for(int i=1; i<100; i++)           //a for loop for drawing the lines between random points.
       { 
           yValue[i] = (rand.nextDouble()*100)-50;            //generates random values from -50 to 50.
           yValue[99] = 0;                                    //the last value is set to zero.
           StdDraw.setPenColor(StdDraw.BLACK);                //setting the color of the string to black(or else it would draw in blue).
           StdDraw.line(i-50,yValue[i-1],(i-50)+1,yValue[i]); //gives the x and y values for drawing the string pattern.
       }
    }
}