package kr.or.ddit.basic;


public class T11DisplayCharacterTest {
	static String strRank = "";
/*
    3개(명)의 스레드가 각각 알파벳 대문자를 출력하는데 출력을 끝낸
    순서대로 결과를 나타내는 프로그램 작성하기
 */
	public static void main(String[] args) {
		DisplayCharacter[] disChars = new DisplayCharacter[] {
				new DisplayCharacter("홍길동"),
				new DisplayCharacter("일지매"),
				new DisplayCharacter("변학도")
		};
		
		for(Thread th : disChars) {
			th.start();
		}
		
		for(Thread th : disChars) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("경기 끝...");
		System.out.println("-------------------");
		System.out.println();
		System.out.println(" 경기 결과 ");
		System.out.println(" 순위 : "+ strRank);
	}
}

// 영어 대문자를 출력하느 스레드 클래스
class DisplayCharacter extends Thread{
	private String name;
	
	public DisplayCharacter(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(char ch='A'; ch<='Z'; ch++) {
			System.out.println(name +"의 출력문자 : " +ch);
			
			try {
				// sleep() 메소드의 값을 200~500사이의 난수로 설정한다.
				Thread.sleep((int)(Math.random() * 301 + 200));
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println(name + "출력 끝...");
		T11DisplayCharacterTest.strRank += name + " ";
	}
}