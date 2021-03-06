package kr.or.ddit.basic;

public class T19WaitNotifyTest {
/*
    wait() => 동기화 영역에서 락을 풀고 Wait-Set영역(공유객체별 존재)으로
    		  이동 시킨다.
    notify() 또는  notifyAll() => Wait-Set영역에 있는 스레드를 깨워서
    		  					  실행될 수 있도록 하낟.
    		  			 (notify()는 하나, notifyAll()은 전부를 깨운다.)
    => wait()과 notify(), notifyAll()은 동기화 영역에서만 실행할 수 있고,
    Object클래스에서 제공하는 메소드 이다.		  			 
 */
	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();
	}
}

// 공통으로 사용할 객체
class WorkObject {
	public synchronized void methodA() {
		System.out.println("methodA()메소드 작업 중...");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized void methodB() {
		System.out.println("methodB()메소드 작업 중...");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


// WorkObject의 methodA()메소드만 호출하는 스레드
class ThreadA extends Thread {
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			workObj.methodA();
		}
		
		System.out.println("ThreadA 종료.");
	}
}
// WorkObject의 methodB()메소드만 호출하는 스레드
class ThreadB extends Thread {
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			workObj.methodB();
		}
		
		System.out.println("ThreadB 종료.");
	}
}






