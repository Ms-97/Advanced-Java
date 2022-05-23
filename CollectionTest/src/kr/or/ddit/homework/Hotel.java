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
	

// 메뉴를 출력하는 메소드
		public void displayMenu() {
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("*******************************************");
			System.out.print("메뉴선택 => ");		
		}
		
// 호텔 문을 여는 메소드
		 public void HotelClose() {
			System.out.println("**************************");
			System.out.println("호텔 문을 닫았습니다.");
			System.out.println("**************************\n");
		 }
		 
// 호텔 문을 여는 메소드
		 public void HotelOpen() {
			System.out.println("**************************");
			System.out.println("호텔 문을 열었습니다.");
			System.out.println("**************************\n");
			
			while(true){
				
				displayMenu();  // 메뉴 출력
				
				String menu = sc.nextLine();   // 메뉴 번호 입력
				
				if(menu.equals("1")) {
					insert();		         // 체크인
				}else if(menu.equals("2")) {
					checkout();		         // 체크아웃
				}else if(menu.equals("3")) {
					roomStatus();		     // 객실상태
				}else if(menu.equals("4")) {
					HotelClose();
					return;
				}else {
					System.out.println("잘못 입력했습니다. 다시입력하세요.\n");
				}
				
			} 
		}
			
// 1.체크인 메소드		
	private void insert() {
		System.out.println("\n어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 =>");
		String room = sc.nextLine();
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 =>");
		String name = sc.nextLine();
		 	
		if(HotelMap.get(room) != null) {
			System.out.println(room + "방에는 이미 사람이 있습니다.\n");
			return; // 메서드 종료
		}
		HotelMap.put(room, new HotelList(room, name));
		System.out.println("체크인 되었습니다.");	
	}
	
// 2.체크아웃 메소드	
	private void checkout() {
		System.out.println("\n어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 =>> ");
		String room = sc.nextLine();
		
		// remove(key) => 삭제 성공하면 삭제된 value값 반환,
		//                삭제 실패시 null 반환함.
		if(HotelMap.remove(room) == null) {
			System.out.println(room + "방에는 체크인한 사람이 없습니다.\n");
		}else {
			System.out.println("체크아웃 되었습니다");
		}
	}	
			
// 3.객실상태 메소드		
	private void roomStatus() {
			Set<String> keySet = HotelMap.keySet();
			
			if(keySet.size() == 0) {
				System.out.println("투숙중인 정보가 없습니다.\n");
			}else {
				Iterator<String> it = keySet.iterator();
				while(it.hasNext()) {
					String room = it.next();
					HotelList p = HotelMap.get(room);
					System.out.println("방번호 : " + p.getRoom() +
							           ", 투숙객 : " + p.getName());		
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