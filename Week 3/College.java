package week3.day1;

/*Assignment 2:
    AbstractClass     :University
    Methods              : pg()(implemented method), ug() (unimplemented method)

    Class        :College extends University
    Methods   :ug()

Description:
ug() is just a templete in University Abstract class and You have to implement the method ug() in College class.
Execute both ug() & pg()*/

public class College extends University{
	
	public void ug() {
		System.out.println("Unimplemented");
	}


	public static void main(String[] args) {
		College unimplemented = new College();
		unimplemented.ug();
		unimplemented.pg();

	}

}
