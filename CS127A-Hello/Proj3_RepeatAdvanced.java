public class Proj3_RepeatAdvanced
{
    public static void main(String[] args)
    {
      
        String a;
        String b;
        String c;
        int x;
        int y;
        int z;
        
        if (args.length == 2 || args.length == 4 || args.length == 6)
             {a = (args[0]);
              x = Integer.parseInt(args[1]);
              
              for ( int i = 0; i < x; i++)
              System.out.println(a);
              }
        if (args.length == 4 || args.length == 6)
        {b = (args[2]);
              y = Integer.parseInt(args[3]);
              
              for ( int i = 0; i < y; i++)
              System.out.println(b);
              }
        if (args.length == 6)
        {c = (args[4]);
              z = Integer.parseInt(args[5]);
              
              for ( int i = 0; i < z; i++)
              System.out.println(c);
              }
        
        if (args.length == 0)
        {
            System.out.println("No arguments were given.");
            return;
        }
    }
}