package examTest2.test1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Product {
	private int serialNumber;
	private String productType;
	private String productName;
	private int price;
}

public class ProductMain {
	public static void main(String[] args) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Product product = new Product(2001, "Laptop", "Samsung GalaxyBook", 1400000);
		System.out.println(gson.toJson(product));
	}
	
}
