package week3.day2;

import java.util.Collections;
import java.util.TreeMap;

public class EmployeeInfo {

	public static void main(String[] args) {
		/*Emp_id|Emp_name
100	Hari
101 Naveen
102	Sam
104	Balaji

OutPut: Print Employee info in reverse order based on Emp_d */
		
		
		TreeMap<Integer,String> employee = new TreeMap<Integer,String>(Collections.reverseOrder());
		
		employee.put(100, "Hari");
		employee.put(101, "Naveen");
		employee.put(102, "Sam");
		employee.put(104, "Balaji");
		
		System.out.println(employee);
	}
	

}
