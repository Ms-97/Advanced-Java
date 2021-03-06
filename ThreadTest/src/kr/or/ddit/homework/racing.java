package kr.or.ddit.homework;

import java.util.Arrays;

public class racing {
	public static void main(String[] args) {
		Animal[] animals = new Animal[]{
			new Animal("λ§","π","A"),
			new Animal("κ°","πβπ¦Ί","n"),
			new Animal("κ³ μμ΄","π","i"),
			new Animal("μ¬μ΄","π¦","m"),
			new Animal("μΌμ","π","a"),
			new Animal("μ","π","l"),
			new Animal("λΌμ§","π"," "),
			new Animal("μ½λΌλ¦¬","π","R"),
			new Animal("λ­","π","u"),
			new Animal("ν λΌ","π","n")
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
		System.out.println("====== ππβπ¦Ίππ¦πκ²½κΈ°κ° μ’λ£λμμ΅λλ€!@~πππππ ======");
		System.out.println();
		
		// κ²½κΈ° μ’λ£ ν λ±μμμΌλ‘ μ λ ¬νκΈ°
		Arrays.sort(animals);
		
		
		System.out.println("κ²½κΈ° κ²°κ³Ό");
		for(Animal h : animals){
			System.out.println(h);
		}
		

	}

}


class Animal extends Thread implements Comparable<Animal>{
	public static int currentRank = 0;
	
	private String animalName;	// μ΄λ¦
	private String icon;	// λλ¬Ό μμ΄μ½
	private String alBet;	// λλ¬Ό μμ΄μ½
	private int rank;			// λ±μ
	private int location;		// νμ¬μμΉ

	// μμ±μ
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
		return  rank + "λ± : "+ animalName;
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


// κ²½κΈ° μ€μ νμ¬ μν©μ μΆλ ₯νλ μ°λ λ
class PlayState extends Thread{
	private Animal[] animals;

	// μμ±μ
	public PlayState(Animal[] animals) {
		this.animals = animals;
	}
	
	@Override
	public void run() {
		while(true){
			if(Animal.currentRank == animals.length){  // κ²½κΈ° μ’λ£
				break;
			}
			
			for(int i=1; i<=10; i++){
				System.out.println();
			}
			
			
			for(int i=0; i<animals.length; i++){
				if(i==0) {
					System.out.println("=π====================================================π¦=====");
					System.out.println("π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²");
				}
				System.out.print(animals[i].getAlBet()+"β");
				
				for(int j=50; j>=0; j--){
					if(animals[i].getLocation()==j){ // νμ¬μμΉ νμ
						System.out.print(animals[i].getIcon()+"~~");
					}else{
						
						
						System.out.print("-");
					}
				}
				System.out.print(":"+animals[i].getAnimalName());
				System.out.println();
			}
			System.out.println("=π====================================================π¦=====");
			System.out.println("π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²π³π²");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		  }
		}
	
}
	
	
