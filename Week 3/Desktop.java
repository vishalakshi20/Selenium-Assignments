package week3.day1;

/*Assignment 1:
     Interface :HardWare
     Methods   :hardwareResources()

     Interface :Software
     Methods   :softwareResources()

     Class     :Desktop
     Methods   :desktopModel()

Description:
create 2 Interface and archieve multiple inheritance.*/

public class Desktop implements HardWare, Software{
	
	public void softwareResources() {
		System.out.println("Microsoft Office");
		
		
	}

	public void hardwareResources() {
		System.out.println("Printer");
		
		
	}
	public void desktopModel() {
		
		System.out.println("HP");
}
	
	public static void main(String[] args) {
		
		Desktop resources = new Desktop();
		resources.softwareResources();
		resources.hardwareResources();
		resources.desktopModel();
		
	}

	

}
