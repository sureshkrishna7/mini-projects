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
public class Proj7_Watcher
{
    public static void main(String[] args)
    {
        StdDraw.setScale(-50,50); //sets the scale from -50 to 50.
        double xPos = 13;         //sets the x center of the right eyeball and the right eye.
        double yPos = 0;          //sets the y center of the right eyeball and the right eye.
        double radiusBig = 10;    //sets the radius of the big circle(eye).
        double radiusSmall = 2; //sets the radius of the small circle(eyeball).
        
        while (true) //an infinite loop.
        {
            StdDraw.clear(); //clears the screen.
            double xVectorRight = StdDraw.mouseX() - (xPos); //right eyeball x vector.
            double yVectorRight = StdDraw.mouseY() - (yPos); //right eyeball y vector.
            
            double xVectorLeft = StdDraw.mouseX() - (-xPos); //left eyeball x vector.
            double yVectorLeft = StdDraw.mouseY() - (-yPos); //left eyeball y vector.
            
            //calls calcDist method to get the distance between the eyeball and the pointer.
            double distRight = calcDist(xVectorRight,yVectorRight); //distance of the right eyeball from the mouse pointer.
            double distLeft = calcDist(xVectorLeft,yVectorLeft);    //distance of the left eyeball from the mouse pointer.
            
            double xPosBallRight = ((radiusBig-radiusSmall)/distRight)*xVectorRight; //gets the x position of the right eyeball. 
            double yPosBallRight = ((radiusBig-radiusSmall)/distRight)*yVectorRight; //gets the y position of the right eyeball.
            
            double xPosBallLeft = ((radiusBig-radiusSmall)/distLeft)*xVectorLeft; //gets the x position of the left eyeball.
            double yPosBallLeft = ((radiusBig-radiusSmall)/distLeft)*yVectorLeft; //gets the y position of the left eyeball.
            
            drawEye(xPosBallRight,yPosBallRight,radiusBig,radiusSmall,xPos,yPos,distRight); //calls the drawEye method to draw the right eye.
            drawEye(xPosBallLeft,yPosBallLeft,radiusBig,radiusSmall,-xPos,-yPos,distLeft);  //calls the drawEye method to draw the left eye.
            
            StdDraw.show(10); //shows the whole picture after a delay of 10 milliseconds. 
            
        }
        
    }
    //a method to draw the eyball and the eye.
    public static void drawEye(double xPosBall, double yPosBall, double radiusBig,double radiusSmall,double xPos, double yPos,double dist)
    {   
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