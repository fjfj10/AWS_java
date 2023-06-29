package ch03_연산자;

public class Operator01 {
	public static void main(String[] args) {
		int num = 10;
		System.out.println(num++); //다음에 오는 변수에 +1
		System.out.println(num++);
		System.out.println(num);
		System.out.println(-num);
		System.out.println(num--);
		System.out.println(num--);
		System.out.println(num);
		//연산자는 띄워쓴다(가독성)
		
	}
}
