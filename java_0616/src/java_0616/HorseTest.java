package java_0616;


public class HorseTest {

	public static void main(String[] args) {
		
		Thread[] tarr = new Thread[9];
		
		for( int i = 0; i<tarr.length; i++) {
			tarr[i] = new Thread(new Horse(i+1));
			tarr[i].start();
		}
		System.out.println("main() 종료...");

	}
}
//스레드 동기화란?
//1. 공유 데이터를 접근하는 모든 스레드를 한 줄로 세워
//한 스레드가 공유 데이터에 대한 작업을 끝날 때까지 다른 스레드가 대기하도록 하는 것
//1. synchronized 로 동기화 블록 지정
//public synchronized void method_Name() {
//동기화할 내용

