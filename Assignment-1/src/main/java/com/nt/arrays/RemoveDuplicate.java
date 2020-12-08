package com.nt.arrays;

import java.util.ArrayList;

public class RemoveDuplicate {

	public static void main(String[] args) {
		int arr[]= {1, 2, 5, 5, 6, 6, 7, 2};
		ArrayList al=new ArrayList();
		int count;
		for(int i=0;i<arr.length;i++)
		{
			count=0;
			for(int j=i+1; j<arr.length; j++)
			{
				if(arr[i]==arr[j])
				{
					count++;
				}
				
			}
			if(count==0)
			{
				al.add(arr[i]);
			}
		}
		System.out.println(al);
	}

}
