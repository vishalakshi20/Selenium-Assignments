package week1.day1;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 Pseudo Code
		 
		 * Declare String Input as Follow
		  
		 * String test = "changeme";
		 
		 * a) Convert the String to character array - 0-c,1-h,2-a,3-n,4-g,5-e,6-m,7-e
		 
		 * b) Traverse through each character (using loop)
		 
		 * c)find the odd index within the loop (use mod operator)
		 
		 * d)within the loop, change the character to uppercase, if the index is odd else don't change
		  
		 */
		
		String test = "changeme";
		boolean name=false;
		char[] charArray = test.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			
			if (i%2 !=0) {
				String Upper = test.toUpperCase();
				System.out.println(Upper.charAt(i));
			}
				else if (i%2 == 0) {
					String lower = test.toLowerCase();
					System.out.println(lower.charAt(i));
				}
													}
			if(!name) {
				System.out.println(test);
			}
					}
		

	

}
