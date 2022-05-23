package kr.or.ddit.basic;

public class T04ThreadTest {
/*
 	1~20�� ������ �հ踦 ���ϴµ� �ɸ� �ð� üũ�� ����
 	��ü �հ踦 ���ϴ� �۾��� �ܵ����� ���� ��(1���� �����带 �̿�)��
 	���� ������� �����ؼ� �۾��� ���� �ð��� Ȯ���� ����.
 */
	public static void main(String[] args) {
		// �ܵ����� ó���� ��...
		SumThread sm = new SumThread(1L, 2000000000L);
		long startTime = System.currentTimeMillis();
		
		sm.start();
		
		try {
			sm.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("�ܵ����� ó���� ���� ó���ð� : "
							+(endTime - startTime)+ "(ms)");
		System.out.println();
		System.out.println();
		
		// ���� �����尡 �����ؼ� ó�� �Ҷ�..
		SumThread[] sumThs = new SumThread[] {
			new SumThread(1L,           500000000L),	
			new SumThread(500000001L,  1000000000L),	
			new SumThread(1000000001L, 1500000000L),	
			new SumThread(1500000001L, 2000000000L),	
		};
		
		startTime = System.currentTimeMillis();
		
		for(Thread th : sumThs) {
			th.start();
		}
		
		for(Thread th : sumThs) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("���� ó��(4���� ������)�� ���� ó���ð� : "
				+ (endTime - startTime) + "(ms)");
		
	}
}

class SumThread extends Thread {
	private long min, max;

	public SumThread(long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
		public void run() {
			long sum = 0L;
			for(long i=min; i<=max; i++) {
				sum += i;
			}
			System.out.println(min + " ~ " + max + "������ �� : " +sum);
		}
}
