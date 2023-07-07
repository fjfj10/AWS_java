package Test;

import lombok.ToString;

class User {
	private String username;
	private String password;
	private String name;
	private String email;
	
	public User(String username, String password,  String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public void showInfo() {
		System.out.println("[사용자정보]");
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		System.out.println("name: " + name);
		System.out.println("email: " + email);
		
				
	}
}
@ToString
public class UserMain {
	public static void main(String[] args) {
		User user = new User("junil", "1234", "김준일", "junil@gmail.com");
		user.showInfo();
	}
}
//ToString 오버라이드 문제
//[사용자정보]
//username: junil
//password: 1234
//name: 김준일
//email:junil@gmail.com