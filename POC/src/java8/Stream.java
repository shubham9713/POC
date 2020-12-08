package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

	public static void main(String[] args) {
	
		List<Integer> l1=new ArrayList<>();
		l1.add(10);
		l1.add(15);
		l1.add(20);
		l1.add(25);
		l1.add(30);
		l1.add(35);
		System.out.println(l1);
		List<Integer> l2 = l1.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println(l2);
		List<Integer> l3 = l1.stream().map(i->i+5).collect(Collectors.toList());
		System.out.println(l3);
	}

}
