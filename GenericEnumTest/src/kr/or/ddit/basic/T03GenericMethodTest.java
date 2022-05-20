package kr.or.ddit.basic;

class util {
	/*
	  	���ʸ� �޼ҵ� <T, R> R method(T t)
	  	
	  	�Ķ���� Ÿ�԰� ����Ÿ������ Ÿ�� �Ķ���͸� ������ �޼ҵ�
	  	
	  	������ : ����Ÿ�� �տ� <> ��ȣ�� �߰��ϰ� Ÿ�� �Ķ���͸� ��� �� �����.
	 */
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getKey().equals(p2.getKey());
		
		return keyCompare && valueCompare;
	}
}

/**
 * 
 *��ƼŸ�� <k, v>�� ������ ���ʸ� Ŭ����
 * @author user
 *
 * @param <K>
 * @param <V>
 */
class Pair<K, V>{
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public void setKey(K key) {
		this.key = key;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public <K, V> void displayAll(K key, V val) {
		System.out.println(key.toString() + " : " + val.toString());
		
	}
	
}

public class T03GenericMethodTest {
	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "ȫ�浿");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "ȫ�浿");
		
		// ��ü�� Ÿ���� ��������� ����(��������)
		boolean result1 = util.<Integer, String>compare(p1, p2);
		
		if(result1) {
			System.out.println("��(�ǹ�)������ ������ ��ü��.");
		}else {
			System.out.println("��(�ǹ�)������ ������ ��ü �ƴ�.");
		}
		Pair<String, String> p3 = new Pair<String, String>("001", "ȫ�浿");
		Pair<String, String> p4 = new Pair<String, String>("002", "ȫ�浿");
		
		boolean result2 = util.compare(p3, p4);
		
		if(result2) {
			System.out.println("��(�ǹ�)������ ������ ��ü��.");
		}else {
			System.out.println("��(�ǹ�)������ ������ ��ü �ƴ�.");
		}
		
		p1.<String, Integer>displayAll("Ű", 180);
	}
}
