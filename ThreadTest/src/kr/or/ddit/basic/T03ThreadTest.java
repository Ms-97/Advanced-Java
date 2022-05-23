package kr.or.ddit.basic;

public class T03ThreadTest {
	public static void main(String[] args) {
		Thread th = new Thread(new MyRunner());
		
		// UTC(Universal Time Coodinated ���� ���� ǥ�ؽ�)�� ����Ͽ�
		// 1970�� 1�췯 1�� 0�� 0�� 0�ʸ� �������� ����� �ð��� �и�������
		// ������ ��Ÿ����.
		long startTime = System.currentTimeMillis();
		System.out.println("startTime :" + startTime);
		th.start(); // ������ ����
		
		try {
			th.join();  // ���� �������� �����忡�� �۾����� ������
			            // (������ th������)�� ����� ������ ��ٸ���.
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("endTime :" + startTime);
		System.out.println("��� �ð� : "+(endTime - startTime));
	}
}

//1~1000000000 ������ �հ踦 ���ϴ� ������ Ŭ����
class MyRunner implements Runnable {

	@Override
	public void run() {
		long sum = 0;
		for(int i=1; i<=1000000000; i++) {
			sum += i;
		}
		System.out.println("�հ� : " + sum);
	}
	
}