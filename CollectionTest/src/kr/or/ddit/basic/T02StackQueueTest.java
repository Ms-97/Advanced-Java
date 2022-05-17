package kr.or.ddit.basic;

import java.util.LinkedList;

public class T02StackQueueTest {
	public static void main(String[] args) {
	/*
	 	Stack => ���Լ���(LIFO) �ڷᱸ��
	 	Queue => ���Լ���(FIFO) �ڷᱸ��

		Linkedlist�� �̿��� ���� �� ť ����
	*/
		
		LinkedList<String> stack = new LinkedList<String>();
		
		/*
		  	Stack�� ���
		  	1)�ڷ� �Է� : push(�����Ұ�)
		  	2)�ڷ� ��� : pop() => �ڷḦ ������ �� ������ �ڷḦ
		  	 			           stack���� �����Ѵ�.
		 */
		stack.push("ȫ�浿");
		stack.push("������");
		stack.push("���е�");
		stack.push("������");
		System.out.println("���� stack���� : "+ stack);
		
		String data = stack.pop();
		System.out.println("������ �ڷ� : " + data);
		System.out.println("������ �ڷ� : " + stack.pop());
		System.out.println("������ �ڷ� : " + stack);
		
		stack.push("������");
		System.out.println("���� stack���� : "+ stack);
		System.out.println("������ �ڷ� : " + stack.pop());
		System.out.println("=====================================");
		System.out.println();
		
		LinkedList<String> queue = new LinkedList<String>();
		/*
		  	Queue�� ���
		  1) �ڷ� �Է� : offer(�����Ұ�)
		  2) �ڷ� ��� : poll() => �ڷḦ Queue���� ������ ��
		  						������ �ڷḦ Queue���� �����ȴ�.
		 */
		queue.offer("ȫ�浿");
		queue.offer("������");
		queue.offer("���е�");
		queue.offer("������");
		
		System.out.println("���� Queue�� �� : " + queue);
		
		String temp = queue.poll();
		System.out.println("������ �ڷ� : " + data);
		System.out.println("������ �ڷ� : " + queue.poll());
		System.out.println("���� Queue�� �� : " + stack);
		
		if(queue.offer("������")) {
			System.out.println("�ű� � �ڷ� : ������");
		}
		System.out.println("���� queue�� �� : " + queue);
		System.out.println("������ �ڷ� : " + queue.poll());
	}
}
