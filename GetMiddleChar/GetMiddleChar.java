/*

Return the middle character of the word. If the word's length is odd, return the middle character. If the word's length is even, return the middle 2 characters.

#Examples:

Kata.getMiddle("test") should return "es"

Kata.getMiddle("testing") should return "t"

Kata.getMiddle("middle") should return "dd"

Kata.getMiddle("A") should return "A"

*/

class GetMiddleChar {
  public static String getMiddle(String word) {
    
    StringBuilder result = new StringBuilder();
    
    // edge case scenarios
    if(word.length()>=0 && word.length()<=2) return word;
    
    //if a word has even amount of letters return character at (length-1/)2 and the one next to it
    else if(word.length()%2==0) result.append(word.substring((word.length()-1)/2, ((word.length()-1)/2)+2));
    //if a word has uneven amount of letters return middle character only
    else if(word.length()%2!=0) result.append(word.substring((word.length()-1)/2, ((word.length()-1)/2)+1));
    
    return new String(result);
  }
}
