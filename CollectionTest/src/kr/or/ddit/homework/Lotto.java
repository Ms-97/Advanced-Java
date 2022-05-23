package kr.or.ddit.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	/*
	 * 로또를 구매하는 프로그램 작성하기
	 * 
	 * 사용자는 로또를 구매할 때 구매할 금액을 입력하고 입력한 금액에 맞게 로또번호를 출력한다. 
	 * (단, 로또 한장의 금액은 1000원이고
	 * 거스름돈도 계산하여 출력한다.)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean run = true;

		while (run) {
			System.out.println("==========================");
			System.out.println("Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println(" 2. 프로그램 종료");
			System.out.println("==========================");
			System.out.print("메뉴선택 :");
			int menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("Lotto 구입 시작");
				System.out.println("1000원에 로또번호 하나입니다.");
				System.out.print("금액 입력 :");
				int money = sc.nextInt();
				if (money < 1000) {
					System.out.println("금액이 부족합니다.");
				} else {
					int count = money / 1000;
					int remaind = money % 1000;
					System.out.println("행운의 로또번호는 아래와 같습니다.");
					for (int i = 1; i <= count; i++) {
						TreeSet<Integer> ts = new TreeSet<Integer>();

						while (ts.size() < 6) {
							int num = (int) (Math.random() * 45 + 1);
							ts.add(num);
						}
						System.out.println("로또번호"+i+" :" + ts);
						
					}
					System.out.println("\n받은금액은 " + money + "원이고 거스름돈은 " + remaind + "원입니다.\n");
				}

			} else {
				System.out.println("감사합니다");
				run = false;
			}
		}

	}
}