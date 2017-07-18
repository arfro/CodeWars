import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GetMiddleChar_JUnit {
  @Test
  public void evenTests() {
    assertEquals("es", GetMiddleChar.getMiddle("test"));
    assertEquals("dd", GetMiddleChar.getMiddle("middle"));
  }
  
  @Test
  public void oddTests() {
    assertEquals("t", GetMiddleChar.getMiddle("testing"));
    assertEquals("A", GetMiddleChar.getMiddle("A"));
  }
  
  @Test
  public void edgeCases() {
    assertEquals("", GetMiddleChar.getMiddle("testing"));
  }
}
