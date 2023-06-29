package ch04_입력;

import java.util.Scanner;

public class Input02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = "";
		int age = 0;
		String phone = "";
		String address = "";
		String gender = "";       //선언은 앞쪽에 몰아서
		
		System.out.print("이름: ");
		name = scanner.next();
		System.out.print("나이: ");
		age = scanner.nextInt();
		System.out.print("연락처: ");
		phone = scanner.next();
		scanner.nextLine(); //연락처에 남아있는 엔터 날려주기(버퍼비우기)
		System.out.print("주소: ");
		address = scanner.nextLine();
		System.out.print("성별: ");
		gender = scanner.next();
		
		System.out.println("고객님의 이름은 " + name + "이고 나이는 " + age + "세입니다.");
		System.out.println("연락처는 " + phone + "이며 주소는 " + address + "입니다.");
		System.out.println("성별은 " + gender +"입니다.");
		/*
		 * 이름:
		 * 나이:
		 * 연락처:
		 * 주소:
		 * 성별:
		 * 
		 * 고객님의 이름은 000이고 나이는 00세입니다. 
		 * 연락처는 010-0000-0000이며 주소는 부산 동래구 사직동 입니다.
		 * 성별은 남입니다.
		 * 
		 * */
		
//		System.out.println("이름(name): ");
//		String name = scanner.next();
//		System.out.println("나이(age): ");
//		int age = scanner.nextInt();
//		System.out.println("연락처(phone): ");
//		String phone = scanner.next();
//		System.out.println("주소(address): ");
//		String address = scanner.nextLine();
//		System.out.println("성별(gender): ");
//		String gender = scanner.next();
//		
//		System.out.println("고객님의 이름은" + name + "이고" + "나이는" + age + "세입니다."
//				+ "연락처는" + phone + "이며 주소는" + address + "입니다. 성별은" + gender +"입니다.");
//		
		
		
		
	}

}
