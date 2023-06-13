package java_0601;

import java.util.Scanner;

public class CityDriver {

	public static void main(String[] args) {
		//City객체 참조 변수
		City aCity;
		//예상인구
		int newPopulation;
		//연도
		int years = 10;
		Scanner keyboard = new Scanner(System.in);
		//계속 여부
		boolean again = true;
		//사용자가 계속 하기를 원하는 동안 도시의 10년 후 예상 인구를 계산한다
		while(again)
		{
			//City객체를 생성하고 aCity가 가리키게 한다
			aCity = new City();
			//aCity의 도시 이름, 인구와 인구 증가율을 읽어 들인다
			aCity.readInput();
			//aCity의 도시 이름, 인구와 인구 증가율을 출력한다
			aCity.writeOutput();
			//aCity의 10년 후 인구를 계산한다
			newPopulation = aCity.computeFuturePopulation(years);
			//acity의 예상 인구를 출력한다
			System.out.println(years + "년후 예상 인구: " + newPopulation);
			//계속 여부를 입력 받는다. 
			System.out.println("계속하기를 원하세요(true 혹은 false)? : ");
			again = keyboard.nextBoolean();
			keyboard.close();	
		}
	}
}
