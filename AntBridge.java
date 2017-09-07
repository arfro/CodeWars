/*

My pet bridge-maker ants are marching across a terrain from left to right.

If they encounter a gap, the first one stops and then next one climbs over him, then the next, and the next, until a bridge is formed across the gap.

What clever little things they are!

Now all the other ants can walk over the ant-bridge.

When the last ant is across, the ant-bridge dismantles itself similar to how it was constructed.

This process repeats as many times as necessary (there may be more than one gap to cross) until all the ants reach the right hand side.
Kata Task

My little ants are marching across the terrain from left-to-right in the order A then B then C...

What order do they exit on the right hand side?
Notes

    - = solid ground
    . = a gap
    The number of ants may differ but there are always enough ants to bridge the gaps
    The terrain never starts or ends with a gap
    Ants cannot pass other ants except by going over ant-bridges
    If there is ever ambiguity which ant should move, then the ant at the back moves first

Example
Input

    ants = GFEDCBA
    terrain = ------------...-----------

Output

    result = EDCBAGF


*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;

public class AntBridge {

  public static String antBridge(final String ants, final String terrain) {
   	
    List<String> terrainElements = new ArrayList<>();
    
    String result = ants;
   
    if(!terrain.contains(".")) return result;
    
    //terrain will always start from _ that means every odd indexed element is gaps and even indexed is terrain
    String pattern = "-+|\\.+";
    Pattern patternCompiled = Pattern.compile(pattern);
    Matcher matcher = patternCompiled.matcher(terrain);
    
    while(matcher.find()) {
        terrainElements.add(matcher.group());
    }
    
    //start from the first gap
    int counter = 0;
    for(int i = 1; i < terrainElements.size(); i=i+2){
      // subtract 1 from counter if the next group of -- is of length 1 AND it's not the last group
      if(terrainElements.get(i+1).length() == 1 && i+1 < terrainElements.size()-1) counter--;
      counter += terrainElements.get(i).length() + 2;
    }
     
    // return a string build from rotating ants counter amount of times
    result = rotateString(ants, counter);
    return result;
  }
  
  public static String rotateString(String input, int rotationSteps){
      char[] charArr = input.toCharArray();
      char[] result = new char[input.length()];
      
      for(int i = 0; i < input.length(); i++){
        result[(i + rotationSteps) % charArr.length] = charArr[i];
      }
      
      return new String(result);
  }
  
}
