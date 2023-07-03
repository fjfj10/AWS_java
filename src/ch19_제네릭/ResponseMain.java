package ch19_제네릭;


public class ResponseMain {
	public static void main(String[] args) {
		Response<String> response1 = new Response<String>(200, "회원가입 성공");

		SignupUser signupUser = SignupUser.builder()
				.username("aaa")
				.password("1234")
				.name("김준일")
				.email("aaa@gmail,com")
				.build();
		
		Response<SignupUser> response2 = new Response<SignupUser>(400, signupUser);    //생성되는 시점에 자료형을 정해준다

		AccountUser accountUser = AccountUser.builder().username("aaa").password("1234").build();
		
		Response<?> response3 = new Response<AccountUser>(200, accountUser);   
//		response3 = response2;
		
		UpdateUser updateUser = UpdateUser.builder()
				.username("aaa")
				.password("1234")
				.address("부산")
				.phone("010-0000-0000")
				.build();
				
		Response<UpdateUser> response4 = new Response<UpdateUser>(300, updateUser);		
		
		printResponse(response4);
	}
	
	public static Response<?> printResponse(Response<?> response) {    //<?>와일드 카드가 자료형을 알아서 변환시켜 적용한다? = 어떠한 제네릭이든 넣을 수 있다 return가능
		System.out.println(response);             // super은 위로만 가능 옆이나 아래로는 불가
		return response;
		
	//와일드카드에 제약을 걸수있다	
	//public static Response<?> printResponse(Response<? extends AccountUser> response) AccountUser를 상속받은 제네릭만 가능
	//public static Response<?> printResponse(Response<? super SignupUser> response) SignupUser를 상속받은 제네릭만 가능
	}
	
}
