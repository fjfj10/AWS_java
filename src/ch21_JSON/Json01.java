package ch21_JSON;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Json01 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("productCode", "P20230704");
		dataMap.put("productname", "아이폰15");
		
		System.out.println(dataMap);
//		Json은 무조건 문자열
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("productCode", "P20230704");
		jsonObject.addProperty("productname", "아이폰15");
		
		System.out.println(jsonObject);
//		Map을 JSON으로 바꿔줄 수 있다.
		System.out.println(gson.toJson(dataMap));
//		JSON을 Map으로 바꿀 수도 있다.
		Map<String, Object> jsonMap = gson.fromJson(jsonObject, Map.class);
		System.out.println(jsonMap.get("productCode"));
//		Map으로 바꿨기 때문에 get을 쓸 수 있다, Object타입이기 때문에 문자열로 쓰려면 다운 캐스팅 필요 
	}
}
