package week1.day1;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Pseudo Code
		
		 * a) Declare A String value as"madam"
		 
		 * b) Declare another String rev value as ""
		 * c) Iterate over the String in reverse order
		 * d) Add the char into rev
		 * e) Compare the original String with the reversed String, if it is same then print palinDrome 
		 
		 * Hint: Use .equals or .equalsIgnoreCase when you compare a String 
		 */
		
		String name = "madam";
		String rev = "";
		for (int i = name.length()-1; i >=0; --i) {
			 rev = rev + name.charAt(i);
	    }

	    if (name.equals(rev)) {
	      System.out.println(name + " is a Palindrome String.");
	    }
	    else {
	      System.out.println(name + " is not a Palindrome String.");
			}
			
		}
		

	}


