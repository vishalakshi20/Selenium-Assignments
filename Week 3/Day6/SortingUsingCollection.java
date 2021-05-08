package week3.day2;

import java.util.ArrayList;
import java.util.Collections;

public class SortingUsingCollection {

	public static void main(String[] args) {
		
//		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
		
//		Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)		

//		get the length of the array		

//		sort the array			

//		Iterate it in the reverse order

//		print the array
		
//		Required Output: Wipro, HCL , CTS, Aspire Systems


		 ArrayList<String> company = new ArrayList<String>();
		 company.add("HCL");
		 company.add("Wipro");
		 company.add("Aspire Systems");
		 company.add("CTS");
		 					
		Collections.sort(company, Collections.reverseOrder());
		 System.out.println("List of the companies in reverse order :\n" + company);
		
	}

}
