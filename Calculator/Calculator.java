/*
Create a simple calculator that given a string of operators (+ - * and /) and numbers separated by spaces returns the value of that expression

Example:

Calculator.evaluate("2 / 2 + 3 * 4 - 6") // => 7

Remember about the order of operations! Multiplications and divisions have a higher priority and should be performed left-to-right. Additions and subtractions have a lower priority and should also be performed left-to-right.

*/

import java.util.Stack;

public class Calculator {
  public static Double evaluate(String expression) {
    String operatorsList = "/*+-";
    
    String[] expressionArray = expression.split(" ");
    
    Stack<Double> values = new Stack();
    Stack<String> operators = new Stack();
    
    //divide each element from expressionArray onto two stacks:
    for(String s : expressionArray){
      // if its an operator push onto operator stack
      if(operatorsList.contains(s)){
        operators.push(s);
      }
      else{
        Double current = Double.parseDouble(s);
        
        // if there is more operators and the last operator is multiplication we need to evaluate the last two numbers (priority)
        if(!operators.isEmpty() && operators.peek().equals("*")){
          Double newVal = values.pop() * current;
          values.push(newVal);
          operators.pop();
        }
        
        // else if there is more operators and the last operator is division we need to evaluate the last two numbers (priority)
        else if(!operators.isEmpty() && operators.peek().equals("/")){
          Double newVal = values.pop() / current;
          values.push(newVal);
          operators.pop();
        }
        
        // else if there is more operators and the last operator is subtraction we need to evaluate the last two numbers (important to maintain operation order. e.g. 4 - 4 + 1 != 4 - ( 4 + 1))
        else if(!operators.isEmpty() && operators.peek().equals("-")){
          Double newVal = values.pop() - current;
          values.push(newVal);
          operators.pop();
        }
        
        // else just push values onto values stack to be added at the end
        else values.push(current);
        
      }
    }
    
    while(!operators.isEmpty()){
      //add up remaining values - the final evaluated number will be to be popped on return
      String currentOperation = operators.pop();
      if(currentOperation.equals("+")){
        Double top = values.pop();
        Double newVal = values.pop() + top;
        values.push(newVal);
      }
      //if operation other than + left - return -1.0
      else return -1.0;
    }
    
    //rounding up for floats
    return Math.round( values.pop() * 1000.0 ) / 1000.0;
  }
}
