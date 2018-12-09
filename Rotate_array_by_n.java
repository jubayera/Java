package com.practical_research.array_n_rotation;

public class Rotate_array_by_n 
{
	/*
	 * A function rotate(arr[], d, n) that rotates arr[] of size n by d elements.
	 * Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n = 7
	 * Method 1: Time complexity O(n)
	 * 
	 * (1) Store d elements in a temp array;  temp[] = [1, 2]
	 * (2) Shift rest of the arr[];   arr[] = [3, 4, 5, 6, 7]
	 * (3) Store back the d elements;   arr[] = [3, 4, 5, 6, 7, 1, 2] 
	
	 * Method 2: (Rotate one by one)
	 * 
	 * leftRotate(arr[], d, n)
	 * start
	 * 		For i = 0 to i < d
	 * 			Left rotate all elements of arr[] by one
	 * end
	 * To rotate by one, store arr[0] in a temporary variable temp, move arr[1] to arr[0], arr[2] to arr[1]
	 * and finally temp to arr[n-1]
	 * Ex: arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2
	 * Rotate arr[] by one 2 times.
	 * We get [2, 3, 4, 5, 6, 7, 1] after first rotation and [3, 4, 5, 6, 7, 1, 2] after second rotation.
	 */
	
	//Function to left rotate arr[] by one
	void leftRotatebyOne(int arr[], int n)
	{
		int i, temp;
		temp = arr[0];
		
		for(i = 0; i < n-1; i++)
		{
			arr[i] = arr[i + 1];
		}
		
		arr[i] = temp;
	}
	
	//Function to left rotate arr[] of size n by d
	void leftRotate(int arr[], int d, int n)
	{
		for(int i = 0; i < d; i++)
		{
			leftRotatebyOne(arr, n);
		}
	}
	
	//Utility function to print an array
	void printArray(int arr[], int n)
	{
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void main(String[] args) 
	{
		Rotate_array_by_n rotate = new Rotate_array_by_n();
		
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		
		int arr_size = arr.length;
		int d = 2; //rotate by 2
		
		rotate.leftRotate(arr, d, arr_size);
		
		rotate.printArray(arr, arr_size);
	}

}

//Output: 3 4 5 6 7 1 2 
