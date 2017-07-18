import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class MorseCodeDecoder_JUnit {
    @Test
    public void testExampleFromDescription() {
      assertThat(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."), is("HEY JUDE"));
      assertThat(MorseCodeDecoder.decode(".... ."), is("HE"));
      assertThat(MorseCodeDecoder.decode("....   .   -.--"), is("H E Y"));
    }
}
