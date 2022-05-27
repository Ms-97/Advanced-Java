package kr.or.ddit.homework;

import java.util.Arrays;

public class racing {
	public static void main(String[] args) {
		Animal[] animals = new Animal[]{
			new Animal("말","🐎","A"),
			new Animal("개","🐕‍🦺","n"),
			new Animal("고양이","🐈","i"),
			new Animal("사슴","🦌","m"),
			new Animal("염소","🐐","a"),
			new Animal("소","🐄","l"),
			new Animal("돼지","🐖"," "),
			new Animal("코끼리","🐘","R"),
			new Animal("닭","🐓","u"),
			new Animal("토끼","🐇","n")
		};
		
		PlayState state = new PlayState(animals);
		
		for(Animal h : animals){
			h.start();
		}
		state.start();
		

		for(Animal h : animals){
			try {
				h.join();
			} catch (InterruptedException e) {
			}
		}
		try {
			state.join();
		} catch (InterruptedException e) {
		}
		
		System.out.println();
		System.out.println("====== 🐎🐕‍🦺🐈🦌🐐경기가 종료되었습니다!@~🐄🐖🐘🐓🐇 ======");
		System.out.println();
		
		// 경기 종료 후 등수순으로 정렬하기
		Arrays.sort(animals);
		
		
		System.out.println("경기 결과");
		for(Animal h : animals){
			System.out.println(h);
		}
		

	}

}


class Animal extends Thread implements Comparable<Animal>{
	public static int currentRank = 0;
	
	private String animalName;	// 이름
	private String icon;	// 동물 아이콘
	private String alBet;	// 동물 아이콘
	private int rank;			// 등수
	private int location;		// 현재위치

	// 생성자
	public Animal(String animalName, String icon,String alBet) {
		this.animalName = animalName;
		this.icon = icon;
		this.alBet = alBet;
	}
	

	public String getAlBet() {
		return alBet;
	}

	public String getAnimalName() {
		return animalName;
	}

	public String getIcon() {
		return icon;
	}

	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return  rank + "등 : "+ animalName;
	}
	
	@Override
	public int compareTo(Animal h) {
		return Integer.compare(rank, h.getRank());
	}

	@Override
	public void run() {
		for(int i=1; i<=50; i++){
			location = i;
			try {
				Thread.sleep((int)(Math.random()*400));
			} catch (InterruptedException e) {
			}
		}
		rank = ++Animal.currentRank;
	}
	
}


// 경기 중의 현재 상황을 출력하는 쓰레드
class PlayState extends Thread{
	private Animal[] animals;

	// 생성자
	public PlayState(Animal[] animals) {
		this.animals = animals;
	}
	
	@Override
	public void run() {
		while(true){
			if(Animal.currentRank == animals.length){  // 경기 종료
				break;
			}
			
			for(int i=1; i<=10; i++){
				System.out.println();
			}
			
			
			for(int i=0; i<animals.length; i++){
				if(i==0) {
					System.out.println("=🏁====================================================🚦=====");
					System.out.println("🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲");
				}
				System.out.print(animals[i].getAlBet()+"│");
				
				for(int j=50; j>=0; j--){
					if(animals[i].getLocation()==j){ // 현재위치 표시
						System.out.print(animals[i].getIcon()+"~~");
					}else{
						
						
						System.out.print("-");
					}
				}
				System.out.print(":"+animals[i].getAnimalName());
				System.out.println();
			}
			System.out.println("=🏁====================================================🚦=====");
			System.out.println("🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲🌳🌲");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		  }
		}
	
}
	
	
