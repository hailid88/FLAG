package com.twosigma;


import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class SequenceArithmetic {

	/**
	 * @param args
	 */
	static DecimalFormat df = new DecimalFormat("#.00");
	public static void main(String args[] ) throws Exception {
    	BufferedReader r = null;
        try{
        	// input assumption:
        	//   first line: 1 or 2
        	//   second line: a0 a1 a2 ... an
            r = new BufferedReader(new InputStreamReader(System.in));
            String input = r.readLine();
            int parseType = Integer.parseInt(input.trim());
            if(parseType == 1)
            	determineValues(r.readLine());
            else
            	checkRelation(r.readLine());
            
        } catch(IOException e){
            e.printStackTrace();
        }
        finally{
        	if(r != null)
        		r.close();
        }
        
    }
	
	private static void determineValues(String input){
		String[] splits = (input.trim()).split(" ");
		if(splits.length <= 2)
			throw new RuntimeException("Unable to determine the solution");
		double[] seqs = new double[3];
		int i = 0;
		for(String str : splits){
			seqs[i++] = Double.parseDouble(str);
			if(i >= 3) break;
		}
		double[] KLValues = computeKL(seqs, 0);
		System.out.println(df.format(KLValues[0]) + " " + df.format(KLValues[1]));
	}
	
	
	private static void checkRelation(String input){
		String[] splits = (input.trim()).split(" ");
		if(splits.length <= 2)
			throw new RuntimeException("Unable to determine the solution");
		double[] seqs = new double[splits.length];
		int i = 0;
		for(String str : splits)
			seqs[i++] = Double.parseDouble(str);
		
		List<Double> listArr = new ArrayList<Double>(3);
		listArr.add(seqs[0]); listArr.add(seqs[1]); listArr.add(seqs[2]);
		double[] compNums = new double[3];
		compNums[0] = seqs[0]; compNums[1] = seqs[1]; compNums[2] = seqs[2];
		for(int cas = 0; cas < 4; cas++){
			double[] KLValues = computeKL(compNums, cas); // compute K,L value for each case
			if(checkSeq(KLValues, seqs, cas)){ // check whether this pair can be used for computation
				System.out.println("true");
				return;
			}
		}
		System.out.println("false");
	}
	
	private static boolean checkSeq(double[] KLValues, double[] seqs, int cas){
		for(int i = 0; i < seqs.length - 1; i++){
			switch(cas){
			case 0: // *, +
				if(seqs[i+1] != seqs[i] * KLValues[0] + KLValues[1])
					return false;
				break;
			case 1: // *, -
				if(seqs[i+1] != seqs[i] * KLValues[0] - KLValues[1])
					return false;
				break;
			case 2: // /, +
				if(seqs[i+1] != seqs[i] / KLValues[0] + KLValues[1])
					return false;
				break;
			case 3: // /, -
				if(seqs[i+1] != seqs[i] / KLValues[0] - KLValues[1])
					return false;
				break;
			}
		}
		return true;
	}
	
	private static double[] computeKL(double[] seqs, int cas){
		double[] KLValues = new double[2];
		switch(cas){
		case 0: // *, +
			KLValues[0] = Double.parseDouble(df.format( (seqs[2] - seqs[1]) / (seqs[1] - seqs[0]) )); 
			KLValues[1] = Double.parseDouble(df.format( seqs[1] - KLValues[0] * seqs[0] )); 
			break;
		case 1: // *, -
			KLValues[0] = Double.parseDouble(df.format( (seqs[2] - seqs[1]) / (seqs[1] - seqs[0]) )); 
			KLValues[1] = Double.parseDouble(df.format( KLValues[0] * seqs[0] - seqs[1] ));
			break;
		case 2: // /, +
			KLValues[0] = Double.parseDouble(df.format( (seqs[1] - seqs[0]) / (seqs[2] - seqs[1]) )); 
			KLValues[1] = Double.parseDouble(df.format( seqs[1] - seqs[0] / KLValues[0] ));
			break;
		case 3: // /, -
			KLValues[0] = Double.parseDouble(df.format( (seqs[1] - seqs[0]) / (seqs[2] - seqs[1]) )); 
			KLValues[1] = Double.parseDouble(df.format( seqs[0] / KLValues[0] - seqs[1] ));
			break;
		}
		return KLValues;
	}

}
