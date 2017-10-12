import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class EnigmaMachine_Plugboard_JUnit {
    @Test
    public void testValidPlugboard() throws InvalidPlugboardWiresException {
        EnigmaMachine_Plugboard plugboard = new EnigmaMachine_Plugboard("AB");
        assertEquals("B", plugboard.process("A"));
        assertEquals("A", plugboard.process("B"));
        assertEquals("C", plugboard.process("C"));
        assertEquals(".", plugboard.process("."));
    }

    @Test(expected = InvalidPlugboardWiresException.class)
    public void testInvalidPlugboard1() throws InvalidPlugboardWiresException {
        EnigmaMachine_Plugboard plugboard = new EnigmaMachine_Plugboard("ABC");
    }

    @Test(expected = InvalidPlugboardWiresException.class)
    public void testInvalidPlugboard2() throws InvalidPlugboardWiresException {
        EnigmaMachine_Plugboard plugboard = new EnigmaMachine_Plugboard("ABAD");
    }

    @Test(expected = InvalidPlugboardWiresException.class)
    public void testInvalidPlugboard3() throws InvalidPlugboardWiresException {
        EnigmaMachine_Plugboard plugboard = new EnigmaMachine_Plugboard("ABCDEFGHIJKLMNOPQRSTUV");
    }
}
