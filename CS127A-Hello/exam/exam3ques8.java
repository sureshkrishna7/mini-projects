public class exam3ques8
{
    public static void main(String[] args)
    {
        String word = "H e l l o";
        System.out.println(""+numspace(word));

    }
    public  static int numspace(String word)
    {
        int count = 0;
        if(word.length() == 0)
        {
            return 0;
        }
        String nope = " ";
        for(int i=0; i<word.length(); i++)
        {
            String[] num = new String[word.length()];
            num[i] = word.substring(i,i+1);
            
            if (num[i] == nope)
            {
                count++;
            }
        }
        if (count != 0)
        {
            return word.length()-count;
        }
        else
        {
            return 1;
        }
    }
}