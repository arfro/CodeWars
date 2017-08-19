class CamelCase{

  static String toCamelCase(String s){
    
    StringBuilder result = new StringBuilder();
    
    //edge case
    if(s.length() == 0) return "";
    
    //split the string into an array of words
    String[] words = s.split("-|_");
    
    for(int i=0; i<words.length; i++){
      //apart from the first word - capitalize first letter of each word and remaning to lower case
      if(i == 0) words[i] = words[i].substring(0, 1) + words[i].substring(1,words[i].length()).toLowerCase();
      else words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1,words[i].length()).toLowerCase();
      result.append(words[i]);
    }
    
    return result.toString();
  }
}
