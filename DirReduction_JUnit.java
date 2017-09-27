import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class DirReductionTest {
  @Test
  public void DirReduction_dirReduction_ReduceToOneDirectionOnly() throws Exception {
    assertEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
        new String[]{"WEST"},
        DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
  }
  
  @Test
  public void DirReduction_dirReduction_FourDirectionsThatLeadBackToStartingPoint() throws Exception{
     assertEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"",
        new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
        DirReduction.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
  }
  
  @Test
  public void DirReduction_dirReduction_MoreThanFourDirectionsTHatLeadToStartingPoint() throws Exception{
     assertEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\", \"NORTH\", \"EAST\", \"SOUTH\", \"WEST\"  ",
        new String[]{},
        DirReduction.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST", "NORTH", "EAST", "SOUTH", "WEST"}));
  }
  
  @Test
  public void DirReduction_dirReduction_PassEmptyInput() throws Exception{
     assertEquals("empty string",
        new String[]{},
        DirReduction.dirReduc(new String[]{}));
  }
  
   @Test
  public void DirReduction_dirReduction_PassNullInput() throws Exception{
     assertEquals("empty string",
        new String[]{},
        DirReduction.dirReduc(null));
  }
}
