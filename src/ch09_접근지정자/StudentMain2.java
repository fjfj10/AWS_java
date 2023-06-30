package ch09_접근지정자;

import ch09_접근지정자.main.Student2;

public class StudentMain2 {
	public static void main(String[] args) {
		Student2 s = new Student2();
		s.setName("김준일");
		System.out.println(s.getname());
		
		s.setAge(30);
		System.out.println(s.getage());
	}
}
