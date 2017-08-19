import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class CamelCase_JUnit {
    @Test
    public void testSomeUnderscoreLowerStart() {
      String input = "the_Stealth_Warrior";
      System.out.println("input: "+input);      
      assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }
    @Test
    public void testSomeDashLowerStart() {
      String input = "the-Stealth-Warrior";
      System.out.println("input: "+input);      
      assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }
    @Test
    public void testSomeDashLowerStart2() {
      String input = "the-shtelt-Warrior";
      System.out.println("input: "+input);      
      assertEquals("theShteltWarrior", Solution.toCamelCase(input));
    }
    
    @Test
    public void testEmpty() {
      String input = "";
      System.out.println("input: "+input);      
      assertEquals("", Solution.toCamelCase(input));
    }
}
