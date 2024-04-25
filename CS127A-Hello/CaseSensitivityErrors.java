public class CaseSensitivityErrors
{
 public static void main(String[] args)
 {
  System.out.println("This class is full of case-sensitivity errors");

  String x = "hello";

  String y = "Hello";

  if(x.equals(y))
  {
      System.out.println("Equal");
  }
  else
  {
      System.out.println("Not Equal");
  }
 }
}

