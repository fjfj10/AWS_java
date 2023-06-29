package ch11_문자열;

public class String04 {

	public static void main(String[] args) {
		String phone = "010   9988.1916    ";
		//문자열안의 앞을 뒤로 바꿔라 > 데이터 정제
		String replacePhone = phone
				.replaceAll("-", "")
				.replaceAll(" ", "")
				.replaceAll("[.]", "");
		
		System.out.println(replacePhone);
		
		String phone2 = phone.trim();    //앞뒤 실수로 넣은 공백처리
		System.out.println(phone2);
		
		

	}

}
