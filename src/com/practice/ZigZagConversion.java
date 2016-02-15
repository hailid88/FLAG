package com.practice;


/**
 * http://oj.leetcode.com/problems/zigzag-conversion/
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 * @author Clarence
 *
 */

/**
 * Solution: 
 * @author Clarence
 *
 */

public class ZigZagConversion {
	public static String convert(String s, int nRows) {
        if (nRows <= 1)
            return s;
        int lens = s.length();
        
        // get the size of each zigzag
        int blockSize = 2 * nRows - 2;
        
        // get the number of zigzag
        int blockCount = (lens + blockSize - 1) / blockSize;
        StringBuffer buf = new StringBuffer();
        int i, j;
        int start, i1, i2;
        for (i = 0; i < nRows; i++) {
            for (j = 0; j < blockCount; j++) {		
            	// each block include the elements in the vertical and 
            	// element in the diagonal
                start = j * blockSize;
                
                // the element in the vertical
                i1 = start + i;
                if (i1 < lens)
                    buf.append(s.charAt(i1));
                
                // the element in the diagonal
                i2 = start + blockSize - i;	
                if (i2 < lens && i2 < start + blockSize && i2 > i1)
                {
                    buf.append(s.charAt(i2));
                    System.out.println("i2="+s.charAt(i2));
                }
            }
        }
        return buf.toString();
    } // function
	
	public static void main(String[] args)
	{
		System.out.println(convert("abcdefghi", 4));
	}
}













