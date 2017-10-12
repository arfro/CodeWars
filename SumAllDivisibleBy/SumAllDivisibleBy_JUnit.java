import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SumAllDivisibleBy_JUnit {
    @Test
    public void SumAllDivisibleBy_solution_normalCase() {
      assertEquals(23, new Solution().solution(10));
    }
    
    @Test
    public void SumAllDivisibleBy_solution_Zero(){
      assertEquals(0, new Solution().solution(0));
    }
    
    @Test
    public void SumAllDivisibleBy_solution_Negative(){
      assertEquals(0, new Solution().solution(-1));
    }
    
}
