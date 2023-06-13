package java_0601;

import java.util.Scanner;

class City {
	//aCity의 도시 이름, 인구와 인구 증가율을 읽어 들인다
	private String cityName;//도시이름
	private int population; //인구 
	private int growthRate; //인구증가율
		
 public void  readInput() {
	 	Scanner sc = new Scanner(System.in);
		System.out.println("도시 이름을 입력하세요 : ");
		cityName = sc.next();
		System.out.println("인구를 입력하세요 : ");
		Scanner sc2 = new Scanner(System.in);
		population = sc2.nextInt();
		System.out.println("인구증가율(%)을 입력하세요 : ");
		Scanner sc3 = new Scanner(System.in);
		growthRate = sc3.nextInt();
		sc.close();
		sc2.close();
		sc3.close();
	}

public void writeOutput() {
		System.out.println("도시 = "+ cityName);
		System.out.println("인구 = " + population);
		System.out.println("인구 = " + growthRate);	
	}
public int computeFuturePopulation(int years) {

	
		int newPopulation = population + (population*growthRate)/100;
		
		return newPopulation;
		
}
}
