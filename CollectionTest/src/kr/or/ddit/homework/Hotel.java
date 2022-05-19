package kr.or.ddit.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
	private Scanner sc;
	private Map<String, HotelList> HotelMap; 
	
	public Hotel() {
		sc = new Scanner(System.in);
		HotelMap = new HashMap<String, HotelList>();
	}
	

// �޴��� ����ϴ� �޼ҵ�
		public void displayMenu() {
			System.out.println("*******************************************");
			System.out.println("� ������ �Ͻðڽ��ϱ�?");
			System.out.println("1.üũ��  2.üũ�ƿ� 3.���ǻ��� 4.��������");
			System.out.println("*******************************************");
			System.out.print("�޴����� => ");		
		}
		
// ȣ�� ���� ���� �޼ҵ�
		 public void HotelClose() {
			System.out.println("**************************");
			System.out.println("ȣ�� ���� �ݾҽ��ϴ�.");
			System.out.println("**************************\n");
		 }
		 
// ȣ�� ���� ���� �޼ҵ�
		 public void HotelOpen() {
			System.out.println("**************************");
			System.out.println("ȣ�� ���� �������ϴ�.");
			System.out.println("**************************\n");
			
			while(true){
				
				displayMenu();  // �޴� ���
				
				String menu = sc.nextLine();   // �޴� ��ȣ �Է�
				
				if(menu.equals("1")) {
					insert();		         // üũ��
				}else if(menu.equals("2")) {
					checkout();		         // üũ�ƿ�
				}else if(menu.equals("3")) {
					roomStatus();		     // ���ǻ���
				}else if(menu.equals("4")) {
					HotelClose();
					return;
				}else {
					System.out.println("�߸� �Է��߽��ϴ�. �ٽ��Է��ϼ���.\n");
				}
				
			} 
		}
			
// 1.üũ�� �޼ҵ�		
	private void insert() {
		System.out.println("\n����濡 üũ�� �Ͻðڽ��ϱ�?");
		System.out.print("���ȣ �Է� =>");
		String room = sc.nextLine();
		
		System.out.println("������ üũ�� �Ͻðڽ��ϱ�?");
		System.out.print("�̸� �Է� =>");
		String name = sc.nextLine();
		 	
		if(HotelMap.get(room) != null) {
			System.out.println(room + "�濡�� �̹� ����� �ֽ��ϴ�.\n");
			return; // �޼��� ����
		}
		HotelMap.put(room, new HotelList(room, name));
		System.out.println("üũ�� �Ǿ����ϴ�.");	
	}
	
// 2.üũ�ƿ� �޼ҵ�	
	private void checkout() {
		System.out.println("\n������� üũ�ƿ� �Ͻðڽ��ϱ�?");
		System.out.print("���ȣ �Է� =>> ");
		String room = sc.next();
		
		// remove(key) => ���� �����ϸ� ������ value�� ��ȯ,
		//                ���� ���н� null ��ȯ��.
		if(HotelMap.remove(room) == null) {
			System.out.println(room + "�濡�� üũ���� ����� �����ϴ�.\n");
			sc.nextLine();
		}else {
			System.out.println("üũ�ƿ� �Ǿ����ϴ�");
		}
	}	
			
// 3.���ǻ��� �޼ҵ�		
	private void roomStatus() {
			Set<String> keySet = HotelMap.keySet();
			
			if(keySet.size() == 0) {
				System.out.println("�������� ������ �����ϴ�.\n");
			}else {
				Iterator<String> it = keySet.iterator();
				while(it.hasNext()) {
					String room = it.next();
					HotelList p = HotelMap.get(room);
					System.out.println("���ȣ : " + p.getRoom() +
							           ", ������ : " + p.getName());		
				}
			}
		}


	public static void main(String[] args) {
		new Hotel().HotelOpen();
	}
}	

class HotelList{
	private String room;
	private String name;
	
	public HotelList(String room, String name) {
		super();
		this.room = room;
		this.name = name;	
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HotelList [room=" + room + ", name=" + name + "]";
	}
}
