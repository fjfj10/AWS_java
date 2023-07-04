package ch22_익명클래스;

public class AuthorityMain {
	public static void main(String[] args) {
		GrantedAuthorities authorities = new GrantedAuthorities() {
//			인터페이스를 상속하지 않고 직접 구현
			@Override
//			한번만 쓰고 버릴거면 굳이 클래스를 만들 필요가 없다 > 익명클래스로 구현 > 코드가 끝난 후 메모리 주소를 가비지컬렉터가 지운다 = 일회용			
			public String getAuthority() {
				System.out.println("권한 출력");
				
				return "ROLE_USER";
			}
		};
			System.out.println(authorities.getAuthority());
			
			A a = new A();
			System.out.println(a.getAuthority());
	
	}
}

class A implements GrantedAuthorities {
	@Override
	public String getAuthority() {
		System.out.println("두번째 권한 출력");
		return "ROLE_ADMIN";
	}
}