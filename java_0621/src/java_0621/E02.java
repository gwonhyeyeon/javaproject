package java_0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



public class E02 {//화면의 눈에 보이는 정적 모습을 보여주는 html코드

	public static void main(String[] args) throws Exception {
	//url클래스 생성
		URL site = new URL("http://www.erum4ever.kr/");
		//url site = new URL("https://www.seoulteck.ac.kr/index.jsp);
		URLConnection url = site.openConnection();
		//url.getInputStream : URLConnection클래스에서 인풋스트림(입력)설정
		//입력받은 정보를 BufferedReader객체에 저장하고 
		BufferedReader in= new BufferedReader(new InputStreamReader(url.getInputStream()));
		//줄 단위로String 변수에 저장함
		String inLine = in.readLine();
		//inLine에 저장된 모든 데이터를 콘솔창에 출력함
		while((inLine = in.readLine()) != null)
			System.out.println(inLine);
		in.close();
	}
}
//urlConnection
//추상 클래스 URLConnection은 애플리케이션과 url간의 통신 링크를 나타내는
//모든 클래스의 수퍼 클래스이다
//이 클래스의 인스턴스는 url에서 참조하는 리소스에서 읽고 쓰는 데 모두 사용할 수 있습니다. 
