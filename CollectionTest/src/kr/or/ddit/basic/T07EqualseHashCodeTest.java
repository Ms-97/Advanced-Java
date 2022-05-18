package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class T07EqualseHashCodeTest {
/*
 *  �ؽ��Լ�(hash function)�� ������ ������ �����͸� ������ ������ �����ͷ�
 *  �����ϴ� �Լ��̴�. �ؽ��Լ��� ���� ������� ���� �ؽð�, �ؽ��ڵ�, �ؽ�üũ��
 *  �Ǵ� �����ϰ� �ؽö�� �Ѵ�.
 *  
 *   HashSet, HashMap, Hashtable�� ���� �÷��� ��ü���� ����� ���
 *   ��ü�� ���� �������� ���ϱ� ���� equals()�޼ҵ�� hashCode()�޼ҵ带
 *   ȣ���Ѵ�. �׷��� ��ü�� ���� ������ ���θ� �����Ϸ��� �� �޼ҵ� ������ �ؾ��Ѵ�.
 *   ��ü�� ������ ���δ� �����͸� �߰��� �� �˻��Ѵ�.
 *   
 *    - equals()�޼ҵ�� �� ��ü�� ����(��)�� ������ ���ϱ� ���� �޼ҵ� �̰�,
 *      hashCode()�޼ҵ�� ��ü�� ���� �ؽ��ڵ尪�� ��ȯ�ϴ� �޼ҵ��.
 *      
 *    - equals()�޼ҵ�� hashCode()�޼ҵ忡 ���õ� ��Ģ
 *   1. �� ��ü�� ������ �ݵ�� ���� hashcode�� ������ �Ѵ�.
 *   2. �� ��ü�� ������ equals()�� ȣ�������� true�� ��ȯ�ؾ� �Ѵ�.
 *      ��, ��ü a, b�� ���ٸ� a.equals(b)�� b.equasl(a) �Ѵ� true�̾���Ѵ�.
 *   3. �� ��ü�� hashcode�� ���ٰ� �ؼ� �� ��ü�� �ݵ�� ���� ��ü�� �ƴϴ�.
 *      ������, �� ��ü�� ������ �ݵ�� hashCode�� ���ƾ� �Ѵ�. 
 *   4. equals()�޼ҵ带 override�ϸ� �ݵ�� hashCode()�� override �ؾ� �Ѵ�.
 *   5. hashCode()�� �⺻������ Heap�޸𸮿� �ִ� �� ��ü�� ���� �޸� �ּ� ����
 *      ������ ������� �� �������� ��ȯ�Ѵ�.
 *      �׷��Ƿ�, Ŭ�������� hashCode() �޼ҵ带 override���� ������ ����� ��
 *      ��ü�� ���� ������ ���ֵ� �� ����.   
 */
	public static void main(String[] args) {
		
		/*
		 * //1. Object obj = new Object();
		 * 
		 * System.out.println(obj.hashCode() + " : " + obj.hashCode());
		 * 
		 * //2. String str1 = "�ȳ��ϼ���."; String str2 = "�ȳ��ϼ���.";
		 * System.out.println(str1.equals(str2) + " : " + str2.equals(str1));
		 * 
		 * //3. System.out.println(str1.hashCode() + " : " + str2.hashCode());
		 * 
		 * System.out.println("Aa".hashCode() + " : " + "BB".hashCode());
		 */
	
	
	Person p1 = new Person(1, "ȫ�浿");
	Person p2 = new Person(1, "ȫ�浿");
	Person p3 = new Person(1, "�̼���");
	
	 System.out.println("p1.equals(p2) : " + p1.equals(p2));
	 System.out.println("p1 == p2 : "  + (p1 == p2));
	 
	 Set<Person> set = new HashSet<Person>();
	 
	 set.add(p1);
	 set.add(p2);
	 
	 System.out.println("p1, p2 ��� �� ������ : ");
	 for(Person p : set) {
		 System.out.println(p.getId() + " : " + p.getName());
	 }
	 System.out.println("add(p3) �������� : " + set.add(p3));
	
	 System.out.println("add(p3) �� ������ : ");
		for(Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}
		
		System.out.println("remove(p2) �������� : " 
							+ set.remove(p2));
		
		System.out.println("remove(p2) �� ������ : ");
		for(Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}
		
	} 
}

class Person {
	private int id;
	private String name;
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name; 
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		return id == other.id && Objects.equals(name, other.name);
	}
	
	
}