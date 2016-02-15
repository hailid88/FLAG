package com.dynamicprogramming;

public class MatrixProductParenthesization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Matrix product parenthesization
	 * doing (XY )Z or X(Y Z)?
to figure out how to best multiply Ai ¡Á . . . ¡Á Aj , we just consider all possible middle 
points k and select the one that minimizes:
optimal cost to multiply Ai . . .Ak ¡û already computed
+ optimal cost to multiply Ak+1 . . .Aj ¡û already computed
+ cost to multiply the results. ¡û get this from the dimensions
This just takes O(1) work for any given k, and there are at most n different values k to
consider, so overall we just spend O(n) time per subproblem. So, if we use Dynamic Programming
to save our results in a lookup table, then since there are only O(n2) subproblems
we will spend only O(n3) time overall.
	 */

}
