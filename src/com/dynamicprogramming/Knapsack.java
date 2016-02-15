package com.dynamicprogramming;

public class Knapsack {

	/**
	 * @param args
	 * 
Imagine you have a homework assignment with different parts labeled A through G. Each
part has a ¡°value¡± (in points) and a ¡°size¡± (time in hours to complete). For example, say
the values and times for our assignment are:
------------------------------
      A  B  C  D  E  F  G
value 7  9  5  12 14 6  12
time  3  4  2  6  7  3  5

Say you have a total of 15 hours. If there was partial credit that was proportional to the amount of work done (e.g., one hour spent 
on problem C earns you 2.5 points) then the best approach is to work on problems in order of 
points/hour (a greedy strategy).

What if there is no partial credit. 

Definition 2 In the knapsack problem we are given a set of n items, where each item i
is specified by a size si and a value vi. We are also given a size bound S (the size of our
knapsack). The goal is to find the subset of items of maximum total value such that sum of
their sizes is at most S (they all fit into the knapsack).


// Recursive algorithm: either we use the last element or we don't.
Value(n,S) // S = space left, n = # items still to choose from
{
	if (n == 0) return 0;
	if (s_n > S) result = Value(n-1,S); // can't use nth item
	else result = max{v_n + Value(n-1, S-s_n), Value(n-1, S)};
	return result;
}

Right now, this takes exponential time. But, notice that there are only O(nS) different pairs
of values the arguments can possibly take on, so this is perfect for memoizing. As with the
LCS problem, let us initialize a 2-d array arr[i][j] to ¡°unknown¡± for all i,j.

Value(n,S)
{
	if (n == 0) return 0;
	if (arr[n][S] != unknown) return arr[n][S]; // <- added this
	if (s_n > S) result = Value(n-1,S);
	else result = max{v_n + Value(n-1, S-s_n), Value(n-1, S)};
	arr[n][S] = result; // <- and this
	return result;
}

Since any given pair of arguments to Value can pass through the array check only once, and
in doing so produces at most two recursive calls, we have at most 2n(S + 1) recursive calls
total, and the total time is O(nS).

So far we have only discussed computing the value of the optimal solution. How can we get
the items? As usual for Dynamic Programming, we can do this by just working backwards:
if arr[n][S] = arr[n-1][S] then we didn¡¯t use the nth item so we just recursively work
backwards from arr[n-1][S]. Otherwise, we did use that item, so we just output the nth
item and recursively work backwards from arr[n-1][S-s n]. One can also do bottom-up
Dynamic Programming.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = {7,9,5,12,14,6,12};
		int[] wt ={3,4,2,6,7,3,5};
		int W = 15;
		Knapsack obj = new Knapsack();
		System.out.println(obj.knapsack(val, wt, W));
		
		int[] weight = {6, 3, 4, 2}, value = {30, 14, 16, 9};
		int cap = 10;
		System.out.println(obj.getMaxValueR(value, weight, cap) + "\n" + obj.getMaxWithoutR(value, weight, cap));
	}
	
	
	//this is top down method. 
	public int knapsack(int val[], int wt[], int W){ 
		int n = val.length;
		int[][] result = new int[n][W + 1];
		return value(n, val, wt, W, result);
	}
	
	//recursive. Since we can find that only n*lW need to be recorded.
	
	public int value(int n, int val[], int wt[], int lW, int[][] arr){
		int result = 0;
		if(n <= 0) return 0;
		
		if(arr[n-1][lW] != 0) 
			return arr[n-1][lW];
		
		if(wt[n-1] > lW) 
			result = value(n-1, val, wt, lW, arr);
		else 
			result = Math.max(value(n-1, val, wt, lW, arr), val[n-1] + value(n-1, val, wt, lW-wt[n-1], arr));
		
		arr[n-1][lW] = result;
		return result;
	}
	
	
	//this is bottom up method and without repetition. 
	public int getMaxWithoutR(int[] val, int[] wt, int W){
		if(wt==null || wt.length<=0 || val==null || val.length<=0 || wt.length!=val.length || W<=0) return 0;
		int n = val.length;
		int[][] dp = new int[n+1][W+1];
		//int[][] dp = new int[W+1][n+1];
		for(int i = 1; i<=n; i++){
			for(int j = 1; j<=W; j++){
				if(wt[i-1]<=j){
					dp[i][j] = Math.max(dp[i-1][j-wt[i-1]] + val[i-1], dp[i-1][j]);
				}
				else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][W];
	}
	
	
	//What if the elements are infinity, we can repeatly get the item. 
	public int getMaxValueR(int[] val, int[] wt, int W){
		if(wt==null || wt.length<=0 || val==null || val.length<=0 || wt.length!=val.length || W<=0) return 0;
		int n = val.length;
		int[] dp = new int[W+1];  //dp is used to record for the corresponding weight, the max value. 
		for(int i = 1; i<=W; i++){
			for(int j=0; j<n; j++){
				if(wt[j]<=i){
					dp[i] = Math.max(dp[i-wt[j]]+val[j], dp[i]);
				}
			}
		}
		return dp[W];
		
	}
	
	
	
	// As LCS problem. To find the item we have picked, we can do this by working backwards. If arr[n][lW] = arr[n-1][lW], 
	// then we did not use the nth item so we just recursively work backwards from arr[n-1][S]. Otherwise, we did use that item, 
	// so we just output the nth item and recursively work backwards from arr[n-1][lW-wt[n-1]]. 

}
