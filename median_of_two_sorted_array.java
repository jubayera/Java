package com.median_two_sorted_arrays;

public class Median_of_two_sorted_arrays 
{
	//Median of two sorted arrays of same size
	/*
	 * 2 sorted arrays A and B of size n each, an algorithm to find the median of the array obtained after merging 
	 * the above 2 arrays (i.e. array of length 2n). The complexity should be O(log(n)).
	 */
	static int getMedian(int ar1[], int ar2[], int n)
	{
		int i=0, j=0, count;
		int m1 = -1, m2 = -1;
		
		/*
		 * Since there are 2n elements, median will be average of elements at index n-1 and n
		 * in the array obtained after merging ar1 and ar2
		 */
		for(count = 0; count <= n; count++)
		{
			/*
			 * Below is to handle case where all elements of ar1[] are smaller than smallest(or first) element of ar2[]
			 */
			if(i == n)
			{
				m1 = m2;
				m2 = ar2[0];
				break;
			}
			
			/*
			 * Below is to handle case where all elements of ar2[] are smaller than smallest(or first) element of ar1[]
			 */
			else if(j == n)
			{
				m1 = m2;
				m2 = ar1[0];
				break;
			}
			
			if(ar1[i] < ar2[j])
			{
				//Store the previous median
				m1 = m2;
				m2 = ar1[i];
				i++;
			}
			else
			{
				//Store the previous median
				m1 = m2;
				m2 = ar2[j];
				j++;
			}
		}
		
		return (m1 + m2)/2;
	}
	
	//Driver program to test the above function
	public static void main(String[] args) 
	{
		int ar1[] = {1, 12, 29, 45, 56};
		int ar2[] = {3, 4, 28, 54, 90};
		
		int n1 = ar1.length;
		int n2 = ar2.length;
		
		if(n1 == n2)
			System.out.println("Median is " + getMedian(ar1, ar2, n1));
		else
			System.out.println("arrays are of unequal size");
			
	}

}
