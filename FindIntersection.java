package week1.day1;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Pseudo Code
		
		 * a) Declare An array for {3,2,11,4,6,7};	 
		 * b) Declare another array for {1,2,8,4,9,7};
		 * c) Declare for loop iterator from 0 to array length
		 * d) Declare a nested for another array from 0 to array length
		 * e) Compare Both the arrays using a condition statement
		 
		 *  f) Print the first array (should match item in both arrays)
		 */
		
		int[] num = {3,2,11,4,6,7};
		int[] num2 = {1,2,8,4,9,7};
		
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num2.length; j++) {
				if (num[i]==num2[j]) {
					System.out.println(num[i]);
					
				}
					
				
			}
			
		}
	}

}
