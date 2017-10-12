import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.util.*;

public class WhoEatsWho_JUnit {

@Test
  public void example() {    
    final String input = "fox,bug,chicken,grass,sheep";
    final String[] expected = 	{
      "fox,bug,chicken,grass,sheep", 
      "chicken eats bug", 
      "fox eats chicken", 
      "sheep eats grass", 
      "fox eats sheep", 
      "fox"};
    assertArrayEquals(expected, WhoEatsWho.whoEatsWho(input));
  }

  @Test
  public void eatLeftSingle() {  
    final String input = "chicken,fox,leaves,bug,grass,sheep";
    final String[] expected = 	{
      "chicken,fox,leaves,bug,grass,sheep", 
      "fox eats chicken", 
      "bug eats leaves", 
      "sheep eats grass", 
      "fox,bug,sheep"};
    assertArrayEquals(expected, WhoEatsWho.whoEatsWho(input));
  }

  @Test
  public void eatRightSingle() {  
    final String input = "bear,big-fish,lion,cow,bug,leaves";
    final String[] expected = 	{
      "bear,big-fish,lion,cow,bug,leaves", 
      "bear eats big-fish", 
      "lion eats cow", 
      "bug eats leaves", 
      "bear,lion,bug"};
    assertArrayEquals(expected, WhoEatsWho.whoEatsWho(input));
  }

  @Test
  public void eatLeftMulti() {  
    final String input = "grass,grass,cow,leaves,bug,big-fish,leaves,bear";
    final String[] expected = 	{
      "grass,grass,cow,leaves,bug,big-fish,leaves,bear", 
      "cow eats grass",
      "cow eats grass",
      "bug eats leaves", 
      "bear eats leaves", 
      "bear eats big-fish", 
      "bear eats bug",
      "bear eats cow", 
      "bear"};
    assertArrayEquals(expected, WhoEatsWho.whoEatsWho(input));
  }

  @Test
  public void eatRightMulti() {  
    final String input = "giraffe,leaves,leaves,leaves,bear,bug,leaves,leaves,panda";
    final String[] expected = 	{
      "giraffe,leaves,leaves,leaves,bear,bug,leaves,leaves,panda", 
      "giraffe eats leaves",
      "giraffe eats leaves",
      "giraffe eats leaves",
      "bear eats bug", 
      "bear eats leaves", 
      "bear eats leaves", 
      "giraffe,bear,panda"};
    assertArrayEquals(expected, WhoEatsWho.whoEatsWho(input));
  }
  
  @Test
  public void eatLeftAndRightMulti() {  
    final String input = "bear,grass,grass,grass,grass,sheep,bug,chicken,little-fish,little-fish,little-fish,little-fish,big-fish,big-fish,big-fish";
    final String[] expected = 	{
      "bear,grass,grass,grass,grass,sheep,bug,chicken,little-fish,little-fish,little-fish,little-fish,big-fish,big-fish,big-fish", 
      "sheep eats grass",
      "sheep eats grass",
      "sheep eats grass",
      "sheep eats grass",
      "bear eats sheep",
      "bear eats bug",
      "bear eats chicken",
      "big-fish eats little-fish",
      "big-fish eats little-fish",
      "big-fish eats little-fish",
      "big-fish eats little-fish",
      "bear eats big-fish",
      "bear eats big-fish",
      "bear eats big-fish",
      "bear"};
    assertArrayEquals(expected, WhoEatsWho.whoEatsWho(input));
  }

  @Test
  public void nobodyEatsAnything() {    
    final String input = "fox,grass,chicken,lion,panda";
    final String[] expected = {
      "fox,grass,chicken,lion,panda", 
      "fox,grass,chicken,lion,panda"
    };
    assertArrayEquals(expected, WhoEatsWhoa.whoEatsWho(input));
  }
  
  @Test
  public void emptyZoo() {    
    final String input = "";
    final String[] expected = {
      "", 
      ""
    };
    assertArrayEquals(expected, WhoEatsWho.whoEatsWho(input));
  }
  
  @Test
  public void singleKnownThing() {    
    final String input = "bug";
    final String[] expected = {
      "bug", 
      "bug"
    };
    assertArrayEquals(expected, WhoEatsWho.whoEatsWho(input));
  }  

  @Test
  public void singleUnknownThing() {    
    final String input = "wtf";
    final String[] expected = {
      "wtf", 
      "wtf"
    };
    assertArrayEquals(expected, WhoEatsWho.whoEatsWho(input));
  }  
  
  @Test
  public void knownAndUnknownThings() {    
    final String input = "fox,chicken,tree,chicken,bug,banana,bug,bear";
    final String[] expected = {
      "fox,chicken,tree,chicken,bug,banana,bug,bear", 
      "fox eats chicken",
      "chicken eats bug",
      "bear eats bug",
      "fox,tree,chicken,banana,bear"
    };
    assertArrayEquals(expected, WhoEatsWho.whoEatsWho(input));
  }  



}
