package kr.or.ddit.basic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
����) �̸�, �ּ�, ��ȭ��ȣ �Ӽ��� ���� PhoneŬ������ �����, �� PhoneŬ������ �̿��Ͽ� 
	  ��ȭ��ȣ ������ �����ϴ� ���α׷��� �ϼ��Ͻÿ�.
	  �� ���α׷����� ��ȭ��ȣ�� ���, ����, ����, �˻�, ��ü����ϴ� ����� �ִ�.
	  
	  ��ü�� ��ȭ��ȣ ������ Map�� �̿��Ͽ� �����Ѵ�.
	  (key�� '�̸�'���� �ϰ� value�� 'PhoneŬ������ �ν��Ͻ�'�� �Ѵ�.)


���࿹��)
===============================================
   ��ȭ��ȣ ���� ���α׷�(���Ϸ� ������� ����)
===============================================

  �޴��� �����ϼ���.
  1. ��ȭ��ȣ ���
  2. ��ȭ��ȣ ����
  3. ��ȭ��ȣ ����
  4. ��ȭ��ȣ �˻�
  5. ��ȭ��ȣ ��ü ���
  0. ���α׷� ����
  ��ȣ�Է� >> 1  <-- ���� �Է�
  
  ���Ӱ� ����� ��ȭ��ȣ ������ �Է��ϼ���.
  �̸� >> ȫ�浿  <-- ���� �Է�
  ��ȭ��ȣ >> 010-1234-5678  <-- ���� �Է�
  �ּ� >> ������ �߱� ���ﵿ 111  <-- ���� �Է�
  
  �޴��� �����ϼ���.
  1. ��ȭ��ȣ ���
  2. ��ȭ��ȣ ����
  3. ��ȭ��ȣ ����
  4. ��ȭ��ȣ �˻�
  5. ��ȭ��ȣ ��ü ���
  0. ���α׷� ����
  ��ȣ�Է� >> 5  <-- ���� �Է�
  
  =======================================
  ��ȣ   �̸�       ��ȭ��ȣ         �ּ�
  =======================================
   1    ȫ�浿   010-1234-5678    ������
   ~~~~~
   
  =======================================
  ��¿Ϸ�...
  
  �޴��� �����ϼ���.
  1. ��ȭ��ȣ ���
  2. ��ȭ��ȣ ����
  3. ��ȭ��ȣ ����
  4. ��ȭ��ȣ �˻�
  5. ��ȭ��ȣ ��ü ���
  0. ���α׷� ����
  ��ȣ�Է� >> 0  <-- ���� �Է�
  
  ���α׷��� �����մϴ�...
  
*/
public class T09PhoneBookTest {
	private Scanner scan;
	private Map<String, Phone> phoneBookMap; 
	
	public T09PhoneBookTest() {
		scan = new Scanner(System.in);
		phoneBookMap = new HashMap<String, Phone>();
	}
	
	// �޴��� ����ϴ� �޼���
	public void displayMenu(){
		System.out.println();
		System.out.println("�޴��� �����ϼ���.");
		System.out.println(" 1. ��ȭ��ȣ ���");
		System.out.println(" 2. ��ȭ��ȣ ����");
		System.out.println(" 3. ��ȭ��ȣ ����");
		System.out.println(" 4. ��ȭ��ȣ �˻�");
		System.out.println(" 5. ��ȭ��ȣ ��ü ���");
		System.out.println(" 0. ���α׷� ����");
		System.out.print(" ��ȣ�Է� >> ");		
	}
	
	// ���α׷��� �����ϴ� �޼���
	public void phoneBookStart(){
		System.out.println("===============================================");
		System.out.println("   ��ȭ��ȣ ���� ���α׷�(���Ϸ� ������� ����)");
		System.out.println("===============================================");
		
		while(true){
			
			displayMenu();  // �޴� ���
			
			int menuNum = scan.nextInt();   // �޴� ��ȣ �Է�
			
			switch(menuNum){
				case 1 : insert();		// ���
					break;
				case 2 : update();		// ����
					break;
				case 3 : delete();		// ����
					break;
				case 4 : search();		// �˻�
					break;
				case 5 : displayAll();	// ��ü ���
					break;
				case 0 :
					System.out.println("���α׷��� �����մϴ�...");
					return;
				default :
					System.out.println("�߸� �Է��߽��ϴ�. �ٽ��Է��ϼ���.");
			} // switch��
		} // while��
	}
	
	/**
	 * �̸��� �̿��� ��ȭ��ȣ ������ �˻��ϱ� ���� �޼ҵ�
	 */
	private void search() {
		System.out.println();
		System.out.println("�˻��� ��ȭ��ȣ ������ �Է��ϼ���.");
		System.out.print("�� �� >> ");
		
		String name = scan.next();
		
		Phone p = phoneBookMap.get(name);
		
		if(p == null) {
			System.out.println(name + "���� ��ȭ��ȣ ������ �����ϴ�.");
		}else {
			System.out.println(name + "���� ��ȭ��ȣ ����");
			System.out.println("�̸� : " + p.getName());
			System.out.println("��ȭ : " + p.getTel());
			System.out.println("�ּ� : " + p.getAddr());
		}
		System.out.println("�˻� �۾� �Ϸ�...");
		
	}

	/**
	 * ȸ�������� �����ϱ� ���� �޼ҵ�
	 */
	private void delete() {
		System.out.println();
		System.out.println("������ ��ȭ��ȣ ������ �Է��ϼ���.");
		System.out.print("�� �� >> ");
		
		String name = scan.next();
		
		// remove(key) => ���� �����ϸ� ������ value�� ��ȯ,
		//                ���� ���н� null ��ȯ��.
		if(phoneBookMap.remove(name) == null) {
			System.out.println(name + "���� ��ϵ� ����� �ƴմϴ�.");
		}else {
			System.out.println(name + "�� ������ �����߽��ϴ�");
		}
		System.out.println("���� �۾� �Ϸ�...");
	}

	/**
	 * ȸ�������� �����ϱ� ���� �޼ҵ�
	 */
	private void update() {
		System.out.println();
		System.out.println("������ ��ȭ��ȣ ������ �Է��ϼ���.");
		System.out.print("�� �� >> ");
		
		String name = scan.next();
		
		// �̹� ��ϵ� ������� �˻�
		// get()�� �̿��Ͽ� ���� �����ö�  �ڷᰡ ������ null�� ��ȯ��.
		if(phoneBookMap.get(name) == null) {
			System.out.println(name + "���� �̹� ��ϵ� ����� �ƴմϴ�.");
			return; // �޼��� ����
		}
		
		System.out.print("��ȭ��ȣ >> ");
		String tel = scan.next();
		
		System.out.print("�� �� >> ");
		scan.nextLine(); // �Է¹��ۿ� �����ִ� ����Ű���� �о���� ���ؼ�...
		                 // next() ȣ�� �� nextLine() ȣ��� Ȥ�� ����������
		                 // �� ���Ͱ��� �о���� ������ ������.
		String addr = scan.nextLine();
		
		phoneBookMap.put(name, new Phone(name, tel, addr));
		System.out.println(name + "�� ���� �Ϸ�...");	
		
	}

	/**
	 * ��ü �ڷḦ ����ϴ� �޼ҵ�
	 */
	private void displayAll() {
		Set<String> keySet = phoneBookMap.keySet();
		
		System.out.println("==========================================");
		System.out.println(" ��ȣ\t�̸�\t��ȭ��ȣ\t�ּ�");
		System.out.println("==========================================");
		
		if(keySet.size() == 0) {
			System.out.println("��ϵ� ��ȭ��ȣ ������ �����ϴ�.");
		}else {
			Iterator<String> it = keySet.iterator();
			int cnt = 0;
			while(it.hasNext()) {
				cnt++;
				String name = it.next();
				Phone p = phoneBookMap.get(name);
				System.out.println(" " + cnt 
						 			+ "\t" + p.getName()
						 			+ "\t" + p.getTel()
						 			+ "\t" + p.getAddr());		
			}
		}
		
	}

	/**
	 * ���ο� ��ȭ��ȣ ������ ����ϴ� �޼���
	 * (�̹� ��ϵ� ����� ��ϵ��� �ʴ´�.)
	 */
	private void insert() {
		System.out.println();
		System.out.println("���Ӱ� ����� ��ȭ��ȣ ������ �Է��ϼ���.");
		System.out.print("�� �� >> ");
		
		String name = scan.next();
		
		// �̹� ��ϵ� ������� �˻�
		// get()�� �̿��Ͽ� ���� �����ö�  �ڷᰡ ������ null�� ��ȯ��.
		if(phoneBookMap.get(name) != null) {
			System.out.println(name + "���� �̹� ��ϵ� ����Դϴ�.");
			return; // �޼��� ����
		}
		
		System.out.print("��ȭ��ȣ >> ");
		String tel = scan.next();
		
		System.out.print("�� �� >> ");
		scan.nextLine(); // �Է¹��ۿ� �����ִ� ����Ű���� �о���� ���ؼ�...
		                 // next() ȣ�� �� nextLine() ȣ��� Ȥ�� ����������
		                 // �� ���Ͱ��� �о���� ������ ������.
		String addr = scan.nextLine();
		
		phoneBookMap.put(name, new Phone(name, tel, addr));
		System.out.println(name + "�� ��� �Ϸ�...");	
	}

	public static void main(String[] args) {
		new T09PhoneBookTest().phoneBookStart();
	}
}

/**
 * ��ȭ��ȣ ������ �����ϱ� ���� VO Ŭ����
 * @author sem
 *
 */
class Phone {
	private String name;
	private String tel;
	private String addr;
	
	public Phone(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
}



