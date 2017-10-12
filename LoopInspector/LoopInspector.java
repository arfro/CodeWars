/*

You are given a node that is the beginning of a linked list. This list always contains a tail and a loop.

Your objective is to determine the length of the loop.

For example in the following picture the tail's size is 3 and the loop size is 11.

o-o-o-o-o-o-o-o
      |       |
      o       o
      -o-o-o-o-

*/

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
