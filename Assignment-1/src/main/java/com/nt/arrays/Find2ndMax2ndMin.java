package com.nt.arrays;

public class Find2ndMax2ndMin {

	public static void main(String[] args) {
		
		int arr[] = {1, 2, 5, 9, 6, 4, 7, 2};
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
	System.out.println("2nd min::"+arr[1]);
	System.out.println("2nd max::"+arr[arr.length-2]);
		
	}

}
