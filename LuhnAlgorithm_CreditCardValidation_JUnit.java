import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LuhnAlgorithm_CreditCardValidation_JUnit{
  @Test
  public void test891(){
    assertEquals(false, Validate.validate("891"));
  }
   @Test
  public void test0000(){
    assertEquals(true, Validate.validate("0000"));
  }
   @Test
  public void test2626262626262626(){
    assertEquals(true, Validate.validate("2626262626262626"));
  }
  @Test
  public void testEmpty(){
    assertEquals(false, Validate.validate(""));
  }
  
}
