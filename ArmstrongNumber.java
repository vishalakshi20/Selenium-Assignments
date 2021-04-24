package week1.day1;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 153, n, sum = 0;
		System.out.println("Number: " +num);
		while(num>0)
	{
		n = num %10;
		sum = sum +(n*n*n);
		num = num/10;
	}
		
	System.out.println("The number is armstrong" );	
}

}

	


