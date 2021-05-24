/**
 * 
 */
package activities;

/**
 * @author 04865H744
 *
 */
public class Car {

	public Car() {		
		tyres=4;
		doors=4;	
	}
	
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	
	public void displayCharacteristics()
	{
		System.out.println("Color of the car: "+color);
		System.out.println("Transmission of the car: "+transmission);
		System.out.println("Make of the car: "+make);
		System.out.println("Tyres of the car: "+tyres);
		System.out.println("No of doors: "+doors);	
	}
	
	public void accelerate()
	{
		System.out.println("Car is moving forward.");
	}
	
	public void brake()
	{
		System.out.println("Car has stopped.");
	}
	
	

	
}
