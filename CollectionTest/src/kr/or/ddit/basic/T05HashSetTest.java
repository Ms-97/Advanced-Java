package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.print.DocFlavor.INPUT_STREAM;

public class T05HashSetTest {
/*
 *   -List�� Set�� ������
 *   
 *   1. List
 *   - �Է��� �������� ����(�ε���)�� �ִ�.
 *   - �ߺ��Ǵ� �����͸� ������ �� �ִ�.
 *   
 *   2. Set
 *    - �Է��� �������� ����(�ε���) ������ �������� �ʴ´�.
 *    - �ߺ��Ǵ� �����͸� ������ �� ����.
 */
	public static void main(String[] args) {
		Set hs1 = new HashSet();
		
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set ������ : " + hs1);
		System.out.println();
		
		//Set�� �̹� �����ϴ� �����͸� �߰��ϸ� false�� �ݺ��ϰ�,
		//�����ʹ� �߰����� �ʴ´�.
		
		boolean isAdded = hs1.add("FF");
		System.out.println("�ߺ����� ���� �� : "+ isAdded);
		System.out.println("Set ������ "+hs1);
		System.out.println();
		
		isAdded = hs1.add("CC");
		System.out.println("�ߺ��� �� : "+ isAdded);
		System.out.println("Set ������ "+hs1);
		System.out.println();
		
		/*
		 * Set�� �����͸� �����Ϸ��� �����ϴ� ����� ���� ���� ������
		 * �ش� �ڷḦ ���� �� �� ���ο� �����͸� ������ ��� �Ѵ�.
		 * 
		 * 	�����ϴ� �޼ҵ�
		 * 	1) clear() => Set ������ ��ü ����
		 *  2) remove(�������ڷ�) => �ش��ڷ� ����
		 * 
		 //'FF'�� 'EE'�� �����ϱ�
		  */
		   hs1.remove("FF");
		   System.out.println("���� �� set ������: " +hs1);
		   System.out.println();
		   
		   hs1.remove("EE");
		   System.out.println("���� �� set ������: " +hs1);
		   System.out.println();
		   
		   //hs1.clear(); // ��ü�ڷ� ����
		   //System.out.println("clear �� Set ������ :" + hs1);
		  
		   System.out.println("Set�� �ڷ� ����: " +hs1.size());
		   System.out.println();
		   
		   
		   // Set�� �������� ����(�ε���)�� ���� ������ Listó�� �ε����� �����͸�
		   // �ϳ��� �ҷ��� �� ����. �׷��� �����͸� �ϳ��� �ҷ����� ����
		   // Iterator ��ü�� �̿��Ѵ�.
		   Iterator it = hs1.iterator();
		   
		   // �������� ������ŭ �ݺ��ϱ�
		   // hasNext() => ������ ���� ��ġ�� �����Ͱ� ������ true,
		   //				������ false�� ��ȯ��.
		   while(it.hasNext()) {
			   // next() => �����͸� ���� �ڷ� ��ġ�� �̵��ϰ�, �̵��� ��ġ��
			  //     		�ڷḦ ��ȯ�Ѵ�.
			   System.out.println(it.next());
		   }
		 
		   //1~100������ �ߺ����� �ʴ� ���� 5�� �����
		   Set<Integer> intRnd = new HashSet<Integer>();
		   
		   while(intRnd.size() < 5) {
			   int num = (int) (Math.random() * 100 + 1);
			   intRnd.add(num);
		   }
		   
		   System.out.println("������� ������ : " + intRnd);
		   
		   //Collection������ ��ü���� ���δٸ� �ڷᱸ���� ���� �����ؼ�
		   //����� �� �ִ�. �ٸ� ������ ��ü�� ������ �� �����ڿ� ������ �����͸� 
		   // �־��ָ� �ȴ�.
		   List<Integer> intRandList =
				   		new ArrayList<Integer>(intRnd);
		   
		   System.out.println("List�� �ڷ����...");
		   for(Integer num : intRandList) {
			   System.out.println(num + " ");
		   }
	}
}

