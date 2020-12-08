package com.shubham;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shubham.bindings.Product;

public class JavaToJsonConverter {

	public static void main(String[] args) throws Exception {
		
		Product p=new Product();
		p.setProductId(101);
		p.setProductName("fan");
		p.setProductPrice(1500.00);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("product.json"), p);
		/*String jsonStr = mapper.writeValueAsString(p);
		System.out.println(jsonStr);
		*/
	}
}
