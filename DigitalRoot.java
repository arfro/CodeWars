/*

Create a digital root function.

A digital root is the recursive sum of all the digits in a number. Given n, take the sum of the digits of n. If that value has two digits, continue reducing in this way until a single-digit number is produced. This is only applicable to the natural numbers.

Here's how it works:

digital_root(16)
=> 1 + 6
=> 7

digital_root(942)
=> 9 + 4 + 2
=> 15 ...
=> 1 + 5
=> 6


*/

public class DigitalRoot {
  public static int digital_root(int n) {
    
    if(n/10 == 0) return n%10;
    
    int lastDigit = n%10;
    int remaindingDigits = n/10;
    
    return digital_root(lastDigit+digital_root(remaindingDigits));
    
  }
}
