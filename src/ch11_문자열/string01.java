package ch11_문자열;

import java.nio.charset.StandardCharsets;

public class string01 {

	public static void main(String[] args) {
		String str = new String("코리아 아이티 아카데미");
//		String str = new String("코리아 아이티 아카데미".getBytes(StandardCharsets.UTF_8));
//		String str = "코리아 아이티 아카데미"; 일때는  true 출력
		System.out.println(str == "코리아 아이티 아카데미");    // ==: 주소비교
	}

}
