public class SoundexAlgoritm {

  public static String soundex(final String names) {
  
  StringBuilder result = new StringBuilder();
  String[] namesChar = names.split(" ");
  
  //words separated by " ". Loop through each word and append each separate result to StringBuilder
    for(int i = 0; i < namesChar.length; i++){
      String wordResult = generateCode(namesChar[i]);
      result.append(wordResult);
      if(i != namesChar.length-1) result.append(" ");
    }
    
    return result.toString();
  
  }
  
  public static String generateCode(String inputString){
  
    //Step 1 - convert to upper case + remove all W or H apart from the first digit
    inputString = inputString.toUpperCase();
    inputString = inputString.substring(0,1) + inputString.substring(1).replaceAll("[WH]", "");
    
    
    
    //step 2 - convert to char array and replace letters as instructed
    char[] inputArr = inputString.toCharArray();    
    char firstLetter = inputArr[0];

    for (int i = 0; i < inputArr.length; i++) {
            switch (inputArr[i]) {
              case 'B':
              case 'F':
              case 'P':
              case 'V': {
                  inputArr[i] = '1';
                  break;
              }
 
              case 'C':
              case 'G':
              case 'J':
              case 'K':
              case 'Q':
              case 'S':
              case 'X':
              case 'Z': {
                  inputArr[i] = '2';
                  break;
              }
 
              case 'D':
              case 'T': {
                  inputArr[i] = '3';
                  break;
              }
   
              case 'L': {
                  inputArr[i] = '4';
                  break;
              }
   
              case 'M':
              case 'N': {
                  inputArr[i] = '5';
                  break;
              }
 
              case 'R': {
                  inputArr[i] = '6';
                  break;
              }
              default: {
                  break;
              }
          }//end switch
          
    }// end for loop
  
  
  //step 3 - replace adjacent digits with one digit 
  String output = replaceAdj(new String(inputArr));
  
  //step 4 - remove all vowels except the first letter
  output = output.substring(0,1) + output.substring(1).replaceAll("[AEIOUY]", "");
  //step 5 - if first symbol is a digit replace it with the first letter
  if(output.substring(0,1).matches("[0-9]")){
    output = firstLetter + output.substring(1);
  }
  
  //step 5 - pad with zeros
  output += "000";

  return output.substring(0, 4);
  
}

// method removing adjacent digits. e.g. 6566677992 -> 656792
  public static String replaceAdj(String inputString){
    StringBuilder result = new StringBuilder();
    
    for(int i = 0; i < inputString.length()-1; i++){
      if(inputString.charAt(i) != inputString.charAt(i+1)){
        result.append(inputString.charAt(i));
      }
    }
    
    result.append(inputString.charAt(inputString.length()-1));
    
    return result.toString();
  
  }



}
