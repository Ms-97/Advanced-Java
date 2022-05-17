package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T01ArrayListTest {
	public static void main(String[] args) {
		List list1 = new ArrayList();
		
		//add()�޼ҵ带 ����ؼ� �����͸��߰��Ѵ�.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(new Integer(111));
		list1.add("k");
		list1.add(true);
		list1.add(12.34);
		
		
		
		//size() => ������ ����
		System.out.println("size => " + list1.size());
		
		//get()���� ������ ��������
		System.out.println("1��° �ڷ� : "+ list1.get(0));
		
		//������ �����ֱ⵵ ����.
		list1.add(0,"zzz");
		System.out.println("list1 => "+list1);
		
		//������ �����ϱ�(set�޼ҵ�)
		String temp = (String) list1.set(0, "yyy");
		System.out.println("temp => " + temp);
		System.out.println("list1 => " + list1);
		
		// �����ϱ⵵ ����.
		list1.remove(0);
		System.out.println("���� �� : "+list1);

		list1.remove("bbb");
		System.out.println("bbb ���� �� : "+list1);
		
		list1.remove(new Integer(111));
		System.out.println("111 ���� �� : "+list1);
		System.out.println("==============================");
		
		
		//���ʸ��� �����Ͽ� ������ �� �ִ�.
		List<String> list2 = new ArrayList<String>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		
		for(int i=0; i<list2.size(); i++) {
			System.out.println(i + " : " + list2.get(i));
		}
		System.out.println("------------------------------");
		
		//contains(�񱳰�ü); => ����Ʈ�� '�񱳰�ü'�� ������ true
		//                       �׷��� ������ false�� ��ȯ��.
		System.out.println(list2.contains("DDD"));
		System.out.println(list2.contains("ZZZ"));
		
		// indexof(�񱳰�ü); => ����Ʈ���� '�񱳰�ü'�� ã�� '�񱳰�ü'��
	 	//                       �����ϴ� index���� ��ȯ�Ѵ�.
		//                       ����Ʈ�� �������������� -1�� ��ȯ�Ѵ�.
		System.out.println("DDD�� index�� : "+ list2.indexOf("DDD"));
		System.out.println("ZZZ�� index�� : "+ list2.indexOf("ZZZ"));
		System.out.println("------------------------------");
		
		// toArray() => ����Ʈ���� �����͵��� �迭�� ��ȯ�Ͽ� ��ȯ�Ѵ�.
		//           => �⺻������ Object�� �迭�� ��ȯ�Ѵ�.
		Object[] strArr = list2.toArray();
		String[] srtArr1 = list2.toArray(new String[0]);
		System.out.println("�迭�� ���� : " + strArr.length);
		
		for(int i=0; i<list2.size(); i++) {
			list2.remove(i);
		}
		System.out.println("list2�� ũ�� : "+ list2.size());
		
	}
}
