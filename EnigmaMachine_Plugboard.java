/*
The Enigma Machine was a message enciphering/deciphering machine used during the Second World War for disguising the content of military communications. Alan Turing - the father of computing - formulated and developed concepts that are the basis of all computers in use today, he did this in response to the vital need to break those military communications. Turing and his colleagues at Bletchley Park are generally recognised as being responsible for shortening WWII by two years and saving an estimated 22 Million lives.

The Enigma Machine consisted of a number of parts: Keyboard for input, rotors and plugboard for enciphering, and lampboard for output.

This class implements - PLUGBOARD 

Physical Description

The plugboard crosswired the 26 letters of the latin alphabet togther, so that an input into one letter could generate output as another letter. If a wire was not present, then the input letter was unchanged. Each plugboard came with a maximum of 10 wires, so at least six letters were not cross-wired.

For example:

If a wire connects A to B, then an A input will generate a B output and a B input will generate an A output.
If no wire connects to C, then only a C input will generate a C output.
Note

In the actual usage of the original Enigma Machine, punctuation was encoded as words transmitted in the stream, in our code, anything that is not in the range A-Z will be returned unchanged.

Take a list of wire pairs at construction in the form of a string, with a default behaviour of no wires configured. E.g. "ABCD" would wire A <-> B and C <-> D.
Validate that the wire pairings are legitimate. Raise an exception if not.
Implement the process method to translate a single character input into an output.

*/

import java.util.HashMap;
import java.util.Map;

public class EnigmaMachine_Plugboard {
    
    //instance variable holding the wired alphabet
    HashMap<String, String> wiredAlphabet = new HashMap<>();

    public EnigmaMachine_Plugboard(String wires) throws InvalidPlugboardWiresException {
        
        //edge case check
        if(wires.length()%2 != 0 || wires.length()>20){
          throw new InvalidPlugboardWiresException();
        }
        
        // based on an argument passed to the class contructor create a map containing all wired mappings
        for(int i=0; i < wires.length(); i+=2){
          if (wiredAlphabet.containsKey(wires.substring(i,i+1)) || wiredAlphabet.containsKey(wires.substring(i+1,i+2))){
            throw new InvalidPlugboardWiresException();
          }
          wiredAlphabet.put(wires.substring(i,i+1), wires.substring(i+1, i+2));
          wiredAlphabet.put(wires.substring(i+1,i+2), wires.substring(i, i+1));
        }        
    }

    public String process(String wire) {
        StringBuilder result = new StringBuilder();
       
        for(int i = 0; i < wire.length(); i++){
         String value = wire.substring(i,i+1);
         //if a given character exists a given letter append it's value to the result
         if(wiredAlphabet.containsKey(value)) result.append(wiredAlphabet.get(value));
         //if a given character doesnt exist, append to result
         else result.append(wire.substring(i,i+1));
        }
        
        return result.toString();
    }
}
