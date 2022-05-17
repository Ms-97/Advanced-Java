package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T03ListSortTest {
/*
 	���İ� ���õ� Interface�� Comparable�� Comparator �̷��� �ΰ����� �ִ�.
 	
 	- ���� ��ü��ü�� ���ı���� �ֱ� ���ؼ��� Comparable�� �����ϰ�
 	  ���� ������ ������ �����ϰ� ���� ���� Comparator�� �����Ͽ� ����ϸ� �ȴ�.
 	  
 	  -Comparable������ compareTo()�� �����ؾ� �ϰ�,
 	   Comparator������ compare()�� �����ؾ� �Ѵ�.
 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("������");
		list.add("ȫ�浿");
		list.add("������");
		list.add("���е�");
		list.add("�̼���");
		
		System.out.println("���� �� : " + list);
	
	/*
	  ������ Collections.sort()�� �̿��Ͽ� �����Ѵ�.
	  ������ �⺻������ '��������'������ �����Ѵ�.
	  
	  ���Ĺ���� �����Ϸ��� ���Ĺ���� �����ϴ� ��ü�� ����
	  Collections.sort()�޼ҵ��� �μ��� �Ѱ��ָ� �ȴ�.
	 */
		Collections.sort(list); //�������� �����ϱ�
		System.out.println("���� �� : " + list);
		
		Collections.shuffle(list); //����
		
		//�ܺ������ڸ� �̿��� ����Ʈ ����
		Collections.sort(list, new Desc());
		System.out.println("�ܺ������� �̿��� ���� �� : "+list);
	}
}

/*
  ���Ĺ���� �����ϴ� calss�� Comparator��� �������̽��� �����ؾ� �Ѵ�.
  �� Comparator�������̽��� compare() �޼ҵ带 �������Ͽ� �����ϸ� �ȴ�.
 */
class Desc implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
/*  compare()�� ��ȯ���� �����ϴ� ���
 	=> ���������� �⺻��.
 	
 	- �������� ������ ���...
 	=> ���� ���� ũ�� ���, ������ , ���� ���� ������ ������ ��ȯ�ϵ���
 	   �����Ѵ�.
 */
		
		return str1.compareTo(str2) * -1;
	}
	
}
