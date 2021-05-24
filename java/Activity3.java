package activities;

/*Given an age in seconds, calculate how old someone would be on:
Earth: orbital period 365.25 Earth days, or 31557600 seconds
Mercury: orbital period 0.2408467 Earth years
Venus: orbital period 0.61519726 Earth years
Mars: orbital period 1.8808158 Earth years
Jupiter: orbital period 11.862615 Earth years
Saturn: orbital period 29.447498 Earth years
Uranus: orbital period 84.016846 Earth years
Neptune: orbital period 164.79132 Earth years
So if you were told someone were 1,000,000,000 seconds old, you should be able to say that they're 31.69 Earth-years old
 */

public class Activity3 {
	
    public static void main(String args[]) {
    	
        double seconds = 1000000000;

        double EarthSeconds = 31557600;
        double MercurySeconds = 0.2408467;
        double VenusSeconds = 0.61519726;
        double MarsSeconds = 1.8808158;
        double JupiterSeconds = 11.862615;
        double SaturnSeconds = 29.447498;
        double UranusSeconds = 84.016846;
        double NeptuneSeconds = 164.79132;
        
        System.out.println("Age on Mercury: " + seconds / EarthSeconds / MercurySeconds);
        System.out.println("Age on Venus: " + seconds / EarthSeconds / VenusSeconds);
        System.out.println("Age on Earth: " + seconds / EarthSeconds);
        System.out.println("Age on Mars: " + seconds / EarthSeconds / MarsSeconds);
        System.out.println("Age on Jupiter: " + seconds / EarthSeconds / JupiterSeconds);
        System.out.println("Age on Saturn: " + seconds / EarthSeconds / SaturnSeconds);
        System.out.println("Age on Uranus: " + seconds / EarthSeconds / UranusSeconds);
        System.out.println("Age on Neptune: " + seconds / EarthSeconds / NeptuneSeconds);
    }    
}