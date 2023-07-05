package ch22_익명클래스;

public class LambdaTest {
	public static void main(String[] args) {
//		Lambda = 화살표함수 = 함수형 프로그래밍 매개변수의 자료형 생략가능
		GrantedAuthorities authorities2 = new GrantedAuthorities() {
			
			@Override
//			메소드구현
			public String getAuthority() {
				System.out.println("권한 출력");
				return "ROLE_USER";
			}
		};
//		      함수명,클래스명 없다     ()=매개변수 클래스정의부터 함수 정의까지 가능하려면 인터패이스 안에 추상함수가 딱 하나만 존재해야한다(인터페이스 안에서 default 사용하여 일반함수 만들기 가능)
		GrantedAuthorities authorities = () -> {
			System.out.println("권한 출력");
			return "ROLE_USER";
		};
		
//		authorities.getAuthority()가 들어있다 왜?  authorities = () -> 에서 생성과 정의가 모두되어 주소를 가지기 때문
		
		System.out.println(authorities.getAuthority());
	}
}
