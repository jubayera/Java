package com.practical_research.largest_subarray_sum;

import java.io.*;
import java.util.*;

public class Maximum_SubArray_Sum {

	static int maxSubArraySum(int a[]) 
	{
			int size = a.length;
			int max_so_far = Integer.MIN_VALUE, 
					max_ending_here = 0;
			
			for(int i = 0; i < size; i++)
			{
				max_ending_here = max_ending_here + a[i];
				
				if(max_so_far < max_ending_here)
					max_so_far = max_ending_here;
				
				if(max_ending_here < 0)
					max_ending_here = 0;
			}
			
			return max_so_far;
	}
	
	static int maxSubArraySum(int a[], int size)
	{
		int max_so_far = 0, max_ending_here = 0;
		
		for(int i = 0; i < size; i++)
		{
			max_ending_here += a[i];
			
			if(max_ending_here < 0)
				max_ending_here = 0;
			
			/*
			 * Do not compare for all elements. Compare only when max_ending_here > 0
			 */
			else if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		
		return max_so_far;
	}
	
	static int maxSubArraySum_On_DynamicProgramming(int a[], int size)
	{
		int max_so_far = a[0];
		int curr_max = a[0];
		
		for(int i = 1; i < size; i++)
		{
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		
		return max_so_far;
	}
	
	static void maxSubArraySum_with_IndexRange(int a[], int size)
	{
		int max_so_far = Integer.MIN_VALUE, 
			max_ending_here = 0, start = 0,
			end = 0, s = 0;
		
		for(int i = 0; i < size; i++)
		{
			max_ending_here += a[i];
			
			if(max_so_far < max_ending_here)
			{
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}
			
			if(max_ending_here < 0)
			{
				max_ending_here = 0;
				s = i + 1;
			}
		}
		
		System.out.println("Maximum contiguous sum is " + max_so_far);
		System.out.println("Starting index: " + start + " Ending index: " + end);
	}
	
	//Driver program to test the above function
	public static void main(String[] args) 
	{
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};		
		
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
		
		int n = a.length;
		
		int max_sum = maxSubArraySum(a, n);
		
		System.out.println("Maximum contiguous sum is " + max_sum);
		
		max_sum = maxSubArraySum_On_DynamicProgramming(a, n);
		
		System.out.println("Maximum contiguous sum is " + max_sum);
		
		maxSubArraySum_with_IndexRange(a, n);

	}

}
