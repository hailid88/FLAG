package com.bloomberg;

public class PrintDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num1 = {2, 3, 5, 8, 10, 20};
		int[] num2 = {3, 8, 11, 30};
		PrintDuplicate obj = new PrintDuplicate();
		obj.printDup(num1, num2);

	}
	
	public void printDup(int[] num1, int[] num2){
		int l1 = 0;
		int l2 = 0;
		while(l1<num1.length && l2<num2.length){
			if(num1[l1]<num2[l2]){
				l1++;
			}
			else if(num1[l1]>num2[l2]){
				l2++;
			}
			else{
				System.out.println(num1[l1]);
				l1++;
			}
		}
	}

}
