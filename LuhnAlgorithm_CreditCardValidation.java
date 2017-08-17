import java.util.ArrayList;

public class LuhnAlgorithm_CreditCardValidation{
  public static boolean validate(String n){
    ArrayList<Integer> numArr = new ArrayList<>();
    //"result" variable will be used for the final sum
    int result = 0;
    
    //edge cases
    if(n.length() == 0) return false;
    
    //add each number in the string to an array of integers
    for(int i=0; i < n.length(); i++) numArr.add(Integer.parseInt(n.substring(i, i+1)));
    
    //if there is an even amt of numbers get each second value starting from zero and... 
    if(n.length()%2 == 0){
      for(int i=0; i < numArr.size(); i=i+2){
        //... multiply by 2.
        int currentNr = Integer.valueOf(numArr.get(i)) * 2;
        //if after multiplication the number has two digits, subtract 9...
        if(currentNr > 9) currentNr = currentNr-9;
        //and set as a new value
        numArr.set(i, currentNr);
      }
    }
    //if there is an uneven amt of numbers get each second value starting from one and... 
    else{
      for(int i=1; i < numArr.size(); i=i+2){
       //... multiply by 2.
        int currentNr = Integer.valueOf(numArr.get(i)) * 2;
        //if after multiplication the number has two digits, subtract 9...
        if(currentNr > 9) currentNr = currentNr-9;
        //and set as a new value
        numArr.set(i, currentNr);
        System.out.println(numArr.get(i));
      }
    }
    
    //add all digits from the array
    for(int nr : numArr) result += nr;
    
    if(result%10 == 0) return true;
    else return false;
    
    
  }
}
