/*
Write a function called validBraces that takes a string of braces, and determines if the order of the braces is valid. validBraces should return true if the string is valid, and false if it's invalid.

This Kata is similar to the Valid Parentheses Kata, but introduces four new characters. Open and closed brackets, and open and closed curly braces. Thanks to @arnedag for the idea!

All input strings will be nonempty, and will only consist of open parentheses '(' , closed parentheses ')', open brackets '[', closed brackets ']', open curly braces '{' and closed curly braces '}'.

What is considered Valid? A string of braces is considered valid if all braces are matched with the correct brace. 
For example:
'(){}[]' and '([{}])' would be considered valid, while '(}', '[(])', and '[({})](]' would be considered invalid.

My solution explained:
Map for closing and opening brackets of same types.
Stack for opening brackets.

For each character if it's an opening character push it to stack. 
If it's a closing character and the stack is empty return false - means last char has no match
If it's a closing character and the stack is not empty pop from the stack and compare to the map.get(current). If not equal, return false
If after all above the stack is empty, return true.
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class BraceChecker {

  public boolean isValid(String braces) {
  
    Map<String, String> map = new HashMap<>();
    map.put("}", "{");
    map.put(")", "(");
    map.put("]", "[");
    String opening = "({[";
    String closing = "]})";
    Stack<String> stack = new Stack<>();
    
    System.out.println(braces);
    if(braces.length()%2 != 0) return false;
    if(closing.contains(braces.substring(0,1))) return false;
   
    for(int i = 0; i < braces.length(); i++){
      String current = braces.substring(i, i+1); 
      if(opening.contains(current)) stack.push(current);
      else{
          if(stack.isEmpty()) return false;
          else{
            String previous = stack.pop(); 
            if(!map.get(current).equals(previous)) return false;
          }
      }
    }
    
    if(stack.isEmpty()) return true;
    else return false;    
    
  }

}
