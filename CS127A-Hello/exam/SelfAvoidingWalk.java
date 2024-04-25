public class SelfAvoidingWalk 
{
    public static void main(String[] args) 
    {
        int N = Integer.parseInt(args[0]);
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);
        
        while (true) 
        {
            StdDraw.clear();
            boolean[][] visited = new boolean[N][N];
            int x = N / 2;
            int y = N / 2;
            visited[x][y] = true;
                
                while (!visited[x-1][y] || !visited[x+1][y] || !visited[x][y-1] || !visited[x][y+1]) 
                {
                    while (true) 
                    {
                        double r = StdRandom.uniform();
                        if (r < 0.25 && !visited[x-1][y]) {
                            x--;
                            break;
                        }
                        else if (r < 0.50 && !visited[x+1][y]) {
                            x++;
                            break;
                        }
                        else if (r < 0.75 && !visited[x][y-1]) {
                            y--;
                            break;
                        }
                        else if (r < 1.00 && !visited[x][y+1]) {
                            y++;
                            break;
                        }
                        
                    }
                    visited[x][y] = true;

                StdDraw.filledSquare(x + 0.5, y + 0.5, .45);
                StdDraw.show(25);
                
                if (x <= 0 || x >= N-1 || y <= 0 || y >= N-1)
                {
                    break;
                }
            }
            StdDraw.show(10);
        }
    }
}
