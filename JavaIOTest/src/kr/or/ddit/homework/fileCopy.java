package kr.or.ddit.homework;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/*
 'd:/D_Other/'에 있는 'Tulips.jpg'파일을
'복사본_Tulips.jpg'로 복사하는 프로그램을
작성하시오.
 */
public class fileCopy {
	public static void main(String[] args) throws IOException {
		File f1 = new File("d:/D_Other/Tulips.jpg");
		File f2 = new File("d:/D_Other/복사본_Tulips.jpg");
		
		if(f1.exists()) {
			System.out.println(f1.getAbsolutePath() + "은 존재합니다.");
			if(f2.exists()) {
				System.out.println(f2.getAbsolutePath() + "은 존재합니다.");
			}else {
				Files.copy(f1.toPath(), f2.toPath());
				System.out.println(f2.getAbsolutePath() + "을 복사했습니다.");
			}
		}else {
			System.out.println(f1.getAbsolutePath() + "은 없는 파일입니다.");
			
		}
	}
}
