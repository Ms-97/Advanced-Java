package kr.or.ddit.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



import kr.or.ddit.util.JDBCUtil3;

public class Hotel {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Scanner sc;
	
	public Hotel() {
		sc = new Scanner(System.in);
	}
	

// 메뉴를 출력하는 메소드
		public void displayMenu() {
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("*******************************************");
			System.out.print("메뉴선택 => ");		
		}
		
// 호텔 문을 닫는 메소드
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
		String room = "";
		String name = "";
		boolean isExist = false; //중복 체크용
		
		do {
			System.out.println("\n어느방에 체크인 하시겠습니까?");
			System.out.print("방번호 입력 =>");
			room = sc.nextLine();
			
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.print("이름 입력 =>");
			name = sc.nextLine();
			isExist = checkMember(room); 
			
			if(isExist) {
				System.out.println(room + "방에는 이미 사람이 있습니다.\n");
				return;
			}
		}while(isExist);
		 	
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = "INSERT INTO hotel_mng " 
					+ " ( room_num, guest_name ) "
					+ " VALUES (?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, room);
			pstmt.setString(2, name);
			
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("체크인 되었습니다.");
			}else {
				System.out.println("체크인 실패했습니다.");
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
	}
	
// 2.체크아웃 메소드	
	private void checkout() {
		System.out.println("\n어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 =>> ");
		String room = sc.nextLine();
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = "delete from hotel_mng where room_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, room);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("체크아웃 되었습니다.");
			}else {
				System.out.println(room + "방에는 체크인한 사람이 없습니다.");
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
	}	
			
// 3.객실상태 메소드		
	private void roomStatus() {
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = "select * from hotel_mng";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String room = rs.getNString("room_num");
				String name = rs.getNString("guest_name");
				
				System.out.println("방번호 : "+ room +", 투숙객 : "+name);
			}
			
		} catch (SQLException ex) {
			System.out.println("투숙중인 정보가 없습니다.");
			ex.printStackTrace();
		}finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}	
	}


	public static void main(String[] args) {
		
		new Hotel().HotelOpen();
	}
	
	
	/**
	 * 회원이 존재하는지 확인하기 위한 메소드
	 * @param room 회원 ID
	 * @return 존재하면 true, 존재하지 않으면 false 반환함.
	 */
	private boolean checkMember(String room) {
		
		boolean isExist = false;
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = "select count(*) as cnt "
					+ " from hotel_mng where room_num = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, room);
			
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
			if(cnt > 0) {
				isExist = true;
			}else {
				isExist = false;
			}
			
					
		} catch (SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		
		return isExist;
	}

	

}	


