package ch06_반복;

import java.util.Scanner;

public class Example01 {

	public static void main(String[] args) {
		/*N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오. 출력 형식에 맞춰서 출력하면 된다.
		 *입력: 첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 9보다 작거나 같다.
		 *출력: 출력형식과 같게 N*1부터 N*9까지 출력한다.
		 *예제입력: 2
		 */
		Scanner scanner = new Scanner(System.in);
		
		int N = 0;
		N = scanner.nextInt();
		for(int i = 0; i < 9; i++) {
			System.out.println(N + "*" + (i + 1) + "=" + (N * (i + 1)));
		}
		
		
		
	}

}
