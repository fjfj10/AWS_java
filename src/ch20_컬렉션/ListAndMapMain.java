package ch20_컬렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListAndMapMain {
	public static void main(String[] args) {
		List<TestUser> testusers = new ArrayList<>();
		testusers .add(TestUser.builder().username("aaa").password("1234").build());
		testusers .add(TestUser.builder().username("bbb").password("1234").build());
		testusers .add(TestUser.builder().username("ccc").password("1234").build());
		testusers .add(TestUser.builder().username("ddd").password("1234").build());
		testusers .add(TestUser.builder().username("eee").password("1234").build());
		
		System.out.println(testusers);
		
//		Map<String, List<?>> responseData = new HashMap<>();
//		responseData.put("testuserList", testusers);
//		responseData.put("satatusCode", testusers);
		
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("testuserList", testusers);
		responseData.put("satatusCode", "OK");
		
//		System.out.println(responseData);
		for(TestUser testUser : (List<TestUser>)responseData.get("testuserList")) {
			System.out.println(testUser);
		}
		
	}
}
