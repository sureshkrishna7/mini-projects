/*Proj11Board
 *
 * cs127a Fall 15, Project 11
 * 
 * Author: Suresh Krishna Devendran
 * 
 * SL Name: Jon Weiser
 * 
 * ------
 * Using 2D array to simulate 2048 game.
 */
import java.util.Random;

public class Proj11Board
{
    private int[][] foo; //creating a 2D array named foo.
    
    public Proj11Board()       //creating a constructor named Proj11Board.
    {
        foo = new int[4][4];   //initializing the size of the array.
        StdDraw.setScale(0,4); //setting the scale of the window from 0 to 4.
    }
    
//-------------------------------------------    
    public void draw()         //creating a method called draw.
    { 
        StdDraw.clear();       //clears the screen.
        for(int a=0; a<4; a++) //nested for loops to iterate over the elements of the array.
        {
            for(int i=0; i<4; i++)
            {   //setting the rectangle color to a darker shade.
                StdDraw.setPenColor(255-16*(int)Math.log(foo[i][a]+2),255-16*(int)Math.log(foo[i][a]+2),255-16*(int)Math.log(foo[i][a]+2));
                StdDraw.filledRectangle(i+.5,a+.5,.5,.5);
                
                if(foo[i][a] != 0)
                {   //setting the pen color to black.
                    StdDraw.setPenColor(0,0,0);
                    StdDraw.text(i+.5,a+.5,""+foo[i][a]); //printing out the text.
                }
            }
        }
    }
    
//-------------------------------------------    
    public void addOne() //method which adds a random tile to the board (75% "2" and 25% "4").
    {
        while(true)      //loop to generate random values.
        {
        Random rand = new Random();
        Random rand1 = new Random();
        int x = rand.nextInt(4);
        int y = rand1.nextInt(4);
        int chance = rand.nextInt(4);

            if(foo[x][y] == 0)                   //if the tile is empty.
            {
                if(chance == 2) 
                {
                    StdDraw.text(x+.5,y+.5,"4");
                    foo[x][y] = 4;               //adds four to the board.
                }
                else
                {
                    StdDraw.text(x+.5,y+.5,"2");
                    foo[x][y] = 2;               //adds two to the board.
                }
                    return;
            }
        }
    }
 //--------------------------------------   
    public boolean shiftLeft() //shifts the tile to left without collapsing.
    {  
        int count = 0;
        for(int b=0; b<3; b++)
        {
            for(int a=0; a<3; a++)
            {
                for(int i=0; i<4; i++)  
                {
                    if(foo[a][i] == 0)           //checks for an empty tile.
                    {
                        foo[a][i] = foo[a+1][i]; //copies the right tile to left
                        foo[a+1][i] = 0;         //and deletes its value.
                        count++;
                    }
                }
            }
        }
        if(count >0) //checks if any change happened.
        {
            return true;
        }
        return false;
    }
    
    public boolean collapseLeft() //if two tile has the same digit, then they get collapsed.
    {
        int count = 0;
        for(int b=0; b<3; b++)
        {
            for(int a=0; a<3; a++)
            {
                for(int i=0; i<4; i++)
                {
                    if (foo[a][i] == foo[a+1][i]) //checks if both the tile are equal.
                    {
                        foo[a][i] = 2*foo[a][i];  //doubles the value of the collapsed tile.
                        foo[a+1][i] = 0;          //erases the tile which got collapsed.
                        count++;
                    }
                }
            }
        }
        shiftLeft();  //calls the method to shift the collapsed tile.
        if(count > 0) //checks if any change happened.
        {
            return true;
        }
        return false;
    }
    
//-----------------------------------------
    public boolean shiftRight() //shifts the tile to right without collapsing.
    {
        int count = 0;
        for(int b=1; b<4; b++){
            for(int a=1; a<4; a++)
            {
                for(int i=0; i<4; i++)  
                {
                    if(foo[a][i] == 0)           //checks for an empty tile.
                    {
                        foo[a][i] = foo[a-1][i]; //copies the left tile to right
                        foo[a-1][i] = 0;         //and deletes its value.
                        count++;
                    }
                }
            }
        }
        if(count > 0) //checks if any change happened.
        {
            return true;
        } 
        return false;
    }
    
    public boolean collapseRight() //if two tile has the same digit, then they get collapsed.
    {
        int count = 0;
        for(int b=3; b>0; b--){
            for(int a=3; a>0; a--)
            {
                for(int i=0; i<4; i++)
                {
                    if (foo[a][i] == foo[a-1][i]) //checks if both the tile are equal.
                    {
                        foo[a][i] = 2*foo[a][i];  //doubles the value of the collapsed tile.
                        foo[a-1][i] = 0;          //erases the tile which got collapsed.
                        count++;
                    }
                }
            }
        }
        shiftRight(); //calls the method to shift the collapsed tile.
        if(count > 0) //checks if any change happened.
        {
            return true;
        }
        return false;
    }
    
//----------------------------------------
    public boolean shiftUp() //shifts the tile to up without collapsing.
    {
        int count = 0;
        for(int b=1; b<4; b++){
            for(int i=1; i<4; i++)
            {
                for(int a=0; a<4; a++)  
                {
                    if(foo[a][i] == 0)           //checks for an empty tile.
                    {
                        foo[a][i] = foo[a][i-1]; //copies the down tile to up.
                        foo[a][i-1] = 0;         //and deletes its value.
                        count++;
                    }
                }
            }
        }
        if(count > 0) //checks if any change happened.
        {
            return true;
        }
        return false;
    }
    
    public boolean collapseUp() //if two tile has the same digit, then they get collapsed.
    {
        int count = 0;
        for(int b=3; b>0; b--){
            for(int i=3; i>0; i--)
            {
                for(int a=0; a<4; a++)  
                {
                    if(foo[a][i] == foo[a][i-1]) //checks if both the tile are equal.
                    {
                        foo[a][i] = 2*foo[a][i]; //doubles the value of the collapsed tile.
                        foo[a][i-1] = 0;         //erases the tile which got collapsed.
                        count++;
                        
                    }
                }
            }
        }
        shiftUp();    //calls the method to shift the collapsed tile.
        if(count > 0) //checks if any change happened.
        {
            return true;
        }
        return false;
    }
    
//--------------------------------------
    public boolean shiftDown() //shifts the tile to down without collapsing.
    {
        int count = 0;
        for(int b=0; b<3; b++){
            for(int i=0; i<3; i++)
            {
                for(int a=0; a<4; a++)  
                {
                    if(foo[a][i] == 0)           //checks for an empty tile
                    {
                        foo[a][i] = foo[a][i+1]; //shifts up value down
                        foo[a][i+1] = 0;         //and deletes its value.
                        count++;
                    }
                }
            }
        }
        if(count > 0) //checks if any change happened.
        {
            return true;
        }
        return false;
    }
    public boolean collapseDown() //if two tile has the same digit, then they get collapsed.
    {
        int count = 0;
        for(int b=0; b<3; b++){
            for(int i=0; i<3; i++)
            {
                for(int a=0; a<4; a++)  
                {
                    if(foo[a][i] == foo[a][i+1]) //checks if both the tile are equal.
                    {
                        foo[a][i] = 2*foo[a][i]; //doubles the value of the collapsed tile.
                        foo[a][i+1] = 0;         //erases the tile which got collapsed.
                        count++;
                    }
                }
            }
        }
        shiftDown();  //calls the method to shift the collapsed tile.
        if(count > 0) //checks if any change happened.
        {
            return true;
        }
        return false;
    }
//----------------------------------------
}