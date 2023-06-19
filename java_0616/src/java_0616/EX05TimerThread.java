package java_0616;

public class EX05TimerThread extends Thread{
	
	private int n = 0;
	private boolean flag = false;
	
	//종료 메소드 : 플래그 ㅈ전환
	public void finish() {
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = true;
	}
	//스레드 동작 실행 
	@Override
	public void run() {
		while(true) {
			System.out.println(n);
			n++;
			try {
				sleep(1000);
				if(flag == true)
					return;
				
			} catch (InterruptedException e) {
				return;
				
			}
		}
	}

	public static void main(String[] args) {
//스레드객체 생성 후 실행하자마자
		EX05TimerThread th = new EX05TimerThread();
		th.start();
		th.finish();
	}
}
//스레드 상태 제어 메서드들
//sleep() 특징
//sleep(long millis)
//Thread.sleep() 메소드는 현재 쓰레드가 일정 기간 동안 실행을 중지시킨다. 
//우선순위가 낮은 스레드가 기아 상태에 빠지는 것을 방지할 수 있다. 

//join특징 : 다른 쓰레드의 작업을 기다린다. 
//조인(join)은 한 쓰레드가 다른 쓰레드의 완료를 기다리게 한다. 
//만약 t가 현재 동작 중인 스레드의 객체라고 한다면
//t.join(); 이 코드는 현재 쓰레드가 t 쓰레드가 종료될 때 까지 실행을 중단합니다. 

//yield() 특징: 다른 쓰레드에게 양보한다. 
//yield() 메소드를 호출한 스레드는 실행 대기상태로 돌아가고 동일한 우선순위
//또는 높은 우선 순위를 갖는 다른 스레드가 실행 기회를 가질 수 있도록 해준다. 
//예를 들어 스케쥴러에 의해 1초의 실행시간을 할당받은 스레드가 0.5초의 시간 동안 작업한 상태에서
//yield()가 호출되면 나머지 0.5초는 포기하고 다시 실행 대기 상태가 된다. 
//호출방법 Thread.yield(); CPU의 자원의 소모를 방지할 수 있다. 