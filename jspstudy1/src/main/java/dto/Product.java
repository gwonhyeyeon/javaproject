package dto;

import java.io.Serializable;

//Serializable : 직렬화
public class Product implements Serializable {
	//상품 목록 표시하기 
	private static final long serialVersinUID = -4274700572038677000L;
	private String productId; //상품 아이디
	private String pname;	//상품명
	private Integer unitPrice; //상품가격
	private String description; //상품 설명
	private String manufacturer; //제조사
	private String category; //분류, 목록표(리스트)
	private long unitsInStock; //재고수 
	private String condition; //신상품 or 중고품 or 재생품
	//DTO는 Data Transfer Object의 약자로, 데이터 전송을 위한 객체를 말합니다. 
	//주로 데이터베이스와의 데이터 교환을 담당하는 객체로 사용되며,
	// 데이터의 저장과 전달을 간편하게 하기 위해
	//자바빈즈란?
	// 자바로 작성한 소프트웨어 컴포넌트로, 다음의 규약을 따르는 자바 클래스를 말한다.
	//자바 빈은 private 필드를 외부에서 접근하기 위해서
	//공개형 접근 제한자인 public 으로 메소드를 정의해 놓고 통해서 간접적으로 필드에 접근합니다. 
	//이와 같은 방식을 프로퍼티(property)라고 합니다. 
	//이제 jsp에서 어떻게 활용하는지 살펴보기
	//<jsp:useBean> 		자바 빈을 생성합니다. 
	//<jsp:setProperty>		자바 빈에서 정보를 얻어옵니다. 
	//<jsp:setProperty>		자바 빈에 정보를 저장합니다. 
	
	//자바빈즈 규약을 따른다. 
	public Product() {
		super();
	}
	
	//getter & setter 메서드 생성한다. 
	//자동으로 생성하면 된다.
	//jsp에서는 자바빈(JAVABean)이라는 클래스에 담아서 값을 보여준다. 
	public Product(String productId, String pname, Integer unitPrice) {
		super();
		this.productId = productId;
		this.pname = pname;
		this.unitPrice = unitPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public static long getSerialversinuid() {
		return serialVersinUID;
	}
}
