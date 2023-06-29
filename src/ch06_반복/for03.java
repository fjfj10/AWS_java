package ch06_반복;

public class for03 {

	public static void main(String[] args) {

		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();  //줄바꿈
		}
		
		
		for(int i = 0; i < 5; i++) {
			for(int j =0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println(); 
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5 - 1 - i; j++) {
				System.out.print(" ");
			}
			// 4-i대신 5-1-i을 쓰는 이유는 이후 변수를 변경할 때를 위함임. 5대신 n사용
			for(int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
