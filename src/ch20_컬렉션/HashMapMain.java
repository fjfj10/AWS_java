package ch20_컬렉션;

import java.util.Map.Entry;
import java.util.HashMap;


public class HashMapMain {

	public static void main(String[] args) {
		HashMap<String, String> strMap = new HashMap<>();
		strMap.put("username", "aaa");
		strMap.put("password", "1234");
		strMap.put("name", "김준일");
		//중복을 허용하지 않으면서 순서가 없다.
		System.out.println(strMap);
		System.out.println();
		System.out.println(strMap.get("username"));
		System.out.println();
//		Map은 반복을 돌릴 수 없다 entrySet을 사용하면 가능
		
		for(Entry<String, String> entry : strMap.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());			
		}
//		위 방법을 쓰는것이 좋다
		System.out.println("==============================================");
		for(String key : strMap.keySet()) {
			System.out.println(key);
			System.out.println(strMap.get(key));
		}
	}
}
