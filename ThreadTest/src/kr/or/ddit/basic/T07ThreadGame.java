package kr.or.ddit.basic;
import javax.swing.JOptionPane;

/*
	��ǻ�Ϳ� ���� ���� ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

	��ǻ���� ���� ���� ���� ������ �̿��Ͽ� ���ϰ�
	������� ���� ���� ���� showInputDialog()�޼��带 �̿��Ͽ� �Է¹޴´�.

	�Է½ð��� 5�ʷ� �����ϰ� ī��Ʈ �ٿ��� �����Ѵ�.
	5�ʾȿ� �Է��� ������ ������ �������� ó���Ѵ�.

	5�ʾȿ� �Է��� �Ϸ�Ǹ� ���и� ����Ѵ�.

	�������)
		=== �� �� ===
		��ǻ�� : ����
		��  �� : ����
		��  �� : ����� �̰���ϴ�.

*/
public class T07ThreadGame {
	public static boolean inputCheck = false;
	public static String man = ""; // ������� ������������ ����� ����
	

	public static void main(String[] args) {
		
		// ������ �̿��Ͽ� ��ǻ���� ���� ���� ���� ���Ѵ�.
		String[] data = {"����", "����", "��"};
		int index = (int)(Math.random()*3); // 0~2������ ���� �����
		String com = data[index];

		// ī��Ʈ �ٿ� ������ ����
		GameTimer gt = new GameTimer();
		gt.start();

		// ����ڷ� ���� ����, ����, �� �Է� �ޱ�
		UserInput input = new UserInput();
		input.start();
		
		try {
			input.join(); // �Է��� ���������� ��ٸ���.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		// ��� �����ϱ�
		String result = "";
		if( man.equals(com) ){
			result = "�����ϴ�.";
		}else if( (man.equals("����") && com.equals("��"))
				 || (man.equals("����") && com.equals("����"))
				 || (man.equals("��") && com.equals("����")) ){
			result = "����� �̰���ϴ�.";
		}else{
			result = "����� �����ϴ�.";
		}

		// ��� ���
		System.out.println("=== �� �� ===");
		System.out.println("��ǻ�� : " + com);
		System.out.println("��  �� : " + man);
		System.out.println("��  �� : " + result);
	}

}

/**
 * ���� Ÿ�̸�
 */
class GameTimer extends Thread{
	@Override
	public void run() {
		for(int i=5; i>=1; i--){
			if(T07ThreadGame.inputCheck==true){
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�ð��� �ʰ��Ǿ� ����� �����ϴ�.");
		System.exit(0);

	}
}

/**
 * ����� �Է� ó���� ���� ������
 */
class UserInput extends Thread {
	@Override
	public void run() {
		
		String inputData = "";
		
		do{
			inputData = JOptionPane.showInputDialog("����, ����, ���� �Է��ϼ���");
		}while(!inputData.equals("����") && !inputData.equals("����") && !inputData.equals("��"));

		T07ThreadGame.inputCheck = true;  // �Է��� �Ϸ���� �˷��ִ� �������� �����Ѵ�.
		T07ThreadGame.man = inputData;	   //  �Է°� ����
	}
}







