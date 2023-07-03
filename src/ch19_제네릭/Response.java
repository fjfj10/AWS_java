package ch19_제네릭;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Response<T> {
	private int statusCode;
	private T data;          //Object로 잡으면 제네릭을 쓰지 않아도 되지만 다운캐스팅 필요 제네릭 와일드 카드 사용시 다운캐스팅 필요X
	
}
