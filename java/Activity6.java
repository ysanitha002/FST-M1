package activities;

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		
		Plane tplane = new Plane(10);
		
		tplane.onboard("Anitha");
		tplane.onboard("Anjana");
		tplane.onboard("Priya");
		tplane.onboard("Usha");
		tplane.onboard("Meena");
		tplane.onboard("Anil");
		tplane.onboard("Vasu");
		tplane.onboard("Pramod");
		
		System.out.println("Flight tplane took off at : "+tplane.takeOff());
		
		System.out.println("List of passengers on flight tplane is :\n "+tplane.getPassengers());
		
		Thread.sleep(5000);
		
		tplane.land();
		System.out.println("Flight tplane landed at : "+ tplane.getLastTimeLanded());
		
		System.out.println("List of passengers on flight after landing :\n "+tplane.getPassengers());
	}

}
