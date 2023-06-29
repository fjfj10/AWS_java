package ch05_조건;

import java.util.Scanner;

public class Ifscore {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String result = ""; 
		int score = 0;
		
		System.out.println("점수 입력: ");
		score = scanner.nextInt();
		
		if(score > 0 || score <100) {
			result = "X";
		}else if(score > 89 ) {
			result = "A";
		}else if(score > 79) {
			result = "B";
		}else if(score > 69) {
			result = "C";
		}else if(score > 59) {
			result = "D";
		}else {
			result = "F";
		}
		
	
		System.out.println(result);
		

}
}