package com.array.string;

public class ZigZag {

	
	
	
	public String convert_Haili(String s, int nRows){
		if (nRows<=1) return s;
        StringBuffer afterS = new StringBuffer();
        int sLen = s.length();
        int blockSize = nRows*2-2;
        int blockNum = (sLen + blockSize-1)/blockSize;
        for (int i = 0; i<nRows; i++){
            for (int j = 0; j<blockNum; j++){
                //for the first line and the last line
                int start = blockSize*j + i;
                if(start<sLen){
                    afterS.append(s.charAt(start));
                }
                //add the diagnoal elements
                if(i>0 && i<nRows-1){
                    int diagnal = blockSize * (j+1) - i;
                    if(diagnal < sLen ){
                        afterS.append(s.charAt(diagnal));
                    }
                }
            }
        }
        return afterS.toString();
	}
	
	
	public String convert(String s, int nRows) {
        if(s == null)
            return null;
        StringBuffer rst = new StringBuffer();
        int len = s.length();
        if(len <= 0 || nRows <= 1)
            return s;
        
        int blockSize = 2 * nRows - 2, start = 0, vIndex = 0, dIndex = 0;
        int blockCount = (len + blockSize - 1) / blockSize;
        int i = 0, j = 0;
        for(i = 0; i < nRows; i++){
            for(j = 0; j < blockCount; j++){
                start = j * blockSize;
                
                // vertical elements
                vIndex = start + i;
                if(vIndex < len)
                    rst.append(s.charAt(vIndex));
                
                // diagonal elements
                dIndex = start + blockSize - i;
                if(dIndex < len && dIndex < start + blockSize && dIndex > vIndex)
                    rst.append(s.charAt(dIndex));
            } // for : j
        } // for : i
        return rst.toString();
    }

//	P   A   H   N
//	A P L S I I G
//	Y   I   R
	public String convertT(String s, int nRows) {
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
	}
	
	public static void main(String[] args)
	{
		ZigZag z = new ZigZag();
		System.out.println(z.convertT("A", 1) + ", " + z.convert("A", 1));
	}
}
