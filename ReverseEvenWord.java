package week1.day1;

public class ReverseEvenWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Pseudo Code:
		 
		 * Declare the input as Follow
	      		String test = "I am a software tester"; 
	      											
		a) split the words and have it in an array
		b) Traverse through each word (using loop)
		c) find the odd index within the loop (use mod operator)
		
		d)split the words and have it in an array
		
		e)print the even position words in reverse order using another loop (nested loop)
		f) Convert words to character array if the position is even else print the word as it is(concatenate space at the end).
		
		 
	*/
		
		String test = "I am a software tester";
		String[] name = test.split("");
		boolean word = false;
		for (int i = name.length-1; i >= 0 ; i--) {
			if (i%2 !=0 ) {
				int ind =test.indexOf(i);
				System.out.println(i);
									 }
			}
		for (int i =name.length-1; i > 0 ; i--) {
			if (i%2 ==0 ) {
				int ind =test.indexOf(i);
				System.out.print(name[i]+" ");				
				word=true;
			}				
				else if (!word){
				char[] charArray = test.toCharArray(); 
				System.out.println(test);
							
			}
			
		}
	}
}
		
	


