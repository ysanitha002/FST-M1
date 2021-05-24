package activities;


/*  Create an abstract class Book that has:
title of type String
an abstract method setTitle() that takes one String argument.
a concrete method getTitle() that returns the value of title.
Create another class that extends the abstract class called MyBook.
MyBook defines the setTitle() method to assign the value of title as the argument.
In the main method, create an object of MyBook class - newNovel.
Use the setTitle() method to book title to the variable title.
Use the getTitle() method to print the name of the book
 */


public class Activity5 {

	public static void main(String[] args) {
	 
		MyBook newNovel= new MyBook();	
		String title ="Java Programs Activity5";	
		newNovel.setTitle(title);	
		System.out.println("Book Title :"+newNovel.getTitle());

	}

}
