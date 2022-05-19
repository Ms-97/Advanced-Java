package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class T08MapTest {
	/*
	 * Map => key���� value���� �� ������ �����ϴ� ��ü key���� �ߺ��� ������� �ʰ� ������ ����.(Set�� Ư¡) value����
	 *         �ߺ��� ����Ѵ�.(List�� Ư¡)
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();

		// �ڷ��߰� =>put(key��, value��);
		map.put("name", "ȫ�浿");
		map.put("addr", "����");
		map.put("tel", "010-1234-5678");

		System.out.println("map => " + map);

		// �ڷ� ���� => �����͸� ������ �� key���� ������ ���߿� �Է��� ����
		//              ����ȴ�. put(������key��, ���ο�value��);
		map.put("addr", "����");
		System.out.println("map => " + map);

		// �ڷ� ���� => remove(������ key��);
		map.remove("name");
		System.out.println("map => " + map);

		// �ڷ� �б� => get(key��);
		System.out.println("addr => " + map.get("addr"));
		System.out.println("=============================");

		// key ������ �о�� �ڷḦ ����ϴ� ���

		// ���1 => keySet() �̿��ϱ�
		// keySet()�޼��� => Map�� key���鸸 �о�� Set������ ��ȯ�Ѵ�.
		Set<String> keySet = map.keySet();

		System.out.println("Iterator�� �̿��� ���");
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("-----------------------------");

		// ���2 => Set���� �����͸� '���� for��'���� ó���ϸ� Iterator��
		//          ������� �ʾƵ� �ȴ�.
		System.out.println("���� for���� �̿��ϴ� ���");
		for (String key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("------------------------------");

		// ���3 => value���� �о�� ����ϱ� => values() �̿�
		System.out.println("values() �̿��� ���");
		for (String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("-------------------------------");

		// ���4 => Map���� Ŭ�������� Map.EntryŸ���� ���� class��
		//          ������� �ִ�. �� ���� Ŭ������ key�� value��� ���������
		//          �����Ǿ� �ִ�. Map���� �� Map.EntryŸ���� ��ü���� Set������
		//          ������ �� �ִ�. => entrySet() �޼��� �̿�
		Set<Map.Entry<String, String>> mapSet = map.entrySet();

		// ������ Entry��ü���� ������� ó���ϱ� ���ؼ� Iterator��ü�� ��ȯ
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		while (entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();
			System.out.println("key�� : " + entry.getKey());
			System.out.println("value�� : " + entry.getValue());
			System.out.println();
		}

	}
}
