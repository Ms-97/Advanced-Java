package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06wildCardTest {
	
	// ��ٱ��� �׸���ȸ�� ���� �޼ҵ�(����)
	public static void displayCartItemInfo(Cart<?> cart) {
		System.out.println("= ���ķ� ��ٱ��� �׸� ����Ʈ =");
		for(Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("----------------");
	}
	
	// ��ٱ��� �׸���ȸ�� ���� �޼ҵ�2(����� �� ����)
	public static void displayCartItemInfo2(Cart<? extends Drink> cart) {
		System.out.println("= ���� ��ٱ��� �׸� ����Ʈ =");
		for(Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("----------------");
	}
	
	// ��ٱ��� �׸���ȸ�� ���� �޼ҵ�3(������ �� ����)
	public static void displayCartItemInfo3(Cart<? super Meat> cart) {
		System.out.println("= ���� ��ٱ��� �׸� ����Ʈ =");
		for(Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("----------------");
	}
	
	
	
	public static void main(String[] args) {
		
		Cart<Food> foodCart = new Cart<>();
		foodCart.addItem(new Meat("�������", 5000));
		foodCart.addItem(new Meat("�Ұ��", 10000));
		foodCart.addItem(new Juice("�������꽺", 1500));
		foodCart.addItem(new Coffee("�Ƹ޸�ī��", 2000));
		
		Cart<Meat> meatCart = new Cart<>();
		meatCart.addItem(new Meat("�������", 5000));
		meatCart.addItem(new Meat("�Ұ��", 10000));
		
		Cart<Drink> drinkCart = new Cart<Drink>();
		drinkCart.addItem(new Juice("�������꽺", 1500));
		drinkCart.addItem(new Coffee("�Ƹ޸�ī��", 2000));
		
		displayCartItemInfo(foodCart);
		displayCartItemInfo(meatCart);
		displayCartItemInfo(drinkCart);
		
		//displayCartItemInfo2(foodCart);  ��� x
		//displayCartItemInfo2(meatCart);  ��� x
		displayCartItemInfo2(drinkCart);
		
		displayCartItemInfo3(foodCart);
		displayCartItemInfo3(meatCart);
		//displayCartItemInfo3(drinkCart);  ��� x
	}
	
}

class Food{
	private String name; // �����̸�
	private int price; // ���İ���
	
	public Food(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.name + "(" + this.price + "��)";
	}
}

class Meat extends Food {

	public Meat(String name, int price) {
		super(name, price);
	}
}

class Drink extends Food {

	public Drink(String name, int price) {
		super(name, price);
	}
}

class Juice extends Drink {

	public Juice(String name, int price) {
		super(name, price);
	}
}

class Coffee extends Drink {

	public Coffee(String name, int price) {
		super(name, price);
	}
}

class Cart<T> {
	private List<T> list = new ArrayList<T>();

	public List<T> getList() {
		return list;
	}
	
	public void addItem(T item) {
		list.add(item);
	}
}