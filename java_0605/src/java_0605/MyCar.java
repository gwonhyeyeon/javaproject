package java_0605;
//인터페이스들간의 관계는 상속(extends)이다.
public interface MyCar {
	public static final int SAFE_SPEED=60;//상수
	//public int SAFE_SPEED = 60;
	public abstract void speedUp(); //추상 메서드
	public abstract void speedDown();
	public abstract void stop();
}	
	/* 
	 public void speedUp()
	 public void speedDown()
	 public void stop()
	 */
//<<interface>>
	 //  MyCar
	//implements사용
//Truck         SportsCar}
