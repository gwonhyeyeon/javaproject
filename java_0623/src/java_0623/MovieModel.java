package java_0623;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.List;


/*
 * MVC패턴 - 모델
 * 애플리케이션의 정보, 데이터를 나타낸다. 
 * 데이터베이스, 처음 정의하는 상수, 초기화값, 변수 등을 뜻한다
 * 이러한 DATA 정보들의 가공을 책임지는 컴포넌트들을 말한다. 
 * 1. 사용자가 편집하길 원하는 모든 데이터를 가지고 있어야 한다. 
 * - 화면 안에 네모박스에 글자가 표현된다면, 네모박스의 화면 위치 정보, 크기 정보, 
 * 글자 내용, 위치, 포멧 정보 등을 가지고 이썽야 한다. 
 * 2. 뷰나 컨트롤러에 대해서 어떤 정보도 알지 말아야 한다. 
 * - 데이터 변경이 일어났을 때 모델에서 화면 UI를 직접 조정해서 수정할 수 있도록
 * 뷰를 참조하는 내부 속성값을 가지면 안 된다. 
 * 3. 변경이 일어나면, 변경 통지에 대한 처리방법을 구현해야 한다. 
 * - 모델의 속성 중 텍스트 정보가 변경이 된다면, 이벤트를 발생시켜 누군가에게 전달해야 하며, 
 * 누군가 모델을 변경하도록 요청하는 이벤트를 보냈을 때 이를 수신하는 처리 방법을 구해야 한다. 
 * 
 * 모델: 애플리케이션의 정보, 데이터를 나타내며
 * 실제 기능을 처리한 후 결과를 컨트롤러에 반환한다. 
 * */
public class MovieModel {
//리스트에 영화제목을 추가하는 메소드
	public void addTitle(String title, List movieList) {
		movieList.add(title);
	}
	//리스트에 있는 영화제목을 삭제한느 메소드
	public void delTitle(String title, List movieList) {
		movieList.remove(title);
	}
	//리스트에 있는 영화제목들을 파일에 저장하는 메소드
	public void saveTitles(List movieList) throws Exception{
		//파일이 없으면 파일을 생성한다. 
		File file = new File("movieTitle2.txt");
		//filewriter의 메소드 write를 통해서 char배열의 문자열을 하나씩 기록한 후 스트림을 닫는다. 
		FileWriter fw = new FileWriter(file, true);
		//wirter의 값과 객체를 print
		PrintWriter pw = new PrintWriter(fw);
		//getItems : Gets the items in the list.
		String items[] = movieList.getItems();
		//리스트의 목록을 배열로 가지고 items에 저장된 문자열 만큼 file에  print를 반복한다
		for(int i = 0; i < items.length; i++) {
			pw.println(items[i]);
			System.out.println(items[i]);
		}
		fw.close();
		pw.close();
	}
}
