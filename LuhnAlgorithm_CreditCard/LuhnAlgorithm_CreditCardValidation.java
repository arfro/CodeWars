public class Validate{
  public static boolean validate(String n){
  
    int result = 0;
    boolean multiply = false;
    
    //edge cases
    if(n.length() == 0) return false;
    
    // Starting from the last digit if 'multiply' flag is true, multiply, add to result, toggle flag 
    // If flag is false, just add to result
    for(int i=n.length()-1; i >=0; i--){
      //'0' has a value of 48. '1' is 49. That way if we subtract '0' which in reality is 48 we get the required int value 
      int currentDigit = n.charAt(i) - '0';
      if(multiply){
        if((currentDigit * 2) < 9)
          currentDigit = currentDigit * 2;
          
        else
          currentDigit = (currentDigit * 2) - 9;
       }
      result += currentDigit;
      multiply = !multiply;
    }
    
    if(result%10 == 0) return true;
    else return false;
  }
}
