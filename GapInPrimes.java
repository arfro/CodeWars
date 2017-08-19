import java.util.*;

class GapInPrimes {
    
    public static long[] gap(int g, long m, long n) {
        
        List<Long> buildResult = new ArrayList<>();
        
        outer : for(long i = m; i <= n; i++){
             inner : for(long j = 2; j < i; j++){
                        if(i%j == 0){
                            continue outer;
                          }
                      }
                // add each prime nr to a list. If a list is larger than 1 compare two last elements
                // if their difference is equal to required gap, return them
                // else return null
                buildResult.add(i);
                if(buildResult.size() > 1)
                  if(buildResult.get(buildResult.size()-1)-buildResult.get(buildResult.size()-2) == g)
                    return new long[] {buildResult.get(buildResult.size()-2), buildResult.get(buildResult.size()-1)};
              }
        return null;
    }
}
