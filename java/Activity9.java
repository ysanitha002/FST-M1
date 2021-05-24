package activities;

import java.util.ArrayList;

public class Activity9 {
	
	public static void main ( String[] args )
	{		
		ArrayList<String> mylist = new ArrayList<String>();
		
		mylist.add("Apple");
		mylist.add("Orange");
		mylist.add("Mango");
		
		mylist.add(1, "Grapes");
		mylist.add(3,"Kiwi");
		
		System.out.println("Objects in myList:");
		
		for (String s:mylist) {	
			System.out.println(s);		
		}
		
		 System.out.println("3rd element in the list is: " + mylist.get(2));
		// System.out.println("element in the list is: " + mylist.get("Orange")));
	     System.out.println("Is Chicku is in list: " + mylist.contains("Chicku"));
	     System.out.println("Size of ArrayList: " + mylist.size());
	     
	     mylist.remove("Grapes");
	     System.out.println("Size of ArrayList: " + mylist.size());
	     
	     mylist.remove(1);
	     
	     System.out.println("Size of ArrayList with their items below :  " + mylist.size());
	 	  for (String s:mylist) {	
			System.out.println(s);		
		  }
	
	}
}
