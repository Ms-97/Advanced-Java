package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T05wildCardTest {
	/*
	 	���ϵ� ī�忡 ���Ͽ�...
	 	
	 	���ϵ�ī��(?)�� ���ʸ� Ÿ���� �̿��� Ÿ�� ������ �ڵ带 ���� ����ϴ� Ư���� ������
	 	�μ�(Argument)�μ�, ��������, ��ü���� �� �޼ҵ� ���� �� �� ���ȴ�.
	 	
	 	<? extends T> => ���ϵ� ī���� ���� ����. T�� �� �ڼյ鸸 ����
	 	<? Super T>   => ���ϵ� ī���� ���� ����. T�� �� ����鸸 ����
	 	<?>           => ��� Ÿ���� ���� <? extends Object>�� ����.
	 */  
	
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>(); // ���ϻ���
		FruitBox<Apple> appleBox = new FruitBox<Apple>(); // �������
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		Juicer.makeJuice(fruitBox);
		Juicer.makeJuice(appleBox);
	}
}

class Juicer {
	static void makeJuice(FruitBox<? extends Fruit> box) {
		
		String fruitListStr = "";
		
		int cnt = 0;
		for(Object f : box.getFrutiList()) {
			if(cnt == 0) {
				fruitListStr += f;
			}else {
				fruitListStr += ", " + f;
			}
			cnt++;
		}
		System.out.println(fruitListStr + " => �꽺 �ϼ�!!!");
	}
}

class Fruit {
	private String name;
	public Fruit(String name) {
		this.name = name;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "����(" + name + ")";
	}
}

class Apple extends Fruit{

	public Apple() {
		super("���");
	}
}

class Grape extends Fruit{

	public Grape() {
		super("����");
	}
}

/**
 * ���� ����
 * @author user
 *
 * @param <T>
 */
class FruitBox<T> {
	private List<T> frutiList;
	
	public FruitBox() {
		frutiList = new ArrayList<T>();
		
	}
	public List<T> getFrutiList() {
		return frutiList;
	}
	
	public void add(T fruit) {
		frutiList.add(fruit);
	}
}