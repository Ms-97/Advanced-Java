package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06wildCardTest {
	
	// 장바구니 항목조회를 위한 메소드(모든것)
	public static void displayCartItemInfo(Cart<?> cart) {
		System.out.println("= 음식류 장바구니 항목 리스트 =");
		for(Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("----------------");
	}
	
	// 장바구니 항목조회를 위한 메소드2(음료와 그 하위)
	public static void displayCartItemInfo2(Cart<? extends Drink> cart) {
		System.out.println("= 음료 장바구니 항목 리스트 =");
		for(Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("----------------");
	}
	
	// 장바구니 항목조회를 위한 메소드3(고기류나 그 상위)
	public static void displayCartItemInfo3(Cart<? super Meat> cart) {
		System.out.println("= 고기류 장바구니 항목 리스트 =");
		for(Object obj : cart.getList()) {
			System.out.println(obj.toString());
		}
		System.out.println("----------------");
	}
	
	
	
	public static void main(String[] args) {
		
		Cart<Food> foodCart = new Cart<>();
		foodCart.addItem(new Meat("돼지고기", 5000));
		foodCart.addItem(new Meat("소고기", 10000));
		foodCart.addItem(new Juice("오렌지쥬스", 1500));
		foodCart.addItem(new Coffee("아메리카노", 2000));
		
		Cart<Meat> meatCart = new Cart<>();
		meatCart.addItem(new Meat("돼지고기", 5000));
		meatCart.addItem(new Meat("소고기", 10000));
		
		Cart<Drink> drinkCart = new Cart<Drink>();
		drinkCart.addItem(new Juice("오렌지쥬스", 1500));
		drinkCart.addItem(new Coffee("아메리카노", 2000));
		
		displayCartItemInfo(foodCart);
		displayCartItemInfo(meatCart);
		displayCartItemInfo(drinkCart);
		
		//displayCartItemInfo2(foodCart);  허용 x
		//displayCartItemInfo2(meatCart);  허용 x
		displayCartItemInfo2(drinkCart);
		
		displayCartItemInfo3(foodCart);
		displayCartItemInfo3(meatCart);
		//displayCartItemInfo3(drinkCart);  허용 x
	}
	
}

class Food{
	private String name; // 음식이름
	private int price; // 음식가격
	
	public Food(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.name + "(" + this.price + "원)";
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