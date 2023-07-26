package ch17_추상;

public class TestB extends TestA{
	
	@Override
	public void test() {
		System.out.println("재정의 해서 쓸거다");
	} 
//	인터페이스는 다중 상속이 가능하다
//	인터페이스는 추상메소드를 기본으로 가지기 때문에 메소드 앞에 굳이 absalt를 달아줄 피요가 없다
}
