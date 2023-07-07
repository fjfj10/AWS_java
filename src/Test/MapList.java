package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapList {
	public static void main(String[] args) {
		Map<String, Object> strMap1 = new HashMap<String, Object>();
		strMap1.put("name", "홍길동");
		strMap1.put("rating", "vip");
		strMap1.put("age", "30");
		Map<String, Object> strMap2 = new HashMap<String, Object>();
		strMap2.put("name", "김기영");
		strMap2.put("rating", "gold");
		strMap2.put("age", "35");
//나중에 답 확인	
//		strMap.add()
//		for(Map<String, Object> customer : customers) {
//				for(Entry<String, Object> entry : strMap.entrySet()) {
//					System.out.println(entry.getKey());
//					System.out.println(entry.getValue());
//					
//				}
//			
//		}
	}
}
//내답 
//public class MapList {
//	public static void main(String[] args) {
//		Map<String, Object> strMap = new HashMap<>();
//		strMap.put("name=홍길동", ("rating=vip\nage=30"));
//		strMap.put("name=김기영",  ("rating=gold\nage=35"));
//	
//		List<Map<String, Object>> customers = new ArrayList<>();
//		customers.add(strMap);
//		
//	
//		
//		for(Map<String, Object> customer : customers) {
//				for(Entry<String, Object> entry : strMap.entrySet()) {
//					System.out.println(entry.getKey());
//					System.out.println(entry.getValue());
//					
//				}
//			
//		}
//	}
//}
//name=홍길동 
//rating=vip
//age=30
//name=김기영
//rating=gold
//age=35