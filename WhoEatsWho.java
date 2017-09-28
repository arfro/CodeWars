import java.util.*;

public class WhoEatsWho {
  
  static Map<String, HashSet<String>> eatingRules = new HashMap<>();
    
  static {
      eatingRules.put("antelope", new HashSet<String>(Arrays.asList("grass")));
      eatingRules.put("big-fish", new HashSet<String>(Arrays.asList("little-fish")));
      eatingRules.put("bug", new HashSet<String>(Arrays.asList("leaves")));
      eatingRules.put("bear", new HashSet<String>(Arrays.asList("big-fish", "bug", "chicken", "cow", "leaves", "sheep")));
      eatingRules.put("chicken", new HashSet<String>(Arrays.asList("bug")));
      eatingRules.put("cow", new HashSet<String>(Arrays.asList("grass")));
      eatingRules.put("fox", new HashSet<String>(Arrays.asList("chicken", "sheep")));
      eatingRules.put("giraffe", new HashSet<String>(Arrays.asList("leaves")));
      eatingRules.put("lion", new HashSet<String>(Arrays.asList("antelope", "cow")));
      eatingRules.put("panda", new HashSet<String>(Arrays.asList("leaves")));
      eatingRules.put("sheep", new HashSet<String>(Arrays.asList("grass")));
      eatingRules.put("little-fish", new HashSet<String>(Arrays.asList("")));
      eatingRules.put("leaves", new HashSet<String>(Arrays.asList("")));
      eatingRules.put("grass", new HashSet<String>(Arrays.asList("")));
    }
    


  public static String[] whoEatsWho(final String zoo) {
      
    String[] zooArray = zoo.split(",");
    List<String> result = new ArrayList<>();
    Stack<String> resultStack = new Stack<>();
    
    result.add(zoo);
    
    for(String animal : zooArray){
    
      //if animal is unknown, add to stack and continue
      if(!isAnimalKnown(animal)){
        resultStack.push(animal);
        continue;
      }
      
      if(!resultStack.isEmpty()){
            //if the last animal on the stack eats the current animal
            if(isAnimalKnown(resultStack.peek())
                    && isSecondEdibibleByFirst(resultStack.peek(), animal)){
                result.add(resultStack.peek() + " eats " + animal);
                continue;
              }
          
            //if the current animal eats the last animal on the stack
            else if(isSecondEdibibleByFirst(animal, resultStack.peek())){
                
                //if there is more edible animals to the left, eat them all
                while(!resultStack.isEmpty()
                          && isSecondEdibibleByFirst(animal, resultStack.peek())){
                    result.add(animal + " eats " + resultStack.peek());
                    resultStack.pop();
                }
          
                //after eating all to the left check if the last animal on the stack eats the current animal
                if(!resultStack.isEmpty()
                          && isAnimalKnown(resultStack.peek()) 
                          && isSecondEdibibleByFirst(resultStack.peek(), animal)){
                    result.add(resultStack.peek() + " eats " + animal);
                    continue;
                }
                
                //if all from above "else if" is false that means the animal is unknown
                resultStack.push(animal);
                
            } // end else if
            
            // animal is unknown
            else resultStack.push(animal);
            
        } // END if(!resultStack.isEmpty())
      
      else resultStack.push(animal);
    
    } // end for loop
    
    StringBuilder remainingAnimals = new StringBuilder();
    resultStack.stream().forEach(x -> remainingAnimals.append(x + ","));
    remainingAnimals.setLength(remainingAnimals.length()-1);
    result.add(remainingAnimals.toString());
    
    return  result.toArray(new String[0]);
  }
  
  public static boolean isAnimalKnown(String animal){
    return eatingRules.containsKey(animal);
  }
  
  public static boolean isSecondEdibibleByFirst(String A, String B){
    return eatingRules.get(A).contains(B);
  }

}
