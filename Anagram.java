package week1.day1;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "stops";
		String text2 = "pots";
		boolean n = true;
		if (text1.length() != text2.length())
		{
				n=false;
		}
		else { 
			char[] chars = text1.toCharArray();
			char[] chars1 = text2.toCharArray();
			
			Arrays.sort(chars);
			Arrays.sort(chars1);	
			 n = chars.equals (chars1);
			}
	
		 if (!n) {
			System.out.println(text1+ " and " +text2+ " are anagrams");
			
		}else
			System.out.println(text1 +" and "+ text2+ " are not anagrams");
			
	}

}
