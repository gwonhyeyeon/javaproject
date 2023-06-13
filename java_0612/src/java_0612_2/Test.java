package java_0612_2;

import java.util.List;

public class Test {

	public void getProductText_Set(List<?> list) {
        //데이터를 저장할 때 객체와 객체의 변수들을 생성한다.
        //String은 null로 int는 0으로 초기화
	   		
	   		Product_ArrayList<String> prod = null;
           String code = null;
           String name = null;
           String color = null;
           String qty = null;
           for (int i = 0; i < list.size()
           		; i++) {
              //전송받은 list객체는 List 타입이므로 형변환이 필요
                 prod = (Product_ArrayList<String>)list.get(i);
              //형변환 후 내부에 저장된 변수들도 형변환해 데이터 획득
                 code = (String) prod.getCode();
                 name = (String) prod.getName();
                 color = (String) prod.getColor();
                 qty = (String) prod.getQty();
                 
                 System.out.println("제품 번호 = " + code);
                 System.out.println("제품 이름 = " + name);
                 System.out.println("제품 색상 = " + color);
                 System.out.println("제품 수량 = " + qty);     
           }
}
}
