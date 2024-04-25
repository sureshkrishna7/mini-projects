import java.util.Random;
public class AgarIo
{
    double xCell;
    double yCell;
    double size;
    double[] PosX;
    double[] PosY;
    
    public AgarIo()
    {
        xCell = 0;
        yCell = 0;
        size = 30;
        StdDraw.setScale(-1000,1000);
        PosX = new double[40];
        PosY = new double[40];
        for(int i=0; i<PosX.length; i++)
        {
        food(i);
        }
    }
    public void food(int i)
    {

            PosX[i] = (int)(-1000 + Math.random()*(1000));
            PosY[i] = (int)(-1000 + Math.random()*(1000));
    }
    public void draw()
    {
        StdDraw.clear();
        
        ballMovement();
 
        for(int a = 0; a<PosX.length; a++)
        {
            ballColor(a);
            StdDraw.filledCircle(PosX[a],PosY[a],10);
            
            if ((xCell - PosX[a]) <= size-10 && (yCell - PosY[a]) <= size-10)
            {
                ballCollapse(a);
            }
        }
        
        StdDraw.filledCircle(xCell,yCell,size);
        
        StdDraw.show(1);
    }
    
    public void ballMovement()
    {
        double xMouse = StdDraw.mouseX();
        double yMouse = StdDraw.mouseY();
        
        if (xMouse < xCell) //checks if the mouse is left of the ball.
        {                   //moves the ball left towards the mouse.
            xCell-=(5/Math.log(size));       
        } 
        
        if (xMouse > xCell) //checks if the mouse is right of the ball.
        {                   //moves the ball right towards the mouse.
            xCell+=(5/Math.log(size));       
        }
        
        if (yMouse < yCell) //checks if the mouse is below the ball.
        {                   //moves the ball down towards the mouse.
            yCell-=(5/Math.log(size));       
        }
        
        if (yMouse > yCell) //checks if the mouse is above the ball.
        {                   //moves the ball up towards the mouse.
            yCell+=(5/Math.log(size));       
        }
    }
    
    public void ballColor(int i)
    {
            if (i%2 == 0)
                StdDraw.setPenColor(StdDraw.BLUE);
            else if (i%3 == 0)
                StdDraw.setPenColor(StdDraw.YELLOW);
            else if (i%5 == 0)
                StdDraw.setPenColor(StdDraw.RED);
            else if (i%7 == 0)
                StdDraw.setPenColor(StdDraw.MAGENTA);
            else 
                StdDraw.setPenColor(StdDraw.GREEN);
    }
    
    public void ballCollapse(int a)
    {
        size = size + 0.1;
        food(a);
    
    }
}
    