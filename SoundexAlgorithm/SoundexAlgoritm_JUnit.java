import org.junit.Test;
import static org.junit.Assert.*;

public class SoundexAlgoritm_Junit {

  @Test
  public void arnie() {
    assertEquals("S600 C560", SoundexAlgoritm.soundex("Sarah Connor"));
    assertEquals("S600 C560", SoundexAlgoritm.soundex("Sara Conar"));
    assertEquals("S600 C560", SoundexAlgoritm.soundex("Serah Coner"));
    assertEquals("S600 C560", SoundexAlgoritm.soundex("Sarh Connor"));
    assertEquals("S600 C560", SoundexAlgoritm.soundex("Sayra Cunnarr"));
  }

}
