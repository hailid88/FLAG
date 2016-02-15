package com.bit;

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 43261596;
		ReverseBits obj = new ReverseBits();
		System.out.println(obj.reverseBits(n));
		int t = 2;
		for(int i = 0; i<3; i++){
			t = t>>>1;
			System.out.println("t=" + t);
		}
	}
	public int reverseBits(int n) {
        long result = 0;
        StringBuffer r = new StringBuffer();
        int count = 1;
        while(count<=32){
            int lsbit = n&1;
            r.append(lsbit);
            n = n>>1;
            count++;
        }

        System.out.println(r);
        result= Long.parseLong(r.toString(), 2);

        return (int)result;
    }

}
