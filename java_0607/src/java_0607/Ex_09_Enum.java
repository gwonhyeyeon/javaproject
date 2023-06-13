package java_0607;

import java.util.Calendar;

public class Ex_09_Enum {
	//new : 계속해서 객체를 만들 수 있다. 
	//getInstance 하나의 인스턴스(객체만)가지고 공유한다. 
	//캘런더 객체 생성의 기본 형식으로 알아두면 좋다 
	

	public static void main(String[] args) {
		Week today = null;
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);
				//데이터 중에는 몇 가지로 한정된 값만을 갖는 경우가 있다. 
				//이런 타입을 열거 타입이라고 함
				//일요일1에서 토요일7까지의 숫자를 리턴한다. 
				switch (week) {
				case 1:
					today = Week.SUNDAY;
					break;
				case 2:
					today = Week.MONDAY;
					break;
				case 3:
					today = Week.TUSEDAY;
					break;
				case 4:
					today = Week.WEDNESDAY;
					break;
				case 5:
					today = Week.THURSDAY;
					break;
				case 6:
					today = Week.FRIDAY;
					break;
				case 7:
					today = Week.SATURDAY;
					break;
				}
		System.out.println("오늘 요일 : " + today);
		if(today == Week.SUNDAY) {
			System.out.println("일요일에는 과제 정리를 합니다. ");
		} else {
			System.out.println("열심히 자바 공부합니다. ");
		}
	}

}
