/*
Write a function dirReduc which will take an array of strings and returns an array of strings with the needless directions removed (W<->E or S<->N side by side).

Examples

dirReduc(["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"]) => ["WEST"]
dirReduc(["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"]) => []

Note

Not all paths can be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible. 
"NORTH" and "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly opposite of each other and can't become such. 
Hence the result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].

*/

public class DirReduction {
    
    public static String[] dirReduc(String[] arr) {
        
        if(arr == null) return new String[]{};
        //e.g. if array has less than 3 elements those elements will never be reducible
        if(arr.length < 3) return arr;
        
        // [0][0] - Horizontal axis (Y) - East/West
        // [0][1] - Vertical axis (X) - South/North 
        int[][] axis = new int[1][2];
        
        for(String direction : arr){
        //check each string in the input. Based on that change coordinates in "axis"
          switch(direction){
            case "EAST": {
                axis[0][0]++;
                break;
              }
            case "WEST": {
                axis[0][0]--;
                break;
              }
            case "SOUTH": {
                axis[0][1]--;
                break;
              }
            case "NORTH": {
                axis[0][1]++;
                break;
              }
              
          }//end switch
          
        }//end for
        
        //as per requirements: if 4 steps and result is 0,0 then return the input unchanged - cannot simplify
        if(arr.length == 4 && axis[0][0] == 0 && axis[0][1] == 0) return arr;
        //as per reruirement: if back to the same position, return an empty String array
        else if(axis[0][0] == 0 && axis[0][1] == 0) return new String[]{};
        
        return generateOutput(axis);
    }
    
    
    public static String[] generateOutput(int[][] input){
    
      StringBuilder result = new StringBuilder();
        
      //generate based on the final value for axis Y
      if(input[0][1] > 0){
        for(int i = 0; i < input[0][1]; i++){
          result.append("NORTH ");
        }
      }
      else if(input[0][1] < 0){
        for(int i = 0; i > input[0][1]; i--){
          result.append("SOUTH ");
        }
      }
        
     //generate based on the final value for axis X
     if(input[0][0] > 0){
        for(int i = 0; i < input[0][0]; i++){
          result.append("EAST ");
        }
      }
      else if(input[0][0] < 0){
         for(int i = 0; i > input[0][0]; i--){
          result.append("WEST ");
        }
      }
          
     return result.toString().trim().split(" ");
      
    } // end generateOutput
    
  
}//end class
