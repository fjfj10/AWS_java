package ch11_문자열;

public class String05 {
	public static void main(String[] args) {
		String name = " ";
		
		boolean flag = name.isBlank();     //공백을 공백으로 본다
		System.out.println(flag);
		
		boolean flag2 = name.isEmpty();    //공백을 문자로 본다
		System.out.println(flag2);
		
	}
}
