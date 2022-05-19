package kr.or.ddit.basic;

import java.util.Map;

/*
	���ʸ� Ŭ���� ����� ���
	
	����)
	 class Ŭ������<���ʸ�Ÿ�Ա���> {
	  	���ʸ�Ÿ�Ա��� ������; // ���� ���� ���ʸ��� ����� ���
	  	 	...
	  	 
	  	 ���ʸ�Ÿ�Ա��� �޼ҵ��() { // ��ȯ���� �ִ� �޼ҵ忡�� ���
	  	 	...
	  	 
	  	 	return ��;
	  	 }
	  	 ...
	  }
	  
	-- ���ʸ�Ÿ�Ա��� --
	T => Type
	K => Key
	V => Value
	E => Element  	
*/

class NonGenericClass{
	private Object val;

	
	public Object getVal() {
		return val;
	}

	
	public void setVal(Object val) {
		this.val = val;
	}
}

class MyGeneric<T>{
	private T val;

	
	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
}

public class T02GenericTest {
	public static void main(String[] args) {
		
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setVal("�����ٶ�");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);
		
		String rtnVal1 = (String) ng1.getVal();
		System.out.println("���ڿ� ��ȯ�� rtnNg1 => "+ rtnVal1);
		
		Integer irtnVal2 = (Integer) ng2.getVal();
		System.out.println("���� ��ȯ�� irtnVal2 => " + irtnVal2);
		System.out.println();
		
		MyGeneric<String> mg1 = new MyGeneric<String>();
		MyGeneric<Integer> mg2 = new MyGeneric<Integer>();
		
		mg1.setVal("�츮����");
		mg2.setVal(500);
		
		rtnVal1 = mg1.getVal();
		irtnVal2 = mg2.getVal();
		
		System.out.println("���ʸ� ���ڿ� ��ȯ�� : " + rtnVal1);
		System.out.println("���ʸ� ������ ��ȯ�� : " + irtnVal2);
		}
}
