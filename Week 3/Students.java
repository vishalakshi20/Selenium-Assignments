package week3.day1;

/*Assignment4:
==============

      Class: Students
      Methods: getStudentInfo()

Description: 
Create multiple getStudentInfo() method by passing id argument alone, by id & name, by email & phoneNumber*/

public class Students {
	
	public void getStudentInfo(int id) {
		
		System.out.println("Student id :" +id);
	}
	public void getStudentInfo(int id,String name) {
		
		System.out.println("Student id :" +id + " name :"  +name);
	}
	public void getStudentInfo(String email,long phoneNumber) {
		
		System.out.println("Student email : " +email + " and " + "Phone Number :" + phoneNumber);
	}
	public static void main(String[] args) {
		
		Students info = new Students();
		info.getStudentInfo(25);
		info.getStudentInfo(25, "Vishali");
		info.getStudentInfo("yhf@gmail.com",9940673633L);
		
		

	}

}
