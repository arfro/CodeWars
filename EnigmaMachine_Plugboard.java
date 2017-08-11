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
