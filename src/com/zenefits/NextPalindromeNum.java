package com.zenefits;

public class NextPalindromeNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] num = {3, 2, 0};
		int n = 3;
		
		if(allNine(num, n)){
			int[] resl = new int[n+1];
			resl[0] = 1;
			resl[n] = 1;
			for(int i = 1; i<n; i++){
				resl[i] = 0;
			}
		}
		
		generateNextPalindrome(num, n);
		for(int i = 0; i<n; i++){
			System.out.println(num[i]);
		}

	}
	
	
	public static boolean allNine(int[] num, int n){
		for(int i = 0; i<n; i++){
			if(num[i]!=9){
				return false;
			}
		}
		return true;
	}
	
	
	//here n is number of elements in num. 
	public static void generateNextPalindrome(int num[], int n){
		
		int mid = n/2;
		boolean leftSmaller = false;
		int i = mid - 1;
		int j = (n%2==1)?mid+1:mid;
		
		while(i>=0 && num[i]==num[j]){
			i--;
			j++;
		}
		
		if(i<0 || num[i]<num[j]){
			leftSmaller = true;
		}
		
		//copy the mirror of left to right. 
		while(i>=0){
			num[j]=num[i];
			j++;
			i--;
		}
		
		//handle the case where middle digit must be increment. 
		
		if(leftSmaller){
			int carry = 1;
			i = mid-1;
			if(n%2 == 1){
				num[mid] +=carry;
				carry = num[mid]/10;
				num[mid]%=10;
				j = mid+1;
			}
			else
				j = mid;
			while(i>=0 && carry>=1){
				num[i] +=carry;
				carry = num[i]/10;
				num[i]%=10;
				num[j++]=num[i--];
			}
		}
	}

}
