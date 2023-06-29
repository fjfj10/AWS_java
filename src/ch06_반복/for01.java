package ch06_반복;

public class for01 {

	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5,6};    //배열
		
		for(int i = 0; i < 6; i++) System.out.println(numbers[i]);
//1. 변수선언&초기화 2.조건   4.증가     3.출력	
		//            5.       7.           6. 반복 (i가 6이될경우 거짓이되어 정지)
//		for(int i = 0, j = 0; i < 6; i++, j++) System.out.println(numbers[i]); 가능

		for(int i = 0; i < 6; i++) {
			System.out.println(numbers[i]);
			System.out.println("i: " + i);
		}
	}

}
