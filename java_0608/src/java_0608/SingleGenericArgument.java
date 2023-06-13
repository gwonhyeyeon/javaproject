package java_0608;
//EX_02
class MyClass<T> {
	
	private T t;

	public void set(T t) {
		this.t = t;
	}
	public T get() {
		return t;
	}
}
public class SingleGenericArgument {

	public static void main(String[] args) {
		MyClass<String> mc1 = new MyClass<String>();
		mc1.set("안녕");
		System.out.println(mc1.get()); //여기서 T를 출력
		MyClass<Integer> mc2 = new MyClass<>();
		mc2.set(100);
		System.out.println(mc2.get());
	}
}
