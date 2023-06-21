package java_0621;
//EX03
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

//웹에 있는 특정한 이미지 파일을 한정된 버퍼를 사용하여 다운로드하는 프로그램을 작성해보자
//한정된 버퍼의 크기는 2048이다
public class WebImageDownload {

	public static void main(String[] args) throws MalformedURLException {
		String website = "https://www.gstatic.com/webp/gallery/1.sm.jpg";
		System.out.println("" + website + "사이트에서 이미지를 다운로드합니다." );
			URL url = new URL(website);
			byte[] buffer = new byte[2048];
			//byte형 배열 buffer를 선언하고 그 크기를 2048로 지정함
			//한번에 가져올 수 있는 데이터의 크기를 지정하면 좋음
			//보통 적게는 1024, 2048, 많게는 4096정도의 크기로 지정함
			try(InputStream in = url.openStream();
					//url.openstream : url주소를 inputstream에 넣어준다
					//inputstream 바이트 단위 입력 스트림
				FileOutputStream out = new FileOutputStream("test.jpg");
					){
					//주어진 이름의 파일을 쓰기 위한 객체를 생성
					//기존의 파일이 존재할 때는 그 내용을 지우고 새로운 파일을 생성
					int length = 0;//lengh변수 선언 후 값을 초기화함
					while((length = in.read(buffer)) != -1) {
						System.out.println("" + length + "바이트 크기 만큼 읽었음!");
						out.write(buffer, 0, length);
					}
					in.close();//InputStream은 닫아주는 게 원칙
					out.close();//OutputStream은 닫아주는 게 원칙
			}catch (Exception e) { //예외 발생 시 출력 구문 출력
				System.out.println("예외 : "+ e.getMessage());
			}//try() 괄호 안에 들어가는 것은 자원에 해당됩니다, 두 개의 자원이 들어가 있죠
	}//try문장이 끝나면 자동으로 해제됩니다. 
}
