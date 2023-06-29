package ch06_반복;

public class while02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int i = 0; 
		
		while(i <10) {
			if(i % 2 == 0) {
				i++;
				continue;    //아래로 내려가기전 조건 반복
			}
			System.out.println(i);
			i++;   
		}
	}

}
