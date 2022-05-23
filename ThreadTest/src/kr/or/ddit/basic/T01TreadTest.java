package kr.or.ddit.basic;
/**
 * ��Ƽ ������ ���α׷�
 * @author user
 *
 */
public class T01TreadTest {
	public static void main(String[] args) {
		//���1: ThreadŬ������ ����� class�� �ν��Ͻ��� ������ ��
		//       �� �ν��Ͻ��� start() �޼ҵ带 ȣ���Ѵ�.
	
		MyTread1 th1 = new MyTread1();
		th1.start();
		
		// ���2: Runnable �������̽��� ������ Ŭ������ �ν��Ͻ��� ������ ��
		//        �� �ν��Ͻ��� Thread��ü�� �ν��Ͻ��� ������ �� ��������
		//        �Ű������� �Ѱ��ش�. �̶� ������ Thread��ü�� �ν��Ͻ��� 
		//        start()�żҵ带 ȣ���Ѵ�.
		Runnable r = new MyTread2();
		Thread th2 = new Thread(r);
		th2.start();
		
		// ���3 : �͸�Ŭ������ �̿��ϴ� ���
		//         Runnable �������̽��� ������ �͸�Ŭ������ �̿��Ͽ� 
		//         ������ ��ü�� �����Ѵ�.
		Thread th3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1; i<=200; i++) {
					System.out.print("@");
					
					try {
						// Tread.sleep(�ð�) => �־��� �ð����� �۾��� ��� �����.
						// �ð��� �и������� ������ ����Ѵ�. (1�� = 1ms)
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
				// Tread.sleep(�ð�) => �־��� �ð����� �۾��� ��� �����.
				// �ð��� �и������� ������ ����Ѵ�. (1�� = 1ms)
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
					// Tread.sleep(�ð�) => �־��� �ð����� �۾��� ��� �����.
					// �ð��� �и������� ������ ����Ѵ�. (1�� = 1ms)
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
}

