package java_0615_2;

public class Ex_06CreateAndStartThread_M1C1 {
	
	public static void main(String[] args) {
//#1. 방법1. thread 클래스 상속하여 클래스 생성 case1. 2개의 쓰레드 생성
	Thread smiFileThread = new SMIFileThread();
	smiFileThread.start();
	
	int[] intArray = { 1, 2, 3, 4, 5};
	
	for( int i =0; i < intArray.length; i++) {
		System.out.print("(비디오 프레임)" + intArray[i]);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
		}
	}
	}
}
class SMIFileThread extends Thread{
	//#1. 방법1. thread 클래스 상속하여 클래스 생성 case1. 2개의 쓰레드 생성
		@Override
		public void run() {
			//#2. 자막 번호 하나~다섯
			String[] strArray = {"하나", "둘", "셋", "넷", "다섯" };
			try {
				Thread.sleep(10);
			}catch (InterruptedException e) {
			
			}
			//#4.자막 번호 출력
			for( int i = 0; i < strArray.length; i ++) {
				System.out.println(" - (자막번호) "+ strArray[i]);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {			
				}
			}		
		}
	}
