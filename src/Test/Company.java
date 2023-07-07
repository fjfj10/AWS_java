package Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.google.gson.Gson;
@Builder
@Data
@AllArgsConstructor
class CompanyData {
	private int companyId;
	private String companyName;
	private String address;
	private String city;
	private String state;
	private String zipCode;

}

public class Company {
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		CompanyData companyData = CompanyData.builder()
				.companyId(100)
				.companyName("Apple")
				.address("Apple Computer Inc. 1 infinite Loop")
				.city("Cupertino")
				.state("CA")
				.zipCode("95014")
				.build();
		
		String company = gson.toJson(companyData);
		System.out.println(company);
	}
}