package java_0605;

public class MyCarTest {

	public static void main(String[] args) {
		System.out.println("Car.SAFE_SPEED=" + MyCar.SAFE_SPEED);
		
		MyCar c = new MySportsCar();
		c.speedUp();
		c.speedDown();
		c.stop();
		System.out.println();
	
		MyTruck t = new MyTruck();		
		t.speedUp();		
		t.speedDown();		
		t.stop();	
		
		System.out.println();
		MySportsCar s = new MySportsCar();
		s.speedUp();
		s.speedDown();
		s.stop();
		s.turbo();
	}

}
