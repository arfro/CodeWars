/*

Implement a function decodeMorse(morseCode), that would take the morse code as input and return a decoded human-readable string.

For example:

MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. .")
//should return "HEY JUDE"

Assume the Morse code table is preloaded for you as a dictionary. Usage: MorseCode.get('.--')

*/


public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        
        StringBuilder result = new StringBuilder();
        
        //Split string using triple space as a delimiter (indicates a new word)
        String[] words = morseCode.split("   ");
        
        
        for(int i=0; i < words.length; i++){
          //split each word into letters using single space as a delimiter (indicates a letter)
          String[] letters = words[i].split(" ");
          //append each extracted letter to a StringBuilder
          for(String letter : letters){
            result.append(MorseCode.get(letter));
          }
          //append a space between words unless it's a last word
          if(i < words.length-1) result.append(" ");
        }
        
        return new String(result);
        
    }
}
