public class Exam2test4
{
    public static void main(String[] args) 
    {
        String word = args[0];
        character(word);
        System.out.println("Success");
        
    }
    public static char[] character(String word)
    {
        char[] num = new char[word.length()];
        
        for(int i=0; i<word.length(); i++)
        {
            num[i] = word.charAt(i);
            System.out.println("num["+i+"] = "+num[i]);
        }
        
        return num;        
    }
}