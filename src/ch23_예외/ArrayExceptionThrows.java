package ch23_예외;

import javax.management.RuntimeErrorException;

public class ArrayExceptionThrows {
	
	public static void main(String[] args) {
		Integer[] nums = new Integer[] { 1, 2, 3, 4, 5 };
		try {
			printArray(nums);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("프로그램 정상 종료");
	}
	
	
	public static void printArray(Integer[] numArray) throws Exception {    // throws Exception는 예외가 뜰 수 있으니 무조건 예외처리를 하라는 뜻, 예외를 미룬다 
		if(true) {			
//       강제로 예외생성
			throw new RuntimeException("내가 강제로 생성한 예외");
		}
//		노란줄은 프로그램 판단상 필요없는 코드
		for(int i= 0; i < numArray.length + 1; i++) {
			System.out.println(numArray[i]);
		}
	
	}
}
