import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DigitalRoot_JUnit {
    @Test
    public void Tests() {
      assertEquals( 7, DRoot.digital_root(16));
      assertEquals( 6, DRoot.digital_root(6666));
      assertEquals( 4, DRoot.digital_root(12100));
    }
}
