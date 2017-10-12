/*

Implement a function reverse_list which takes a singly-linked list of nodes and returns a matching list in the reverse order.

Assume the presense of a class Node, which exposes the property next. next must either be set to the next Node in the list, or to None (or null) to indicate the end of the list.

*/

import java.util.Stack;
import java.util.LinkedList;

public class RevertLinkedListOnStack {
  public static Node reverse(Node node) {   
      
    if(node == null){
      return new Node();
    } 
      
    Stack stack = new Stack();
    LinkedList result = new LinkedList();
    
    while(node != null){
      stack.push(node);
      node = node.next;
    }
      
    while(!stack.isEmpty()){
      node = (Node)stack.pop();
      if(stack.isEmpty()) node.next = null;
      else node.next = (Node)stack.peek();
      result.add(node);
    }
    
    
    return (Node)result.getFirst();
  }
}
