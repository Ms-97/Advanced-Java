package kr.or.ddit.basic;

public class T08EnumTest {
/*
    ������ => ��������� �����ϴ� �پ���
    
    static final int A = 0;
    static final int B = 1;
    static final int C = 2;
    static final int D = 3;
    
    enum Data {A, B, C, D};
    
    ������ �����ϴ� ���
    enum ������ �̸� {�����1, �����2, ..., �����n };
 */
	// City ������ ��ü ���� (�⺻���� �̿��ϴ� ������)
	public enum City {����, �λ�, �뱸, ����, ����};
	
	public enum HomeTown {�λ�, ����, ����};
	
	// �����Ͱ��� ���Ƿ� ������ ������ ��ü ����
	// �����Ͱ��� ���� �� ��쿡�� �����ڸ� ���� ��ȣ���� ���� ������ ����ǵ���
	// �ؾ� �Ѵ�.
	public enum Season {
		��("3������ 5������"), ����("6������ 8������"),
		����("9������ 11������"), �ܿ�("12������ 2������");
		
		// ��ȣ���� ���� ������ ���� ����
		private String str;
		
		// ������ �����(�������� �����ڴ� �����ڰ� ���������� 'private' �̴�.)
		Season(String data){
			this.str = data;
		}
		
		//���� ��ȯ�ϴ�  �޼ҵ� �ۼ�
		public String getStr() {
			return str;
		}
	}

	public static void main(String[] args) {
		/*
		 	���������� ���Ǵ� �޼ҵ�
		 	
		 	1. name() => ������ ����� �̸��� ���ڿ��� ��ȯ�Ѵ�.
		 	2. ordinal() => ������ ����� ���ǵ� �������� ��ȯ�Ѵ�.(0���� ����)
		 	3. valueOf("����������̸�") => ������ ���������� '����������̸�'��
		 									��ġ�ϴ� ������ ����� ��ȯ�Ѵ�.
		 */
		
		City myCity1;
		City myCity2;
		
		// ������ ��ü������ �� �����ϱ�
		myCity1 = City.����;
		myCity2 = City.valueOf("����");
		
		System.out.println("myCity1 : " + myCity1.name());
		System.out.println("myCity1�� ordinal : " + myCity1.ordinal());
		System.out.println();
		
		System.out.println("myCity2 : " + myCity2.name());
		System.out.println("myCity2�� ordinal : " + myCity2.ordinal());
		System.out.println("=============================================");
		
		Season ss = Season.valueOf("����");
		System.out.println("name => " + ss.name());
		System.out.println("ordinal => " + ss.ordinal());
		System.out.println("get�޼ҵ� => " + ss.getStr());
		System.out.println("---------------------------------------------");
		
		// �������̸�.values() => �����͸� �迭�� �����´�.
		Season[] enumArr = Season.values();
		for(Season s : enumArr) {
			System.out.println(s.name() + " : " + s.getStr());
		}
		System.out.println();
		
		for(City city : City.values()) {
			System.out.println(city +  " : " + city.ordinal());
		}
		
		City city = City.�뱸;
		
		System.out.println(city == City.����);
		System.out.println(city == City.�뱸);
		
		//System.out.println(HomeTown.���� == City.����);
		
		System.out.println("�뱸 => " + city.compareTo(city.�뱸));
		System.out.println("���� => " + city.compareTo(city.����));
		System.out.println("���� => " + city.compareTo(city.����));
	}
	
}
