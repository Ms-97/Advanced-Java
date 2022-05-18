package kr.or.ddit.homework.CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentHw {
	

	public static void main(String[] args) {
		ArrayList<Student> memList = new ArrayList<Student>();

		memList.add(new Student("20205555", "ȫ�浿", 80, 90, 70));
		memList.add(new Student("20207777", "�̼���", 100, 50, 80));
		memList.add(new Student("20206666", "������", 95, 40, 90));
		memList.add(new Student("20203333", "���е�", 80, 70, 60));
		memList.add(new Student("20208888", "������", 50, 70, 60));
		memList.add(new Student("20202222", "������", 70, 70, 70));
		memList.add(new Student("20204444", "������", 80, 90, 70));
		memList.add(new Student("20201111", "�̼���", 80, 100, 80));

		System.out.println("�й��� ������������ ����");
		System.out.println("----------------------------------------------------"
				+ "------------------------------------------------");
		Collections.sort(memList);
		for (Student Student : memList) {
			System.out.println(Student);
		}
		System.out.println("----------------------------------------------------"
				+ "------------------------------------------------");

		System.out.println("������ �������� ����");
		Collections.sort(memList, new Desc());
		for (Student Student : memList) {
			System.out.println(Student);
		}

	}

	public static void Ranking(List<Student> memList) {
		for (Student mem1 : memList) {
			int rank = 1;
			for (Student mem2 : memList) {
				if (mem1.getTotalScore() < mem2.getTotalScore()) {
					rank++;
				}
			}
			mem1.setRank(rank);

		}
	}
}

class Desc implements Comparator<Student> {

	@Override
	public int compare(Student mem1, Student mem2) {

		if (mem1.getTotalScore() > mem2.getTotalScore()) {
			return -1;
		} else if (mem1.getTotalScore() == mem2.getTotalScore()) {
			return mem1.compareTo(mem2);
		} else {
			return 1;
		}

	}
}


	class Student implements Comparable<Student> {
		private String id;
		private String name;
		private int language;
		private int english;
		private int math;
		private int totalScore;
		private int rank;

		public Student(String id, String name, int language, int english, int math) {
			super();
			this.id = id;
			this.name = name;
			this.language = language;
			this.english = english;
			this.math = math;
		}

		public int getTotalScore() {
			return totalScore = (language + english + math);
		}

		public void setTotalScore(int totalScore) {
			this.totalScore = totalScore;
		}

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getLanguage() {
			return language;
		}

		public void setLanguage(int language) {
			this.language = language;
		}

		public int getEnglish() {
			return english;
		}

		public void setEnglish(int english) {
			this.english = english;
		}

		public int getMath() {
			return math;
		}

		public void setMath(int math) {
			this.math = math;
		}

		@Override
		public int compareTo(Student mem) {

			return this.getId().compareTo(mem.getId());
		}

		@Override
		public String toString() {
			return "Student �й�: " + id + ", �̸�: " + name + ", ��������: " + language + ", ��������: " + english + ", ��������: "
					+ math + ", ����: " + getTotalScore() + ", ���: " + rank;
		}

	}



