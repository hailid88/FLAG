package com.practice;

// There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
// http://oj.leetcode.com/problems/median-of-two-sorted-arrays/

public class MedianTwoSortedArrays {
	
	public static void main(String[] args)
	{
		MedianTwoSortedArrays m = new MedianTwoSortedArrays();
		int[] A = {1, 2, 6};
		int[] B = {3, 4};
		double result = m.findMedianSortedArrays(A, B);
		System.out.println(result);
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
        int lenA = A.length;
        int lenB = B.length;
        int lenCmb = lenA + lenB;
        if(lenCmb % 2 != 0)
        {
            return findKth(A, B, 0, lenA - 1, 0, lenB - 1, lenCmb / 2 + 1);
        }
        else
        {
            return ( findKth(A, B, 0, lenA - 1, 0, lenB - 1, lenCmb / 2) + findKth(A, B, 0, lenA - 1, 0, lenB - 1, lenCmb / 2 + 1) ) / 2;
        }
    } // function
    
    public double findKth(int[] A, int[] B, int startA, int endA, int startB, int endB, int k)
    {
        int lenA = endA - startA + 1;
        int lenB = endB - startB + 1;
        
        if(lenA <= 0)
            return B[k+startB - 1];
        if(lenB <= 0)
            return A[k+startA - 1];
        if(k <= 1)
        	return Math.min(A[0], B[0]);
        
        int midA = A[(startA + endA) / 2];
        int midB = B[(startB + endB) / 2];
        
        if((lenA + lenB) / 2 >= k)
        {
            if(midA >= midB)
            {
            	if(endA == startA)
            		endA = startA - 1;
            	else
            		endA = (startA + endA) / 2;
            }
            else
            {
                if(endB == startB)
                	endB = startB - 1;
                else
                	endB = (startB + endB) / 2;
            }    
        }
        else
        {
            if(midA >= midB)
            {
            	k = k - ((endB - startB)/2 + 1);
                startB = (startB + endB) / 2 + 1;
            }
            else
            {
            	k = k - ((endA - startA)/2 + 1);
                startA = (startA + endA) / 2 + 1;
            }
        }
        
        return findKth(A, B, startA, endA, startB, endB, k);
    }
}
