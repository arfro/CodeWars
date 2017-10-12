import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class SolutionTest {
    @Test
    public void testSingleton() {
        Node node1 = new Node();
        node1.value = 2;
        node1.next = null;
        
        Node newHead = RevertLinkedListOnStack.reverse(node1);
        
       assertEquals(node1.next, null);
    }
    
    @Test
    public void testPositive() {
        Node node1 = new Node();
        node1.value = 2;
        Node node2 = new Node();
        node2.value = 4;
        node1.next = node2;
        Node node3 = new Node();
        node3.value = 6;
        node2.next = node3;
        
        Node newHead = RevertLinkedListOnStack.reverse(node1);
        
        assertEquals(newHead, node3);
        assertEquals(node3.next, node2);
        assertEquals(node2.next, node1);
        assertEquals(node1.next, null);
    }
    
    
}
