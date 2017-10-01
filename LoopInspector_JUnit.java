import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LoopInspector_JUnit {

  @Test public void loop_size_of_1() {
    Node list = Node.createChain(0, 1);
    int result = new LoopInspector().loopSize(list);
    assertEquals("Incorrect loop size", 1, result);
  }
  
  @Test public void long_tail_short_loop() {
    Node list = Node.createChain(8778, 23);
    int result = new LoopInspector().loopSize(list);
    assertEquals("Incorrect loop size", 23, result);
  }
  
  @Test public void short_tail_long_loop() {
    Node list = Node.createChain(23, 8778);
    int result = new LoopInspector().loopSize(list);
    assertEquals("Incorrect loop size", 8778, result);
  }
  
  @Test public void random_list() {
    for (int i = 0; i < 2; ++i) {
      Random random = new Random();
      int tail = random.nextInt(1000) + 9000;
      int loop = random.nextInt(1000) + 9000;
      Node list = Node.createChain(tail, loop);
      int result = new LoopInspector().loopSize(list);
      assertEquals("Incorrect loop size", loop, result);
    }
  }
}
