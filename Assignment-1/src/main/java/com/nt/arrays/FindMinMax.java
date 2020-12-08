package com.nt.arrays;

public class FindMinMax {

	public static void main(String[] args) {
		
		int arr[]= {1, 2, 5, 5, 6, 6, 7, 2};
		
		int max=0;
		int min=0;
		for(int i=0;i<arr.length;i++)
		{
			if(max<arr[i])
			{
				max=arr[i];
			}
	if(min>arr[i])
			{
				min=arr[i];
			}
		}
		System.out.println("max ::"+max+" min::"+min);
	}

}
