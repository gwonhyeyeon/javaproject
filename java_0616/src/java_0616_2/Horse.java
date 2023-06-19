package java_0616_2;

public class Horse implements Runnable{
	private int horse_num; //말의 번호
	private int curMeter; //현재 위치
	private final int MAXMETER = 1000; //골인지점
	private int speed = 10; //run한번 실행시마다 이동하는 거리 
	private static int rank = 1; //등수
	private int fake_horse_num = 8; //특정 조작을 가한 말의 번호
	
	public Horse(int horse_num) {
		this.horse_num = horse_num;
	}//생성자
	
	public void run() {//런 메서드 
		while( curMeter < MAXMETER ) {//최대 거리(골인지점) 보다 현재 위치가 작으면 반복실행
			long sleepTime = (long)(Math.random() * 500);
			//0~499의 랜덤값을 갖는 sleepTime 변수
			curMeter += speed; //현재 미터에 속도를 더함(반복시마다 10 추가)
			
			if(horse_num == fake_horse_num) {//말의 번호가 페이크말의 번호가 같을 때 실행
				if(curMeter == 500) {
					fake_Comment();
				}
				//curMeter(현재 위치)가 500이면 페이크코멘트 메소드 호출
				 if(curMeter >= 500 && rank < 9) 
					 //500미터 이상이면서 8등까지 정해지지 않았을 때 실행
					 sleepTime = fake(sleepTime);
				 //fake메소드를 통해 sleepTime의 값을 변경
			}
			if(curMeter % 100 == 0) //현재 미터를 100으로 나눈 나머지가 0이면 실행
				System.out.println(horse_num + "번 말이" + curMeter + "미터 도착");
			try {
				Thread.sleep(sleepTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(curMeter >= MAXMETER) {//현재 미터가 최대 미터 보다 크거나 같으면 실행
			System.out.println(horse_num + "번 말이 결승선 도착" + rank + "등 도착");
			rank++;
		}
	}
	}
	public long fake(long sleepTime) {
		return sleepTime + 500;
	}//받은 인자의 값에 500을 더해 리턴해주는 메소드 
	
	public void fake_Comment() {
		System.out.println("아 " + fake_horse_num + "번 말이 사행을 하는데요");
	}
//해당 문자열을 출력해주는 메소드 
}
