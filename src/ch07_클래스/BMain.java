package ch07_클래스;

public class BMain {
	
	
	public static void main(String[] args) {
		B b1 = new B();
		b1.test1();  //(); : 호출
		int num1 = b1.test2();
		int num2 = 200;
		System.out.println(num1);
	//	System.out.println(200);
		System.out.println(b1.test2());
		
		if(b1.test3()) {
			System.out.println("if문 실행");
		}
		
		b1.test4("김준일", 30);  //순서 지켜서
		b1.test4(30, "김준일");
		
	}
	
	
	
}
