package examTest2.test1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Company {
	private int companyId;
	private String companyName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
}



public class CompanyMain {
	public static void main(String[] args) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Company company = new Company(100, "Samsung", "137-12번지", "부산", "dd", "aa");
		System.out.println(gson.toJson(company));
		
		
	}

}
