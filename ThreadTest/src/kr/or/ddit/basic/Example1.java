package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

public class Example1 {
	static boolean inputCheck = false;
	public static void main(String[] args) {
		
		Thread th1 = new Start();
		Thread th2 = new CountDown();
		
		th1.start();
		th2.start();
		
		System.out.println("== �� �� ==");
		System.out.println("��ǻ�� : ");
		System.out.println("��� : ");
		System.out.println("��� : ");
		
		}
	}

class Start extends Thread{	
public void showInputDialog(){
	Random random = new Random();
	String[] com = {"����","����","��"};
	int ran = random.nextInt(3);
	String result ="";
	String you = 
			JOptionPane.showInputDialog("���� ���� ���� �Է��ϼ���.");
	
		// �Է��� �Ϸ�Ǹ� inputCheak ������ true�� �����Ѵ�.
		Example1.inputCheck = true;
		if (you.equals(com[ran])) {
			result = "�����ϴ�.";
			}else if (you.equals("����") && com[ran].equals("����") ||
			you.equals("����") && com[ran].equals("��") ||
			you.equals("��") && com[ran].equals("����")) {
			result = "��ǻ�Ͱ� �̰���ϴ�.";
			} else {
			result = "����� �̰���ϴ�.";
			}		
}
class CountDown extends Thread{
	@Override
	public void run() {
		for(int i=5; i>=1; i--) {
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
}
