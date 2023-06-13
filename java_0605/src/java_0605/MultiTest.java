package java_0605;

public class MultiTest {

	public static void main(String[] args) {
		
		Child c = new Child();
		ITest i = new Child();
		ITest1 i1 = new Child();
		c.test();
		c.func1();
		c.func2();
		System.out.println();
		
		i.test();
		//i.func1(); ITest func1을 상속받지 않았다. 
		//i.func2();
		i1.func1();
	}
}
