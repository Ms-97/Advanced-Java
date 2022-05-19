package kr.or.ddit.basic;

public class T01ArgsTest {
/*
    ������ �μ� => �żҵ��� �Ű������� ������ ����� ������ �ٸ� �� ����Ѵ�.
    
     - ������ �μ��� �żҵ� �ȿ����� �迭�� ó���ȴ�.
     - ������ �μ��� �Ѱ��� �ڷ����� ����� �� �ִ�.
*/
	// �迭�� �̿��� �żҵ�
	// �Ű������� ���� �������� �հ踦 ���ϴ� �żҵ�
	// (�� �������� ������ ��Ȳ�� ���� �ٸ���)
	public int sumArr(int[] data) {
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	// ������ �μ��� �̿��� �żҵ�
	public int sumArg(int...data) {
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	// ������ �μ��� �Ϲ����� �μ��� ���� ����� ��쿡�� 
	// ������ �μ��� ���� ���ʿ� ��ġ�ؾ� �Ѵ�.
	public String sumArg2(String name, int...data) {
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return name + "�� ���� : " + sum;
	}
	
	public static void main(String[] args) {
		
		T01ArgsTest at = new T01ArgsTest();
		
		int[] nums = {100, 200, 300};
		System.out.println(at.sumArr(nums));
		System.out.println(at.sumArr(new int[] {1,2,3,4,5}));
		System.out.println();
		
		System.out.println(at.sumArg(100, 200, 300));
		System.out.println(at.sumArg(1,2,3,4,5));
		System.out.println();
		
		System.out.println(at.sumArg2("ȫ�浿", 1,2,3,4,5,6,7,8,9));
	
		
		
		
		
	}
	
}
