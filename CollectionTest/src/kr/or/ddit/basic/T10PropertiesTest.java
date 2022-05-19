package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class T10PropertiesTest {
/*
   Properties�� Map���� ��ҵ� ����� ��ü��� �� �� �ִ�.
   Map�� ��� ������ ��ü �����͸� key�� value������ ����� �� ������
   Properties�� key�� value������ String�� ����� �� �ִ�.
   
   	Map�� put(), get() �޼ҵ带 �̿��Ͽ� �����͸� ����� ������,
   	Properties�� setProperty(), getProperty()�޼ҵ带 �̿��ؼ�
   	�����͸� ����� �Ѵ�.
 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		
		prop.setProperty("name", "ȫ�浿");
		prop.setProperty("tel", "010-1234-5678");
		prop.setProperty("addr", "����");
		
		String name = prop.getProperty("name");
		String tel = prop.getProperty("tel");
		
		System.out.println("�̸� : " + name);
		System.out.println("��ȭ : " + tel);
		System.out.println("�ּ� : " + prop.getProperty("addr"));
		
		//������ ���Ϸ� �����ϱ�
		prop.store(
				new FileOutputStream(
						"src/kr/or/ddit/basic/test.properties"),
					    "�ڸ�Ʈ�Դϴ�. ");
	}
}
