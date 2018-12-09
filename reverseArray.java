package com.practical_research.reverse_array;

public class reverseArray {
	
	//function to reverse arr[] from start to end
	static void reverseArray_func(int arr[], int start, int end)
	{
		int temp;
		
		while(start < end)
		{
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		
	}
	
	//function to reverse arr[] from start to end recursively
	static void reverseArray_recursive(int arr[], int start, int end)
	{
		int temp;
		
		if(start >= end)
			return;
		
		temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
		reverseArray_recursive(arr, start+1, end-1);
	}
	
	//Utility function to print an array
	static void printArray(int arr[], int n)
	{
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	
		System.out.println();
	}

	public static void main(String[] args) {

		int arr[] = {1, 2, 3, 4, 5, 6};
		
		printArray(arr, 6);
		
		reverseArray_func(arr, 0, 5);
		System.out.print("Reversed array is \n");
		printArray(arr, 6);
		
		reverseArray_recursive(arr, 0, 5);
		
		System.out.print("Reversed array is \n");
		printArray(arr, 6);
	}

}
/*
1 2 3 4 5 6 
Reversed array is 
6 5 4 3 2 1 
Reversed array is 
1 2 3 4 5 6 */
