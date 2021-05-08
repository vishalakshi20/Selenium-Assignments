package week3.day2;

import java.util.HashMap;
import java.util.Map;

public class Mapoccurance {

	public static void main(String[] args) {
		
		/*PseudoCode:
			1. Create a String with your name as value
			2. Convert the string into a char array		
			3. Create an empty Map<Character,Integer>
			4. Iterate over the array
			5. Check whether the Map contains the Character
			6. If it contains then increment the key (+1)
			7. Add the character in the map & set the value as 1
			8. Print the Map	*/
			
		String text = "welcome to Selenium automation";
		char[] charArray = text.toCharArray();
		Map<Character,Integer> map= new HashMap <Character,Integer>();
		
		for (char c :charArray) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else
			{
				map.put(c,1);
			}
					
		}
		System.out.println(map);
		}	
	}



