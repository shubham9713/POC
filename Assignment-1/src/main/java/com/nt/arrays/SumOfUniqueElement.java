package com.nt.arrays;

public class SumOfUniqueElement {

	public static void main(String[] args) {
		
		int arr[]= {1, 6, 4, 3, 2, 2, 3, 8, 1};
		
		int count;
		int sum=0;
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
				sum=sum+arr[i];
			}
		}
		System.out.println(sum);
	}

}
