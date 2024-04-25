
public class Sec14_Prog2
{
        /* --- METHODS THAT YOU NEED TO IMPLEMENT --- */
        
        public static char[][] initBoard()
        {
           char[][] board = new char[8][8];
          
          
          for(int x=0; x<8; x++)
            for(int y=0; y<3; y++)
            if((x+y)%2 == 0)
            {
                board[x][y] = 'r';
            }
          
          for(int x=0; x<8; x++)
            for(int y=5; y<8; y++)
            if((x+y)%2 == 0)
            {
                board[x][y] = 'b';
            }
          
          int x =0;
          int y =0;
          
          while (true)
          {
            if(!(board[x][y] == 'r' || board[x][y] == 'b'))
            {
                board[x][y] = ' ';
            }
            x++;
            if(x >= 8)
            {
              x=0;
              y++;
            }
            
            if(y >= 8)
            {
              break;
            }
          }
         
          return board;
        }
        
        public static void drawBoard(char[][] board)
        {
           StdDraw.clear();
          
          
          for(int x=0; x<8; x++)
            for(int y=0; y<8; y++)
            {
              if((x+y)%2 == 0)
              {
                StdDraw.setPenColor(122,122,122);
                StdDraw.filledRectangle(x+0.5,y+0.5, 0.5, 0.5); 
              }
              else
              {
                StdDraw.setPenColor(0,0,0);
                StdDraw.filledRectangle(x+0.5,y+0.5,0.5,0.5);
              }
            }
          
          for(int i=0; i<8 ;i++)
            for(int j=0; j<8; j++)
            { 
              if(board[i][j] == ('r'))
              {
                StdDraw.setPenColor(255,0,0);
                StdDraw.filledCircle(i+0.5,j+0.5,0.5);
              }
              else if(board[i][j] == ('R'))
              {
                StdDraw.setPenColor(255,0,0);
                StdDraw.filledCircle(i+0.5,j+0.5,0.5);
                StdDraw.setPenColor(255,255,255);
                StdDraw.line(i+0.5,j,i+0.5,j+1);
                StdDraw.line(i, j+0.5, i, j+0.5);
                
              }
              else if(board[i][j] == ('b'))
              {
                StdDraw.setPenColor(0,0,0);
                StdDraw.filledCircle(i+0.5,j+0.5,0.5);
              }
              else if(board[i][j] == ('B'))
              {
                StdDraw.setPenColor(0,0,0);
                StdDraw.filledCircle(i+0.5,j+0.5,0.5);
                StdDraw.setPenColor(255,255,255);
                StdDraw.line(i+0.5,j,i+0.5,j+1);
                StdDraw.line(i, j+0.5, i, j+0.5);
                
              }
            }
          
          
          StdDraw.show(0);
                
        }
        
        public static boolean isLegalMove(char[][] board,
                                          int startX, int startY,
                                          int   endX, int   endY)
        {
          if((startX+1==endX && startY+1==endY)||(startX-1==endX && startY-1==endY)||(startX+1==endX && startY-1==endY)|(startX-1==endX && startY+1==endY))
          {
            return true;
          }
          else
          {
            return false;
          }
          
         
        }
        
        
        
        /* --- METHODS THAT ARE ALREADY DONE ---
         *
         * You are allowed to change these methods if you like, but it
         * shouldn't be necessary.
         */
        
        public static void main(String[] args)
        {
                StdDraw.setScale(0,8);
                StdDraw.show(0);         // turns on buffered mode, so the board all appears at once
                
                // allocate a brand-new board
                char[][] board = initBoard();
                if (!sanityCheckBoard(board))
                        return;
                
                // draw the board to the screen
                drawBoard(board);
                
                // we use System.out (which prints to the Interactions pane)
                // as a way to communicate with the user; it's not a very good
                // one (text on the board would be better!), but I don't want
                // to interfere with the picture that the students have drawn.
                System.out.println("***********************");
                System.out.println("* WELCOME TO CHECKERS *");
                System.out.println("***********************");
                System.out.println();
                
                // the main loop of the game: wait for mouse moves
                boolean redToMove = true;
                while (true)
                {
                        if (redToMove)
                                System.out.println("It is RED's turn to move.");
                        else
                                System.out.println("It is BLACK's turn to move.");
                        
                        System.out.println("Click (don't drag!) on any piece to move it.");
                        System.out.println();
                        
                        // wait for the click on the *FIRST* square, which
                        // should be a piece.
                        while (StdDraw.mousePressed() == false)
                                StdDraw.show(10);
                        
                        // read the current mouse position, at the start of the click (drags are ignored)
                        int startX = (int)StdDraw.mouseX();
                        int startY = (int)StdDraw.mouseY();
                        
                        // loop until the user is *NO LONGER* clicking.  Note that our loop is more aggressive here (shorter wait time)
                        while (StdDraw.mousePressed())
                                StdDraw.show(1);
                        
                        // the user is no longer holding the mouse button...now process the click.
                        System.out.printf("You clicked on the location (%d,%d)\n", startX,startY);
                        if (startX < 0 || startX > 7 || startY < 0 || startY > 7)
                        {
                                System.out.printf("  ERROR: The location (%d,%d) is not on the board.  Your click has been ignored.\n", startX,startY);
                                System.out.println();
                                continue;   // go back to the head of the loop
                        }
                        if (board[startX][startY] == ' ')
                        {
                                System.out.println("  ERROR: You clicked on a location which is not occupied by a piece.  Please try again.");
                                System.out.println();
                                continue;   // go back to the head of the loop
                        }
                        
                        // check to see if the piece that the user clicked on was the right color.
                        if (redToMove != (board[startX][startY] == 'r' || board[startX][startY] == 'R'))
                        {
                                System.out.println("  ERROR: On the wrong color.  Please try again.");
                                System.out.println();
                                continue;   // go back to the head of the loop
                        }
                        
                        // wait for the next click; do the same algo as before...
                        while (StdDraw.mousePressed() == false)
                                StdDraw.show(10);
                        int endX = (int)StdDraw.mouseX();
                        int endY = (int)StdDraw.mouseY();
                        while (StdDraw.mousePressed())
                                StdDraw.show(1);
                        System.out.printf("Your second click was at the location (%d,%d)\n", endX,endY);
                        if (endX < 0 || endX > 7 || endY < 0 || endY > 7)
                        {
                                System.out.printf("  ERROR: The location (%d,%d) is not on the board.  Please start over from the beginning.\n", endX,endY);
                                System.out.println();
                                continue;   // go back to the head of the loop
                        }
                        
                        // is the move legal?  If not, then reject it.
                        if (isLegalMove(board, startX,startY, endX,endY) == false)
                        {
                                System.out.println("  The move is not legal.  Please select a different move.");
                                System.out.println();
                                continue;   // go back to the head of the loop
                        }
                        
                        // update the board by moving the piece to its new location; clear the start, and the jumped
                        // piece (if any).  Then swap the to-move flag (if the move was *NOT* a jump!)
                        //
                        // Finally, redraw the board.
                        board[  endX][  endY] = board[startX][startY];
                        board[startX][startY] = ' ';
                        
                        if (startX-endX == 2 || startX-endX == -2)
                                board[(startX+endX)/2][(startY+endY)/2] = ' ';
                        
                        // TODO: add logic to allow for multiple-jump moves
                        redToMove = !redToMove;
                        
                        drawBoard(board);
                }
        }
        
        public static boolean sanityCheckBoard(char[][] board)
        {
                /* confirm that the size of the array is correct.  This is
                 * the first dimension.
                 */
                if (board.length != 8)
                {
                        System.out.println("ERROR: Your initBoard() method does not allocate an 8x8 array!");
                        return false;
                }
                
                /* confirm that the size of the array is correct.  This is
                 * the second dimension for each sub-array.
                 */
                for (int i=0; i<8; i++)
                {
                        if (board[i].length != 8)
                        {
                                System.out.println("ERROR: Your initBoard() method does not allocate an 8x8 array!");
                                return false;
                        }
                }
                
                /* confirm that every element of the array is valid */
                for (int x=0; x<8; x++)
                        for (int y=0; y<8; y++)
                {
                        if (board[x][y] != ' ' &&
                            board[x][y] != 'r' && board[x][y] != 'b' &&
                            board[x][y] != 'R' && board[x][y] != 'B')
                        {
                                System.out.printf("ERROR: Your initBoard() method gives an invalid character at element [%d][%d]\n", x,y);
                                return false;
                        }
                }
                
                return true;
        }
}
