package java_0612_hw;

import java.util.List;
import java.util.ArrayList;

//ArrayList 객체를 List로 형을 맞추고 와일드카드를 활용해 저장된 요소들의 객체 정보를 맞춤
class Product_ArrayList<T> {
	private T code;
	private T name;
	private T color;
	private T qty;
	
	public Product_ArrayList(T code, T name, T color, T qty) {
		this.code = code;
		this.name = name;
		this.color = color;
		this.qty = qty;		
	}

	public T getCode() {
		return code;
	}

	public void setCode(T code) {
		this.code = code;
	}

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	public T getColor() {
		return color;
	}

	public void setColor(T color) {
		this.color = color;
	}

	public T getQty() {
		return qty;
	}

	public void setQty(T qty) {
		this.qty = qty;
	}
}


class Test {
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


public static class Ex_11 {

	public static void main(String[] args) {
		
	 ArrayList<Product_ArrayList<String>> pList = new ArrayList<>();
	 
	 Product_ArrayList<String> p1 = 
			 new Product_ArrayList<>("0001", "스마트폰", "블랙", "100");
	 Product_ArrayList<String> p2 = 
			 new Product_ArrayList<>("0002", "스마트 TV", "흰색", "200");
	 Product_ArrayList<String> p3 = 
			 new Product_ArrayList<>("0003", "노트북", "은색", "100");
	 
	 pList.add(p1); 
	 pList.add(p2); 
	 pList.add(p3); 
	 Test p = new Test();
	 p.getProductText_Set(pList);
	}
}
}


