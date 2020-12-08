package com.shubham;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.shubham.bindings.Customer;

public class Marshaling {

	public static void main(String[] args) throws Exception {
		
		Customer c = new Customer();
		c.setCustomerId(101);
		c.setCustomerName("shubham");
		c.setCustomerEmail("shubh.rsp@gmail.com");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(c, System.out);
	}
}
