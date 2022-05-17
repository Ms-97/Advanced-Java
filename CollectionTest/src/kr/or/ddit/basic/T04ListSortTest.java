package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public final class T04ListSortTest {
	public static void main(String[] args) {
		List<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "ȫ�浿", "010-1111-1111"));
		memList.add(new Member(5, "���е�", "010-2222-1111"));
		memList.add(new Member(9, "������", "010-3333-1111"));
		memList.add(new Member(3, "�̼���", "010-4444-1111"));
		memList.add(new Member(6, "������", "010-5555-1111"));
		memList.add(new Member(2, "������", "010-6666-1111"));
		
		System.out.println("���� ��");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("---------------------------");
		Collections.sort(memList);///�����ϱ�
		
		System.out.println("���� ��(�̸��� ��������) :");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("---------------------------");
		
		Collections.sort(memList, new SortNumDesc());
		
		System.out.println("���� ��(��ȣ�� ��������) :");
		for(Member mem : memList) {
			System.out.println(mem);
		}
	}
}
/*
 * �ܺ� ������ Ŭ����
 * (Member�� ��ȣ (Num)�� ������������ �����ϱ�)
 */
class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
		/*
		if(mem1.getNum() > mem2.getNum()) {
			return -1;
		}else if(mem1.getNum() == mem2.getNum()) {
			return 0;
		}else {
			return 1;
		}
		*/
		
		return new Integer(mem1.getNum())
				 .compareTo(mem2.getNum()) * -1;
		// return Integer.compare(mem1.getNum(), mem2.getNum())*-1;
	}
	
}

/**
 * 
 * ȸ���� ������ ������ Ŭ����
 * (ȸ���̸����������� �������������� �� �� �ִ� Ŭ���� �����ϱ�)
 *
 */
class Member implements Comparable<Member>{

	private int num; //��ȣ
	private String name; //�̸�
	private String tel; //��ȭ��ȣ
	
	

	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	@Override
	public int compareTo(Member mem) {
		
		return this.getName().compareTo(mem.getName());
	}
	
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	
}