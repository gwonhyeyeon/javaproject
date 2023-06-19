package java_0616_2;

public class E11SynchronizedEX {
//공유 데이터 객체 생성
	public static void main(String[] args) {
  
		 Thread th2 = new WorkerThread(p, korText);
		 
		 th1.start();
		 th2.start();
	}
}
//공유 데이터 클래스 
class SharedPrinter {
	SharedPrinter p;
	String[] text;
	
	WorkerThread(SharedPrinter p, String[] text){
		this.p = p;
		this.text = text;
	}
	//메소드 실행 
	public void run() {
		
	}
}

class WorkerThread extends Thread {
	SharedPrinter p;
	String[] text;
	
	//생성 시 공유 데이터 객체와 문자열 배열을 매개변수로 받아서 필드 초기화
	WorkerThread(SharedPrinter p , )
}