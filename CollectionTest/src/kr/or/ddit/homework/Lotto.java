package kr.or.ddit.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	/*
	 * �ζǸ� �����ϴ� ���α׷� �ۼ��ϱ�
	 * 
	 * ����ڴ� �ζǸ� ������ �� ������ �ݾ��� �Է��ϰ� �Է��� �ݾ׿� �°� �ζǹ�ȣ�� ����Ѵ�. 
	 * (��, �ζ� ������ �ݾ��� 1000���̰�
	 * �Ž������� ����Ͽ� ����Ѵ�.)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean run = true;

		while (run) {
			System.out.println("==========================");
			System.out.println("Lotto ���α׷�");
			System.out.println("--------------------------");
			System.out.println("1. Lotto ����");
			System.out.println(" 2. ���α׷� ����");
			System.out.println("==========================");
			System.out.print("�޴����� :");
			int menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("Lotto ���� ����");
				System.out.println("1000���� �ζǹ�ȣ �ϳ��Դϴ�.");
				System.out.print("�ݾ� �Է� :");
				int money = sc.nextInt();
				if (money < 1000) {
					System.out.println("�ݾ��� �����մϴ�.");
				} else {
					int count = money / 1000;
					int remaind = money % 1000;
					System.out.println("����� �ζǹ�ȣ�� �Ʒ��� �����ϴ�.");
					for (int i = 1; i <= count; i++) {
						TreeSet<Integer> ts = new TreeSet<Integer>();

						while (ts.size() < 6) {
							int num = (int) (Math.random() * 45 + 1);
							ts.add(num);
						}
						System.out.println("�ζǹ�ȣ"+i+" :" + ts);
						
					}
					System.out.println("\n�����ݾ��� " + money + "���̰� �Ž������� " + remaind + "���Դϴ�.\n");
				}

			} else {
				System.out.println("�����մϴ�");
				run = false;
			}
		}

	}
}
