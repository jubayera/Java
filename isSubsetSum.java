package com.practical_research.subsetsum;

/*Recursive Subset Sum. The above solution may try all subsets of given set in worst case. 
Therefore time complexity of the above solution is exponential. 
The problem is in-fact NP-Complete (There is no known polynomial time solution for this problem).*/

public class Subset_Sum_DP 
{
/*
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set 
 * with sum equal to given sum. Example:

		Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
		Output:  True  //There is a subset (4, 5) with sum 9.
		
		Let isSubSetSum(int set[], int n, int sum) be the function to find whether there is a subset of 
		set[] with sum equal to sum. n is the number of elements in set[].

		The isSubsetSum problem can be divided into two subproblems
…		a) Include the last element, recur for n = n-1, sum = sum – set[n-1]
…		b) Exclude the last element, recur for n = n-1.
		If any of the above the above subproblems return true, then return true.

		Following is the recursive formula for isSubsetSum() problem.
		
		isSubsetSum(set, n, sum) = isSubsetSum(set, n-1, sum) || 
                           isSubsetSum(set, n-1, sum-set[n-1])
		Base Cases:
		isSubsetSum(set, n, sum) = false, if sum > 0 and n == 0
		isSubsetSum(set, n, sum) = true, if sum == 0 
		
		Following is naive recursive implementation that simply follows the recursive structure mentioned above.
 */
	
	/*
	 * Returns true if there is a subset of set[] with sum equal to give sum
	 */
	static boolean isSubsetSum(int set[], int n, int sum)
	{
		//Base cases
		if(sum == 0)
			return true;
		if(n == 0 && sum != 0)
			return false;
		
		//If last element is greater than sum, then ignore it
		if(set[n-1] > sum)
			return isSubsetSum(set, n-1, sum);
		
		/*
		 * else, check if sum can be obtained by any of the following 
		 * 		(a) including the last element
		 * 		(b) excluding the last element
		 */
		return isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum-set[n-1]);
	}
	
	public static void main(String[] args) {
		
		int set[] = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		int n = set.length;
		
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset with given sum");
		else
			System.out.println("No subset with given sum");

	}

}
