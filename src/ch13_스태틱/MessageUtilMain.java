package ch13_스태틱;

import java.util.Arrays;

public class MessageUtilMain {
	
	private int a;
	
	public static void main(String[] args) {
		MessageUtilMain messageUtilMain = new MessageUtilMain();
		
		System.out.println(messageUtilMain.a);
		
//		Array01.main(null);
		
		MessageUtil messageUtil = new MessageUtil();
		
	//	messageUtil.sendMail();
	//	messageUtil.sendFile();
		
		MessageUtil.sendFile();     //스태틱은 생성할 필요가 없다
		System.out.println();     
		
		MessageUtil.data = "안녕";
		System.out.println(MessageUtil.data);
		
		System.out.println(messageUtil.data);    //스태틱특징: 공유한다
		
		
	}
	
	
}
