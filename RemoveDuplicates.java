package week1.day1;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Pseudo code 
		 
		 * a) Use the declared String text as input
			String text = "We learn java basics as part of java sessions in java week1";		
		 * b) Initialize an integer variable as count	  
		 * c) Split the String into array and iterate over it 
		 * d) Initialize another loop to check whether the word is there in the array
		 * e) if it is available then increase and count by 1. 
		 * f) if the count > 1 then replace the word as "" 
		 
		 * g) Displaying the String without duplicate words	
		 */
				
		
		String test = "We learn java basics as part of java sessions in java week1";
		String[] split = test.split(" ");
				for (int k = 0; k < split.length; k++) {
				for (int i = k+1; i < split.length; i++) {
					if(split[k].equals(split[i])){				
						split[i]="";
							}								
				}
				System.out.print(split[k]+" ");						
			}
			
		}}

