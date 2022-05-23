package kr.or.ddit.basic;
/**
 * 싱글 스레드 프로그램
 * @author user
 *
 */
public class T02TreadTest {
	public static void main(String[] args) {
		for(int i=1; i<=200; i++) {
			System.out.print("*");
		}
		for(int i=1; i<=200; i++) {
			
			System.out.print("$");
		}
	}

	
}
