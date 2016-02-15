package com.baseTest;

public class TestBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
//		n=n>>1;
//		System.out.println(n);
//		n>>=1;
//		System.out.println(n);
//		n>>=1;
//		System.out.println(n);
//		n>>=1;
//		System.out.println(n);
//		int x = 0;
//		System.out.println(Integer.toBinaryString(~x<<2));
		
		clearBitsMSBthroughI(5, 2);
		char s = (char)('A'+(n%26)-1);
		System.out.println(s);

	}
	//101;
	//this is try to see the difference between >>> and >>
	
	public static void clearBitsMSBthroughI(int num, int i) {
		System.out.println(Integer.toBinaryString(num));
		int test = num<<i;
		//10100
		System.out.println(Integer.toBinaryString(test));
		int mask = (num<<i) -1;
		System.out.println(Integer.toBinaryString(mask));
		System.out.println(Integer.toBinaryString(num&mask));
		int max = Integer.MAX_VALUE;
		System.out.println(Integer.toBinaryString(max));
		System.out.println(Integer.toBinaryString((max>>28)));
		
	}

}
