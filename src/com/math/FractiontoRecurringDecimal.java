package com.math;

import java.util.ArrayList;
import java.util.List;

public class FractiontoRecurringDecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder sb = new StringBuilder();
        long numeratorL = (long)numerator, fraction = numeratorL / denominator;

        if ((numerator < 0 ^ denominator < 0) && numerator != 0 && fraction >= 0) { sb.append('-'); }
        sb.append(fraction);

        if ((numeratorL = numeratorL % denominator * 10) != 0) { sb.append('.'); }

        List<Long> numList = new ArrayList<Long>();
        List<Integer> resultList = new ArrayList<Integer>();

        while (true) {
            int index = numList.indexOf(numeratorL);
            if (index != -1 || numeratorL == 0) {
                for (int i = 0; i < resultList.size(); i++) {
                    if (i == index) { sb.append('('); }
                    sb.append(resultList.get(i));
                }
                if (index != -1) { sb.append(')'); }
                return sb.toString();
            }
            numList.add(numeratorL);
            resultList.add(Math.abs((int) (numeratorL / denominator)));
            numeratorL = numeratorL % denominator * 10;
        }
    }

}
