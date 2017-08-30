import static org.junit.Assert.*;
import org.junit.Test;

public class BraceChecker_JUnit {

  private BraceChecker checker = new BraceChecker();

	@Test
	public void BraceChecker_isValid_AllOpening() {
    assertEquals(false, checker.isValid("(((((((("));
	}
  
  @Test
	public void BraceChecker_isValid_AllClosing() {
    assertEquals(false, checker.isValid(")))))"));
	}}
  
  @Test
	public void BraceChecker_isValid_Zipped() {
    assertEquals(false, checker.isValid("(])]"));
	}}
  
  @Test
	public void BraceChecker_isValid_Correct() {
    assertEquals(true, checker.isValid("{([[[]]])}"));
	}}
  
  @Test
	public void BraceChecker_isValid_Single() {
    assertEquals(false, checker.isValid("{"));
	}}
  
   @Test
	public void BraceChecker_isValid_SingleClosing() {
    assertEquals(false, checker.isValid(")"));
	}}

}
