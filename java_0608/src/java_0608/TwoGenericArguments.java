package java_0608;
//Ex_06
class KeyValue<T, F> {
	
	private T t;
	private F f;

	public void setKey(T t) {
		this.t = t;
	}
	public T getkey() {
		return t;
	}
	public F getValue() {
		return f;
	}
	public void setValue(F f) {
		this.f = f;
	}
}

public class TwoGenericArguments {

	public static void main(String[] args) {
		KeyValue<String, Integer> kv1 = new KeyValue<>();
		kv1.setKey("사과");
		kv1.setValue(1000);
		String key1 = kv1.getkey();
		int value1 = kv1.getValue();
		System.out.println("key:" + key1 + "value: " + value1);
		
		KeyValue<Integer, String> kv2 = new KeyValue<>();
		kv2.setKey(404);
		kv2.setValue("Not Found(요청한 페이지를 찾을 수 없습니다.)");
		int key2 = kv2.getkey();
		String value2 = kv2.getValue();
		System.out.println("key: " + key2 + " value:"+ value2);
		KeyValue<String, Void> kv3 = new KeyValue<>();
		kv3.setKey("키값만 사용");
		String key3 = kv3.getkey();
		System.out.println("key: " + key3);
	}
}
