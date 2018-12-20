package com.binom;

public class BinomialCoefficient {

	public static void main(String[] args) {

		final int NMAX = 10;
		
		int[][] odds = new int[NMAX + 1][];
		
		for(int n = 0; n <= NMAX; n++)
			odds[n]= new int[n+1]; 
		
		for(int n = 0; n < odds.length; n++)
			for(int k = 0; k < odds[n].length; k++)
			{
				int lotteryOdds = 1;
				for(int i = 1; i <= k; i++)
					lotteryOdds = lotteryOdds * (n-i+1)/i;
				
				odds[n][k]= lotteryOdds; 
			}
		
		for(int n =0 ; n < odds.length; n++)
		{
			for(int k = 0; k < odds[n].length; k++)
			{
				String output = "     " + odds[n][k];
				output = output.substring(output.length()-4);
				System.out.print(output);
			}
			
			System.out.println();
		}
		
	}

}
