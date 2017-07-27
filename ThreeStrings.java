public class ThreeStrings {
  public static String tripleTrouble(String one, String two, String three) {
  
    StringBuilder result = new StringBuilder();
    
    for(int i = 0; i < one.length(); i++){
      result.append(one.substring(i,i+1)).append(two.substring(i,i+1)).append(three.substring(i,i+1));
    }
    
    return new String(result);
  }
}
