/*Proj7_Chaser
 *
 * cs127a Fall 15, Project 07
 * 
 * Author: Suresh Krishna Devendran
 * 
 * SL Name: Jon Weiser
 * 
 * ------
 * A little circle follows the mouse pointer.
 */
import java.util.Random;
public class Proj7_Chaser
{
    public static void main(String[] args)
    {
        StdDraw.setScale(-50,50); //setting the scale from -50 and 50.
        double xBall = 0;         //setting the initial x position of the ball as zero.
        double yBall = 0;         //setting the initial y position of the ball as zero.
        
        Random randRed = new Random();   //creating a random object.
        Random randGreen = new Random(); //creating another random object.
        Random randBlue = new Random();  //creating anotehr random object.
        
        StdDraw.setPenColor(StdDraw.RED);    //setting the color of the initial circle as red.
        StdDraw.filledCircle(xBall,yBall,5); //drawing the first circle with radius 5.
        
        while(true) //an infinite loop.
        {
            
            int red = randRed.nextInt(256);     //setting a random integer in the range 0 and 255 to an int named red.
            int green = randGreen.nextInt(256); //setting a random integer in the range 0 and 255 to an int named green.
            int blue = randBlue.nextInt(256);   //setting a random integer in the range 0 and 255 to an int named blue.
            double xMouse = StdDraw.mouseX();   //getting the x mouse position and setting it to a double named xMouse.
            double yMouse = StdDraw.mouseY();   //getting the y mouse position and setting it to a double named yMouse.
            
            if (xMouse < xBall) //checks if the mouse is left of the ball.
            {                   //moves the ball left towards the mouse.
                xBall-=1;       
            } 
            
            if (xMouse > xBall) //checks if the mouse is right of the ball.
            {                   //moves the ball right towards the mouse.
                xBall+=1;       
            }
            
            if (yMouse < yBall) //checks if the mouse is below the ball.
            {                   //moves the ball down towards the mouse.
                yBall-=1;       
            }
            
            if (yMouse > yBall) //checks if the mouse is above the ball.
            {                   //moves the ball up towards the mouse.
                yBall+=1;       
            }

            StdDraw.setPenColor(red,green,blue); //sets the pen color using three random integers.
            StdDraw.filledCircle(xBall,yBall,5); //draws a filled circle with the ball position with radius 5.
            
            if (StdDraw.mousePressed() == true) //checks if the mouse is pressed.
            {
                StdDraw.clear();                //clears the screen if the mouse is pressed.
            }
            StdDraw.show(1); //makes the picture pause for a moment before the next frame.
        }
    }
}