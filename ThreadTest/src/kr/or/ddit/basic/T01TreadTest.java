package kr.or.ddit.basic;
/**
 * 멀티 스레드 프로그램
 * @author user
 *
 */
public class T01TreadTest {
	public static void main(String[] args) {
		//방법1: Thread클래스를 상속한 class의 인스턴스를 생성한 후
		//       이 인스턴스의 start() 메소드를 호출한다.
	
		MyTread1 th1 = new MyTread1();
		th1.start();
		
		// 방법2: Runnable 인터페이스를 구현한 클래스의 인스턴스를 생성한 후
		//        이 인스턴스를 Thread객체의 인스턴스를 생성할 때 생성자의
		//        매개변수로 넘겨준다. 이때 생성된 Thread객체의 인스턴스의 
		//        start()매소드를 호출한다.
		Runnable r = new MyTread2();
		Thread th2 = new Thread(r);
		th2.start();
		
		// 방법3 : 익명클래스를 이용하는 방법
		//         Runnable 인터페이스를 구현한 익명클래스를 이용하여 
		//         스레드 객체를 생성한다.
		Thread th3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1; i<=200; i++) {
					System.out.print("@");
					
					try {
						// Tread.sleep(시간) => 주어진 시간동안 작업을 잠시 멈춘다.
						// 시간은 밀리세컨드 단위를 사용한다. (1초 = 1ms)
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		th3.start();
	}	
}

class MyTread1 extends Thread {
	@Override
	public void run() {
		for(int i=1; i<=200; i++) {
			System.out.print("*");
			
			try {
				// Tread.sleep(시간) => 주어진 시간동안 작업을 잠시 멈춘다.
				// 시간은 밀리세컨드 단위를 사용한다. (1초 = 1ms)
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MyTread2 implements Runnable {

	@Override
	public void run() {
			for(int i=1; i<=200; i++) {
				System.out.print("$");
				
				try {
					// Tread.sleep(시간) => 주어진 시간동안 작업을 잠시 멈춘다.
					// 시간은 밀리세컨드 단위를 사용한다. (1초 = 1ms)
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
}

