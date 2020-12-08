package java8;

public class FormatString {

	public static void main(String[] args) {
		
	
	String input = "123456789";
	 
	String number = input.replaceFirst("(\\d{3})(\\d{2})(\\d{4})", "$1-$2-$3");
	 
	System.out.println(number);
	

	

}}