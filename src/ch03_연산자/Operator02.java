package ch03_연산자;

/*
 * 논리연산자
 * 1. &&-> and(그리고) - 곱
 * true && false => false
 * 2. ||-> or(또는)    - 합
 * true || false => true 
 * 3. ! -> not(부정)   - 반전
 * !(true || false) => false
 * !true => false
 * */

public class Operator02 {

	public static void main(String[] args) {
		final int MAX = 100;
		final int MIN = 0;
		int num = -10;
		
		System.out.println(MIN < num || MAX > num); //||는 or의 의미를 가짐
		System.out.println(MIN < num && MAX > num); //&&는 and의 의미를 가짐
		
		int year = 1999;
		System.out.println(year % 4 == 0);
		System.out.println(year % 100 != 0);
		System.out.println(year % 400 == 0);
		System.out.println(year % 4 == 0 && year % 100 != 100 || year % 400 == 0 );
		System.out.println(!(year % 4 == 0 && year % 100 != 100 || year % 400 == 0));
		
		if(year % 4 == 0 && year % 100 != 100 || year % 400 == 0 ) {
			System.out.println(1);
		}else {
			System.out.println(0); }
		System.out.println(year % 4 == 0 && year % 100 != 100 || year % 400 == 0 ? 1 : 0); //참이면 왼쪽, 거짓이면 오른쪽 결과 출력

		int result = 10 +1;
		System.out.println(result);
		
		boolean result2 = year % 4 == 0 && year % 100 != 100 || year % 400 == 0;
		System.out.println(result2);
		
		int result3 = year % 4 == 0 && year % 100 != 100 || year % 400 == 0 ? 1 : 0; // 1:0부분은 자료형이 동일해야한다 "1":"0" 가능 1:"0" 불가
		System.out.println(result3);
		
	}

}
