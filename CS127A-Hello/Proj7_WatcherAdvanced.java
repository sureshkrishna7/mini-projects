/*Proj7_Watcher
 *
 * cs127a Fall 15, Project 07
 * 
 * Author: Suresh Krishna Devendran
 * 
 * SL Name: Jon Weiser
 * 
 * ------
 * Draw eyes and make them look towards the mouse pointer. 
 */
public class Proj7_WatcherAdvanced
{
    public static void main(String[] args)
    {
        StdDraw.setScale(-50,50); //sets the scale from -50 to 50.
        double xPos = 13;         //sets the x center of the right eyeball and the right eye.
        double yPos = 0;          //sets the y center of the right eyeball and the right eye.
        double radiusBig = 10;    //sets the radius of the big circle(eye).
        double radiusSmall = 2;   //sets the radius of the small circle(eyeball).

        while (true) //an infinite loop.
        {
            StdDraw.clear();                            //clears the screen.
            drawEye(radiusBig,radiusSmall,xPos,yPos);   //calls the drawEye method to draw the right eye.
            drawEye(radiusBig,radiusSmall,-xPos,-yPos); //calls the drawEye method to draw the left eye.
            StdDraw.show(10);                           //shows the whole picture after a delay of 10 milliseconds.  
        } 
    }
    //a method to draw the eyball and the eye.
    public static void drawEye(double radiusBig,double radiusSmall,double xPos, double yPos)
    {   
        double xVector = StdDraw.mouseX() - (xPos);               //getting the x vector. 
        double yVector = StdDraw.mouseY() - (yPos);               //getting the y vector.
        double dist = calcDist(xVector,yVector);                  //calling the calcDist method to get the distance.
        double xPosBall = ((radiusBig-radiusSmall)/dist)*xVector; //gets the x position of the eyeball.
        double yPosBall = ((radiusBig-radiusSmall)/dist)*yVector; //gets the y position of the eyeball.

        StdDraw.circle(xPos,yPos,radiusBig); //draws the big circle with the respective parameters.
        
        if(dist < (radiusBig-radiusSmall))                                       //checks if the mouse pointer is inside the eye.
        {
            StdDraw.filledCircle(StdDraw.mouseX(),StdDraw.mouseY(),radiusSmall); //if inside, draws the eyeball with respect to the position of the mouse pointer.
        }
        else                                                                     //otherwise if the mouse pointer is outside the eye.  
        {
            StdDraw.filledCircle(xPosBall+xPos,yPosBall+yPos,radiusSmall);       //draws the eyeball with the respective parameters.
        }
    }
    //a method to calculate the distance.
    public static double calcDist(double xVector, double yVector)
    {
        return Math.sqrt(xVector*xVector+yVector*yVector); //returns the distance that it found out.
    }
}