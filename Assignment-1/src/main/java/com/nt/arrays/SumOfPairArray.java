package com.nt.arrays;

public class SumOfPairArray {

	public static void main(String[] args) {
		
		int arr[]= {3, 6, 8, -8, 10, 8 } ;
		
		
		for(int i=0;i<arr.length;i++)
		{
			
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]+arr[j]==16)
				{
					System.out.println(arr[i]+","+arr[j]);
				}
				
			}
			
		}

	}

}
