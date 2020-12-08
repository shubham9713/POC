package com.shubham;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shubham.bindings.Product;

public class JsonToJavaConverter {

	public static void main(String[] args) throws Exception {
		
		ObjectMapper mapper=new ObjectMapper();
		Product p = mapper.readValue(new File("product.json"), Product.class);
		System.out.println(p);
		
	}
}
