import java.util.*;
public class RevString {

  private void revString(String text)
  {
    Scanner s=new Scanner(System.in);
    if (!text.contains("."))
    {
      revString (s.nextLine()); 
    }
    
    System.out.println(text);
  }
  
  public static void main(String[] args) 
    
  { 
    Scanner sc=new Scanner(System.in);
    RevString r=new RevString();
    r.revString(sc.nextLine());
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
