package activities;

import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("Apple");
		hs.add("Lichi");
		hs.add("StarFruit");
		hs.add("Passion");
		hs.add("Kiwi");
		hs.add("Guava");
		
		System.out.println("Size of HashSet: " + hs.size());
		System.out.println("Original HashSet: " + hs);
				
		System.out.println("Removing A from HashSet: " + hs.remove("Lichi"));
		
		if(hs.remove("Pear")) {
        	System.out.println("Pear removed from the Set");
        } else {
        	System.out.println("Pear is not present in the Set");
        }
		
		 System.out.println("Checking if StarFuit is present: " + hs.contains("StarFruit"));
		 
		 System.out.println("Checking if Lichi is present: " + hs.contains("Lichi"));
	        //Print updated HashSet
	     System.out.println("Updated HashSet: " + hs);
		
	}

}
