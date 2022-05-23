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
		
		System.out.println("== 결 과 ==");
		System.out.println("컴퓨터 : ");
		System.out.println("당신 : ");
		System.out.println("결과 : ");
		
		}
	}

class Start extends Thread{	
public void showInputDialog(){
	Random random = new Random();
	String[] com = {"가위","바위","보"};
	int ran = random.nextInt(3);
	String result ="";
	String you = 
			JOptionPane.showInputDialog("가위 바위 보를 입력하세요.");
	
		// 입력이 완료되면 inputCheak 변수를 true로 변경한다.
		Example1.inputCheck = true;
		if (you.equals(com[ran])) {
			result = "비겼습니다.";
			}else if (you.equals("가위") && com[ran].equals("바위") ||
			you.equals("바위") && com[ran].equals("보") ||
			you.equals("보") && com[ran].equals("가위")) {
			result = "컴퓨터가 이겼습니다.";
			} else {
			result = "당신이 이겼습니다.";
			}		
}
class CountDown extends Thread{
	@Override
	public void run() {
		for(int i=5; i>=1; i--) {
			// 입력이 완료되었는지 여부를 검사하고 입력이 완료되면
			// run() 를 종료시킨다. 즉 현재 스레드를 종료시킨다.
			if(T06ThreadTest.inputCheck) {
				return; // run()메소드가 종료되면 스레드도 종료된다.
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
