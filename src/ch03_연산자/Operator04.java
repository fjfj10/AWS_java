package ch03_연산자;

// class 이름 바꿀 때 Refactor - Rename or F2
public class Operator04 {
	public static void main(String[] args) {
		int score = 80;
		
//		System.out.println(score >= 90 ? 'A' : score >= 80 ? 'B' : score >= 70 ? 'C' : score >=60 ? 'D' : 'F');
		String result = score < 0 || score > 100 ? "X" 
				: score > 89 ? "A" 
				: score > 79 ? "B" 
				: score > 69 ? "C" 
				: score > 59 ? "D" 
				: "F"; //연산자 앞에서 줄을 끊는다, 삼항 연산자는 줄을 맞춰 주는게 좋다.
		
		System.out.println(result);
		
	
	
	}	
}
