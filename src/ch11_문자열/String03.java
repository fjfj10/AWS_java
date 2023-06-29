package ch11_문자열;

public class String03 {

	public static void main(String[] args) {
		
		String[] addressArray = new String[] {
				"부산시 동래구", 
				"부산시 부산진구", 
				"창원시 마산하포구", 
				"창원시 진해구"
		};
		
		String[] addressArray2 = new String[0];
		String[] addressArray3 = new String[0];		
		
		
		for(int i = 0; i < addressArray.length; i++) {
			if(addressArray[i].contains("부산시")) {
			//저장공간이 0인 addressArray2를 대신 담을 임시 배열(addressArray보다 한칸 더 큰) 생성
				String[] tempArray = new String[addressArray2.length+ 1];
			//addressArray2의 저장 정보 옮기기
				for(int j = 0; j < addressArray2.length; j++) {
				//addressArray2를 tempArray에 대입
					tempArray[j] = addressArray2[j];
				}
				//새로운값(addressArray)의 정보를 대입
				tempArray[addressArray2.length] = addressArray[i];
				//tempArray를 addressArray2에 대입
				addressArray2 = tempArray;
				
			}else if(addressArray[i].contains("창원시")) {
				String[] tempArray = new String[addressArray3.length + 1];
				for(int j = 0; j < addressArray3.length; j++) {
					tempArray[j] = addressArray3[j];
				}
				tempArray[addressArray3.length] = addressArray[i];
				addressArray3 = tempArray;
			}
		} 
		System.out.println("[부산시]");
		for(int i = 0; i < addressArray2.length; i++) {
			System.out.println(addressArray2[i]);
		}
		System.out.println("[창원시]");
		for(int i = 0; i < addressArray3.length; i++) {
			System.out.println(addressArray3[i]);
		}
	}

}
