package ch18_빌더;

public class UserTest {

	public static void printUser() {
		System.out.println("사용자 정보 출력");
		//()를 쳐주면 변수에 담지 않아도 됌
		(new UserTest()).test();
//		(new UserTest()).new UserTestTest();     //static이 아닐때, 내부클래스 관계 정리에 사용
		new UserTestTest();    //static이기 때문에 호출가능, 내부이기 때문에 UserTest를 붙이지 않아도 된다. 
		new UserTest.UserTestTest();    //외부에서 호출시에는 어디에 있는지 표시해야 한다
	}
	
	public void test() {
		System.out.println("테스트 메소드 호출");
	}
	
	public static class UserTestTest {
		
		public void testTest() {
			System.out.println("테스트테스트 메소드 호출");
		}
	}
	
}
