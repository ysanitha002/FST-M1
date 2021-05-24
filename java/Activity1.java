/**
 * 
 */
package activities;

/**
 * @author 04865H744
 *
 */
public class Activity1 {

	public static void main(String[] args) {
		
		Car hyundai = new Car();
		
		hyundai.make = 2016;
		hyundai.color = "White";
		hyundai.transmission = "Manual";
		
		hyundai.displayCharacteristics();
		hyundai.accelerate();
		hyundai.brake();

	}

}
