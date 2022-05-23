package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class T06ThreadTest {
	// �Է� ���θ� Ȯ���ϱ� ���� ���� ����
	// ��� �����忡�� �������� ����� ����
	static boolean inputCheck = false;

	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new CountDown();
		
		th1.start();
		th2.start();
	}
	
}
// ����� �Է��� ó���ϴ� ������ Ŭ����
class DataInput extends Thread{
	@Override
	public void run() {
		String str = 
			JOptionPane.showInputDialog("�ƹ��ų� �Է��ϼ���.");
		
		// �Է��� �Ϸ�Ǹ� inputCheak ������ true�� �����Ѵ�.
		T06ThreadTest.inputCheck = true;
		
			System.out.println("�Է��� ���� : " + str + "�Դϴ�.");
	}
}
// ī��Ʈ�ٿ��� ó���ϴ� ������ Ŭ����
class CountDown extends Thread{
	@Override
	public void run() {
		for(int i=10; i>=1; i--) {
			// �Է��� �Ϸ�Ǿ����� ���θ� �˻��ϰ� �Է��� �Ϸ�Ǹ�
			// run() �� �����Ų��. �� ���� �����带 �����Ų��.
			if(T06ThreadTest.inputCheck) {
				return; // run()�޼ҵ尡 ����Ǹ� �����嵵 ����ȴ�.
			}
			
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}