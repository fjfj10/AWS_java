package ch05_조건;

import java.util.Scanner;

public class Example01 {

	public static void main(String[] args) {
	/*두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
	 *첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다
	 * 입력: 첫째 줄에 다음 세 가지 중 하나를 출력한다.
	 * 출력: A가 B보다 큰 경우에는 '>'를 출력한다.
	 *       A가 B보다 작은 경우에는 '<'를 출력한다.
	 *       A와 B가 같은 경우에는 '=='를 출력한다.
	 * 제한: -10,000 ≤ A, B ≤ 10,000  */
		Scanner scanner = new Scanner(System.in);
		
//		int A = 0;
		System.out.print("A: ");
		int input1 = scanner.nextInt();
//		int B = 0;
		System.out.print("B: ");
		int input2 = scanner.nextInt();
		
//		if(A > B) {
//			System.out.println('>');
//		}else if(A < B) {
//			System.out.println('<');
//		}else if(A == B) {
//			System.out.println("==");
//		}

		if(input1 > input2) {
			System.out.println('>');
		}else if(input1 < input2) {
			System.out.println('<');
		}else if(input1 == input2) {
			System.out.println("==");
		}
		
	}

}
