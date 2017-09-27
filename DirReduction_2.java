/*
This is a more elegant solution to a problem described in DirReduction.java :) 
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class DirReduction_2 {

    static Map<String, String> oppositeDirections = new HashMap<>();
    
    static {
      oppositeDirections.put("SOUTH", "NORTH");
      oppositeDirections.put("NORTH", "SOUTH");
      oppositeDirections.put("WEST", "EAST");
      oppositeDirections.put("EAST", "WEST");
    }
    
    public static String[] dirReduc(String[] arr) {
    
      Stack<String> stackOfDirections = new Stack<>();
      
      for(String dir : arr){
        if(!stackOfDirections.isEmpty()){
              //if the last element on stack is a "cancelling" value, pop it and continue to the next element.
              if(stackOfDirections.peek().equals(oppositeDirections.get(dir))){
                stackOfDirections.pop();
                continue;
                }
              else{
                 stackOfDirections.push(dir);
                }
              }//end  if(!stackOfDirections.isEmpty())
        else{
              stackOfDirections.push(dir);
            }
        
        }//end for loop
            
      return stackOfDirections.toArray(new String[stackOfDirections.size()]);
      
      }//end dirReduc function       
  
}
