package com.nt.arrays;

public class ThirdLargestArray {

	public static void main(String[] args) {
		
		int arr[] = { 6, 8, 1, 9, 2, 1, 10};
		int temp;
	for(int i=0;i<arr.length;i++)
	{
		for(int j=i+1;j<arr.length;j++)
		{
			if(arr[i]>arr[j])
			{
				temp = arr[i];
	               arr[i] = arr[j];
	               arr[j] = temp;
			}

			
		}
		
	}
	
	System.out.println("3rd max::"+arr[arr.length-3]);
		
	}

}
