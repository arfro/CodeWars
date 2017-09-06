import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AntBridge_JUnit {

  @Test
  public void AntBridge_antBridge_noGaps() {
    assertEquals("GFEDCBA", AntBridge.antBridge("GFEDCBA", "-----------------------"));
  }
  
  @Test
  public void AntBridge_antBridge_OneGapThreeDots() {
    assertEquals("EDCBAGF", AntBridge.antBridge("GFEDCBA", "------------...-----------"));
  }
  
  @Test
  public void AntBridge_antBridge_LastCharacterIsASingleDash() {
    assertEquals("EDCBAGF", AntBridge.antBridge("GFEDCBA", "------------...-"));
  }
  
  @Test
  public void AntBridge_antBridge_OneDashOneGapPattern() {
    assertEquals("BCDA", AntBridge.antBridge("ABCD", "-.-.-.-"));
  }
  
}
