package week1.day1;

import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 123, n, sum = 0;
		System.out.println("Number: " +num);
		while(num>0)
	{
		n = num %10;
		sum = sum + n;
		num = num/10;
	}
		
	System.out.println("The sum of digits 1+2+3 :" +sum);	

	}

}
