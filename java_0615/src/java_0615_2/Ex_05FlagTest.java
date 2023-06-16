package java_0615_2;

public class Ex_05FlagTest {

	public static void main(String[] args) {
		//스레드 클래스 객체 생성
		Ex_05White01 white = new Ex_05White01();
		Ex_05Blue01 blue = new Ex_05Blue01();
		
		white.start();
		blue.start();
	}
}


//public class Ex_05FlagTest {
//
//	public static void main(String[] args) {
//		
//		
//		Thread t = new Thread(new Ex_05Blue01);
//		t.start();
//		Thread t2 = new Tread(new Ex_05White01());
//		t2.start();
//	
//	}
//}