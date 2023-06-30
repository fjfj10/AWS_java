package ch05_조건;

import java.util.Scanner;

public class Example03 {

	public static void main(String[] args) {
		/*상근이가 설정한 알람 시각이 주어졌을 때 45분 일찍 알람이 울리게 설정 하려면 이를 언제로 고쳐야 하는지 구하는 프로그램을 작성하시오.
		 * 입력: 첫째 줄에 두 정수 H와 M이 주어진다. (0 ≤ H ≤ 23, 0 ≤ M ≤ 59) 그리고 이것은 현재 상근이가 설정한 알람 시간 H시 M분을 의미한다.
		 *        입력 시간은 24시간 표현을 사용한다. 24시간 표현에서 하루의 시작은 0:0(자정)이고, 끝은 23:59(다음날 자정 1분 전)이다. 
		 *        시간을 나타낼 때, 불필요한 0은 사용하지 않는다.
		 * 출력: 첫째 줄에 상근이가 창영이의 방법을 사용할 때, 설정해야 하는 알람 시간을 출력한다. (입력과 같은 형태로 출력하면 된다.)
		 *  예제입력: 10 10          예제출력: 09 25 성공
		 *  예제입력: 00 30          예제출력: 23 45 성공
		 *  예제입력: 23 40          예제출력: 22 55 성공*/

		Scanner scanner = new Scanner(System.in);
		
		int H = 0;
		H = scanner.nextInt();
		int M = 0;
		M = scanner.nextInt();
		
		 if(H == 0) {
				if(M < 45) {
					System.out.println(23 + ":" + + (60 - (45 - M)));
				}else if(M == 45) {
					System.out.println(H + ":" + "0");
				}else if(M > 45) {
					System.out.println(H + ":" + (M - 45));
				}
		 }else if(H <= 23) {
				if(M < 45) {
					System.out.println(H - 1 + ":" + (60 - (45 - M)));
				}else if(M == 45) {
					System.out.println(H + ":" + "0");
				}else if(M > 45) {
					System.out.println(H + ":" + (M - 45));
				}	
		}
		
		

	}
}