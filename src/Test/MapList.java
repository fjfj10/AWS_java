package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapList {
	public static void main(String[] args) {
		List<Map<String, Object>> customers = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> customer1 = new HashMap<String, Object>();
		customer1.put("name", "홍길동");
		customer1.put("rating", "vip");
		customer1.put("age", "30");
		
		customers.add(customer1);
		
		Map<String, Object> customer2 = new HashMap<String, Object>();
		customer2.put("name", "김기영");
		customer2.put("rating", "gold");
		customer2.put("age", "35");
		
		customers.add(customer2);
		
		for(Map<String, Object> customer : customers) {
			for(Map.Entry<String, Object> entry : customer.entrySet()) {
				System.out.println(entry);
			}
		}

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
