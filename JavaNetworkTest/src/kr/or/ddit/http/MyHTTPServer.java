package kr.or.ddit.http;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 간단한 웹서버 예제
 * @author user
 *
 */
public class MyHTTPServer {
	private final int port = 80;
	private final String encoding = "UTF-8";
	
	// 시작 메소드
	public void start() {
		System.out.println("HTTP 서버가 시작되었습니다.");
		
		 try(ServerSocket server = new ServerSocket(this.port)){
			
			 while(true) {
				 
				 try {
					 Socket socket = server.accept();
					 
					 HttpHanler hanler = new HttpHanler(socket);
					 
					 new Thread(hanler).start(); //요청 처리 시작
					 
				 }catch(IOException ex) {
					 ex.printStackTrace();
				 }
			 }
					 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * HTTP 요청 처리를 위한 Runnable 클래스
	 */
	private class HttpHanler implements Runnable{
		private final Socket socket;
		
		public HttpHanler(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			OutputStream out = null;
			BufferedReader br = null;
			
			try {
				out = new BufferedOutputStream(socket.getOutputStream());
				br = new BufferedReader(
						new InputStreamReader(
									socket.getInputStream()));
				
				// 요청헤더 정보 파싱하기
				StringBuilder sb = new StringBuilder();
				while(true) {
					String str = br.readLine();
					
					if(str.equals("")) break; // empty line 체크
					
					sb.append(str + '\n');
				}
				
				// 헤더 정보(Request Line + Header)
				String reqHeaderStr = sb.toString();
				
				System.out.println("요청 헤더:\n" + reqHeaderStr);
				System.out.println("-------------------------------------");
				
			} catch (IOException ex) {
				ex.printStackTrace();
			}finally {
				try {
					socket.close(); // 소켓 닫기(연결 끊기)
				} catch (IOException ex) {
					ex.printStackTrace();
				} 
			}
		}
	}
	 public static void main(String[] args) {
			new MyHTTPServer().start();
		}
}
