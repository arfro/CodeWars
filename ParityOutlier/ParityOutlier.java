public class ParityOutlier{

  static int find(int[] integers){

    int counterOdd = 0;
    int lastOdd = 0;
    int counterEven = 0;
    int lastEven = 0;

    for(int i = 0; i < integers.length; i++){
      if(integers[i] % 2 == 0){
          counterEven++;
          lastEven = integers[i];
        }
      else{
          counterOdd++;
          lastOdd = integers[i];
        }
    }

    if (counterOdd == 1) return lastOdd;
    else return lastEven;

   }

}
