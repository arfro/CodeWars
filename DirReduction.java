public class DirReduction {
    
    public static String[] dirReduc(String[] arr) {
        
        // [0][0] - EW
        // [0][1] - NS
        int[][] axis = new int[1][2];
        
        for(String direction : arr){
        
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
        
        if(arr.length == 4 && axis[0][0] == 0 && axis[0][1] == 0) return arr;
        else if(axis[0][0] == 0 && axis[0][1] == 0) return new String[]{};
        
        return generateOutput(axis);
    }
    
    
    public static String[] generateOutput(int[][] input){
    
      StringBuilder result = new StringBuilder();

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
    
  
}
