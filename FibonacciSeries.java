package week1.day1;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int range = 8, fnum = 0, snum=1, sum;
		System.out.print(fnum +" "+snum);
		
		for (int i = 2; i < range; ++i) {
			sum = fnum+snum;
			System.out.print(" " +sum);
			fnum = snum;
			snum =sum;
		}	
}	}


