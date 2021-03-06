/*

Given a list lst and a number N, create a new list that contains each number of lst at most N times without reordering. 
For example if N = 2, and the input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next [1,2] since this would 
lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].

*/
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class EnoughIsEnough {
  
public static int[] deleteNth(int[] elements, int maxOcurrences) {
		
    Map<Integer, Integer> occurences = new HashMap<>();
    ArrayList<Integer> result = new ArrayList<>();
    
    if(elements == null) return new int[]{};
    if(elements.length == 0) return new int[]{};
    if(elements.length == 1) return new int[]{elements[0]};
    
    // for each element if assign it to a hashmap that holds the count of element occurence as its value.
    // if map doesnt contain the current iteration's number, add it to the map and append to result arrayList
    for(int i = 0; i < elements.length; i++){
      if(!occurences.containsKey(elements[i])){
         occurences.put(elements[i], 1);
         result.add(elements[i]);
        }
     // if map contains the element check if it occured less than maxOccurences times. If so, append to result arrayList
     // if not, skip and do not append
      else{
        if(occurences.get(elements[i]) < maxOcurrences){
           occurences.put(elements[i], occurences.get(elements[i]) + 1);
           result.add(elements[i]);
          }  
        }
    }
    
		return result.stream().mapToInt(i->i).toArray();
	}

}
