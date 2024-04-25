/* Author: Suresh Krishna Devendran
 * Sectionk
 * 09/04/2015
 * Concentric circles project
 */
public class Proj1_ConcCircs
{
    public static void main(String[] args)
    {
        int val1;
            val1 = 10;
        int val2;
            val2 = 20;
            
        StdDraw.setScale(-100,100);
        StdDraw.clear(StdDraw.WHITE);
        
        if (val1 > val2)
        {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(0,0, val1);
     
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledCircle(0,0, val2);
        }
        else
        {
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledCircle(0,0, val2);
       
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(0,0, val1);
        }    
                
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(-90,90, ""+val1);

        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.text(-90,70, ""+val2);
    }
}    