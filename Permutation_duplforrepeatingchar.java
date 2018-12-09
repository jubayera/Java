package com.practical_research.Permutation;

/*
 * Write a program to print all permutations of a given string
A permutation, also called an “arrangement number” or “order,” is a rearrangement of the elements of an ordered list S 
into a one-to-one correspondence with S itself. A string of length n has n! permutation.
Source: Mathword(http://mathworld.wolfram.com/Permutation.html)

Below are the permutations of string ABC.
ABC ACB BAC BCA CBA CAB

Here is a solution that is used as a basis in backtracking.
 */

public class Permutation_duplforrepeatingchar {

	public static void main(String[] args) {
		
		String str = "ABC";
		int n = str.length();
		Permutation permutation_obj = new Permutation();
		permutation_obj.permute(str, 0, n-1);
	}

	/*
	 * permutation function 
	 * @param str: string to calculate permutation for 
	 * @param l: starting index
	 * @param r: end index 
	 */
	private void permute(String str, int l, int r)
	{
		if(l == r)
			System.out.println(str);
		else
		{
			for(int i = l; i <= r; i++)
			{
				str = swap(str, l, i);
				permute(str, l+1, r);
				str = swap(str, l, i);
			}
		}
	}
	
	/*
	 * Swap characters at position
	 * @param: a string value
	 * @param: i position 1
	 * @param: j position 2
	 * @return: swapped string
	 */
	public String swap(String a, int i, int j)
	{
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
/*
 * Output: Prints duplicate permutations if there are repeating characters in input string.
ABC
ACB
BAC
BCA
CBA
CAB
*/
