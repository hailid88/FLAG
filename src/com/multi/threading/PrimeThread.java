package com.multi.threading;

public class PrimeThread{
	public static void main(String[] args){
		PrimeTh p2 = new PrimeTh(111);
		PrimeTh p = new PrimeTh(143);
		PrimeTh p1 = new PrimeTh(133);
		p.start();
		p1.start();
		p2.start();
	}
	
	public static class PrimeTh extends Thread{
		long minPrime;
		PrimeTh(long minPrime){
			this.minPrime = minPrime;
		}
		public void run(){
			System.out.println("next prime of " + minPrime);
		}
	}
}
