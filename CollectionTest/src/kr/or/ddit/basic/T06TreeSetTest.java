package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class T06TreeSetTest {
	public static void main(String[] args) {
		// TreeSet�� �ڵ� ���� ����� �� �ִ�.
		
		TreeSet<String> ts = new TreeSet<String>();
		
		List<String> abcList = new ArrayList<String>();
		
		//���� �빮�ڸ� ���ڿ��� ��ȯ�Ͽ� List�� �����ϱ�
		for(char ch = 'A'; ch<='Z'; ch++) {
			String temp = String.valueOf(ch);
			abcList.add(temp);
		}
		Collections.shuffle(abcList);
		
		System.out.println("abcList �ڷ� :" + abcList);
		
		for(String str : abcList) {
			ts.add(str);
		}
		System.out.println("TreeSet �ڷ� : " +ts);
		
		// TreeSet�� ����� �ڷ� �� Ư���� �ڷẸ�� ���� �ڷḦ ã�Ƽ�
				// SortedSet���� ��ȯ�ϴ� �޼ҵ尡 �ִ�.
				// => headSet(���ذ�) : �⺻������ '���ذ�' ������
				// => headSet(���ذ�, ����) : ������ true�̸� '���ذ�' ����.
				SortedSet<String> ss1 = ts.headSet("K");
				System.out.println("K ���� �ڷ� : " + ss1); // ���ذ� ������.
				System.out.println("K ���� �ڷ�(���ذ� ����) : "
						+ ts.headSet("K", true));
				
				// '���ذ�' ���� ū �ڷḦ ã�� SortedSet���� ��ȯ�ϴ� �޼ҵ�
				// tailSet(���ذ�) : �⺻������ '���ذ�' ����.
				// tailSet(���ذ�, ����) : ������ false�̸� '���ذ�' ������
				SortedSet<String> ss2 = ts.tailSet("K");
				System.out.println("K ���� �ڷ� : " + ss2); // ���ذ� ����
				System.out.println("K ���� �ڷ� :(���ذ� ������) : "
									+ ts.tailSet("K", false));
				
				// subSet(���ذ�1, ���ذ�2) : ���ذ���1~���ذ�2 ������ ���� ������.
				//							('���ذ�1'����, '���ذ�2' ������)
				// subSet(���ذ�1, ����1, ���ذ�2, ����2)
				// => �� ���ذ��� �������� ���θ� �����Ѵ�.(������ true�̸� ����.)
				System.out.println("K(����)���� N(������)���� :"
								+ ts.subSet("K", "N"));	
				System.out.println("K(����)���� N(����)���� :"
						+ ts.subSet("K", true, "N", true));	
				System.out.println("K(������)���� N(������)���� :"
						+ ts.subSet("K", false, "N", false));		
				System.out.println("K(������)���� N(����)���� :"
						+ ts.subSet("K", false, "N", true));		
}
			}
			
