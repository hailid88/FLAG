package com.array.string;

public class RemoveElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = {4,5};
		RemoveElement object = new RemoveElement();
		int result = object.removeElement(intArray, 4);
		System.out.println(result);

	}
	
	public int removeElement(int[] A, int elem) {
        int Alength = A.length;
        int Blength = Alength;
        for(int i=0; i<Alength; i++){
            if(A[i]==elem){
                Blength--;
            }
        }
        
        return Blength;
    }

}
