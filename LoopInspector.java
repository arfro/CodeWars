import java.util.Set;
import java.util.HashSet;

public class LoopInspector {
  
  Set<Node> allNodes = new HashSet<>();

  public int loopSize(Node node) {
  
    Node current = node;
    Node firstNodeInLoop;
    int counter = 1;
    
    while(allNodes.add(current)){
      current = current.getNext();
    }
    
    firstNodeInLoop = current;
    
    while(current.getNext() != firstNodeInLoop){
      current = current.getNext();
      counter++;
    }
    
    return counter;
  
  }

}
