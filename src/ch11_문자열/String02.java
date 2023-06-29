package ch11_문자열;

public class String02 {
	public static void main(String[] args) {
		String phone = "010-9988-1916";
		
		int index = phone.indexOf("-");    //해당 문자(문자열)의 (시작)인덱스번호 출력 
		int lastindex = phone.lastIndexOf("-");    //lastindex : 문자열 끝에서부터  
		
		System.out.println(index);
		System.out.println(lastindex);
		
		String midNumber = phone.substring(index + 1, lastindex);
		System.out.println(midNumber);
		
		boolean findFlag =  phone.contains("010");
		
	}
}
