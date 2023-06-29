package ch05_조건;

public class If01 {
	public static void main(String[] args) {
		
		if(5 < 10) System.out.println("10이 5보다 큽니다.");
		//삼항연산자: 명령문X, If: 명령가능 but 컴퓨터 입장에서는 삼항연산자가 더 편함 같은 값이 나온다면 삼항 사용 
		if(5 > 10) {
			System.out.println("10이 5보다 큽니다.");   //참이 아니기 때문에 출력X
			System.out.println("참일때 출력");
		}else {
			System.out.println("거짓일때 동작"); 
			System.out.println("거짓"); 
		}
		
	}
}
