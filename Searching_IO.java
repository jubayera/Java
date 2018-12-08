package com.practical_research.first;

import java.util.Scanner; //program uses class scanner

public class PrintClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create Scanner to obtain inout from command window
		Scanner input = new Scanner(System.in);
		
		int number1, number2, sum;
		
		System.out.print("Eneter first integer: ");
		number1 = input.nextInt(); //read first number from user
		
		System.out.print("Eneter second integer: ");
		number2 = input.nextInt(); //read second number from user
		
		sum = number1 + number2; 
		
		System.out.printf("Sum is %d\n", sum); //display sum
		
		LinearSearch obj_linear_search = new LinearSearch();
		int arr_random[] = {34, 56, 12, 54, 78};
		int element = 54;
		int random_arr_length = arr_random.length;
		int linear_search_result = obj_linear_search.search(arr_random, random_arr_length-1, element);
		if(linear_search_result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index " + linear_search_result);
		
		BinarySearch obj_binary_search = new BinarySearch();
		int arr[] = {2,3,4,10,40};
		int n = arr.length;
		int x = 3;
		int result = obj_binary_search.binarySearch(arr, 0, n-1, x);
		if(result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index " + result);
		
	}

}

package com.practical_research.first;

public class LinearSearch {
	
	static int search(int arr[], int n, int x)
	{
		for(int i = 0; i < n; i++)
		{
			if(arr[i] == x)
				return i;
		}
		
		//return -1 if the element is not found
		return -1;
	}

}

package com.practical_research.first;

//Recursive Binary Search
public class BinarySearch {

	//Returns index of x if it is present in arr[l..r], else return -1
	int binarySearch(int arr[], int l, int r, int x)
	{
		if(r >= l)
		{
			int mid = l + (r - l)/2;
			
			//if the element is present at the middle itself
			if(arr[mid] == x)
				return mid;
			
			//if element is smaller than mid, then it can only be present in left subarray
			if(arr[mid] > x)
				return binarySearch(arr, l, mid-1, x);
			
			//else the element can only be present in right subarray
			return binarySearch(arr, mid+1, r, x);
		}
		
		//we reach here when element is not present in array
		return -1;
	}
}
