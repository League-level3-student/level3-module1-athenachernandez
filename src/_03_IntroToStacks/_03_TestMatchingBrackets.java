package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String brackets) {
		
		Stack<String> stack = new Stack<String>();
		
		//1. Use a for loop to iterate through your brackets String 
		for (int i = 0; i < brackets.length(); i++) {
    			//2.  If the current character is an '{'
			if (brackets.charAt(i) == '{') {
        			//3.  Push an '{' onto the stack 
				stack.push("{");
				//4.  else if the character is a '}'
			} else if (brackets.charAt(i) == '}') {
				//6.  if the stack is empty (i.e. there is no matching opening bracket)
				if (stack.size() == 0) {
					//7.  return false 
					return false;
				}
				stack.pop();
			}
			
			
        			//5.  Pop a character from the stack

		}
		//8.  if the stack is not empty (i.e. there were too many opening brackets)
		if (stack.size() > 0) {
			return false;
		} else {
			return true;
		}
    			//9. return false 

		//10. else (i.e. everything matched correctly)

    			//11. return true 
		
	}

}
