package com.nt.arrays;

import java.util.ArrayList;

public class CommonElementAmong3Array {

	public static void main(String[] args) {
		int ar1[] = {1, 5, 10, 20, 40, 80};
		int ar2[] = {6, 7, 20, 80, 100,40};
		int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120,40};
		ArrayList al=new ArrayList();
		int count;
		for(int i=0;i<ar1.length;i++)
		{
			count=0;
			for(int j=0; j<ar2.length; j++)
			{
				for(int k=0; k<ar3.length; k++)
				{
				if(ar1[i]==ar2[j]&&ar2[j]==ar3[k])
				{
					count++;
				}
				}
				
			}
			if(count==1)
			{
				al.add(ar1[i]);
			}
		}
		System.out.println(al);
	}

}
