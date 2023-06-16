package java_0615_2;

public class Ex_05Blue01 extends Thread{
	
	@Override
	public void run() {
		//스레드 실행 시 해당 출력 문 무한 반복
		while(true)
			System.out.println("청기 올려!!");
	}
}


//public class Ex_05Blue01 implements Runnable{
//	
//
//	public void run() {
//		//스레드 실행 시 해당 출력 문 무한 반복
//		while(true)
//			System.out.println("청기 올려!!");
//	}
//}