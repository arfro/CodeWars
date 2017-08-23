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
