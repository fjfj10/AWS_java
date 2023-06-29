package ch14_싱글톤;    //유일한 객체

public class FactoyMain {
	public static void main(String[] args) {
		Samsung samsung = new Samsung();
		
		SamsungFactory factory1 = new SamsungFactory(samsung);
		SamsungFactory factory2 = new SamsungFactory(samsung);
		
		factory1.produce("갤럭시s").showInfo();
		factory2.produce("갤럭시s2").showInfo();
		factory1.produce("갤럭시s3").showInfo();
	}
}
