package week3.day1;

/*Assignment 1:
Create class Calculator with below methods
- 2 methods for add, 1 method with 2 int args , 1 method with 3 int args
- 2 methods for multiply, 1 method with 2 int args, 1method with 1 int and 1 double args
- 2 methods for subtract, 1 method with 2 int args , 1 method with 2 double args
- 2 methods to divide , 1 method with 2 int args, one to divide one double number with one int
create object for the Calculator class and execute all the methods*/

public class Calculator {
	
public void add(int num1, int num2) {
		
		int num3 = num1 + num2;
		System.out.println( "The sum of num1+num2 : " +num3);
				
	}
public void add (int num, int num1,int num2) {
		
		int num3 = num + num1+num2;
		System.out.println( "The sum of num+num4 : " +num3);
				
	}

public void multiply (int a, int b) {
	
	int c = a*b ;
	System.out.println( "The product is : " +c);
			
}
public void multiply (int d, double e) {
	
	double f = d*e ;
	System.out.println( "The product is : " +f);
			
}
public void subtract (int a, int b) {
	
	int c = a-b ;
	System.out.println( "The difference is : " +c);
			
}

public void subtract (double a, double b) {
	
	double c = a-b ;
	System.out.println( "The difference is : " +c);
			
}

public void divide (int a, int b) {
	
	int c = a/b ;
	System.out.println( "The answer is : " +c);
			
}

public void divide (int a, double b) {
	
	double c = a/b ;
	System.out.println( "The answer is : " +c);
			
}

public static void main(String[] args) {
	
	Calculator value = new Calculator();
	value.add(25, 35);
	value.add(65, 45, 45);
	value.multiply(100, 5);
	value.multiply(75, 2.525);
	value.subtract(896, 584);
	value.subtract(2.548, 5.847);
	value.divide(100, 5);
	value.divide(1500, 5.555);
	
	
}

}
