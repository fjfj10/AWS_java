package ch03_연산자;

public class Operator03 {

	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		int c = 5;
		
//		System.out.println(a < b ? b : a);
//		System.out.println(b < c ? c : b); a가 클 때 안나옴

		int max = 0;
		
		max = a < b ? b : a;
		max = max < c ? c : max;
		System.out.println(max);
		
		System.out.println(a < b ? b : a < c ? c : a); // 괄호 안쳐도 상관 X 
		
	
		
	}

}
