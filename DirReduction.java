public class DirReduction {
    
    public static String[] dirReduc(String[] arr) {
        
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
