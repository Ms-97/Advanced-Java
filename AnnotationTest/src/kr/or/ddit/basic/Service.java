package kr.or.ddit.basic;

public class Service {
	
	@PrintAnnotation()  // () 생략가능
	public void method1() {
		System.out.println("메소드1에서 출력되었습니다.");
	}
	@PrintAnnotation(value = "%") // value 생략가능
	public void method2() {
		System.out.println("메소드2에서 출력되었습니다.");
	}
	@PrintAnnotation(value = "#", count = 25) // value 생략 불가능
	public void method3() {
		System.out.println("메소드3에서 출력되었습니다.");
	}
	
}
