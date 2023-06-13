package java_0612_2;

import java.util.ArrayList;

public class Ex_11_1 {

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
