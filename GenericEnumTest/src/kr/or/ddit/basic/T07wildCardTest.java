package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� �� ���� ���� ���ϵ� ī�� ����
 * @author user
 *
 */
public class T07wildCardTest {
	/**
	 * ȸ������ ���
	 **/
	public void printMemberInfo(List<? extends Member> list) {
		/*
		   extends Ű���带 �̿��� ���� ����(Upper Bounds) ����
		   list ���� ��ü�� �ݵ�� MemberŸ���� ��ü���� ���� �� �� �ִ�.
		 */
		
			for(Member mem : list) {
				System.out.println(mem);
			}
	}
	public void printMemberInfo2(List<? super Member> list) {
		/*
		    super Ű���带 �̿��� ���� ����(Lower Bounds)
		    Member Ÿ���� ������ �̿��Ͽ� List�κ��� ��ü�� ������ �� ����.
		 */
//			for(Member obj : list) { //������ ���� �߻�
//				System.out.println(obj);
//			}
	}
	
	/**
	 * ȸ�� ���� ���
	 * @param list
	 */
	public void registerMemberInfo(List<? extends Member> list) {
		/*
		   	Member Ÿ���� ��ü��� �׻� list�� �߰��� �� ������ ������ �� ����.
		   	(MemberŸ�� �Ǵ� Member�� ����� �� � Ÿ���� �ǹ��ϹǷ� ���� ��ü���� Ÿ����
		   	�������� �ʾҴ�. => ������ ���� �߻�)
		 */
		
//		Member m = new Member("ȫ�浿", 33);
//		list.add(m); //��� �Ұ�...
	}
	
	
	public void registerMemberInfo2(List<? super Member> list) {
		/*
		  	super Ű���带 �̿��� ���� ���� (Lower Bound) ����
		  	list�� MemberŸ���� ��ü�� �����Ѵٴ� ���� ���� �� �� �ִ�.
		  	=> MemberŸ�� �Ǵ� MemberŸ���� ����Ÿ���� ���� ����Ʈ�� �ǹ��ϱ� ������....
		 */
		Member m = new Member("ȫ�浿", 33);
		list.add(m);
	}
	
	public static void main(String[] args) {
		T07wildCardTest wc = new T07wildCardTest();
		
		List<Member> memList = new ArrayList<Member>();
		
		wc.registerMemberInfo2(memList);
		wc.printMemberInfo(memList);
	}
}

class Member {
	private String name;
	private int age;
	
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
	
}