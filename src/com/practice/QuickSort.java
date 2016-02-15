package com.practice;

public class QuickSort {

	public static void main(String[] args) {

        int[] a = { 1, 23, 45, 2, 8, 134, 9, 4, 2000 };
        //int a[]={23,44,1,2009,2,88,123,7,999,1040,88};
        int aLen=a.length;
        QuickSort s = new QuickSort();
        s.quickSort(a, 0, aLen - 1);
        for (int i=0; i<aLen; i++)
        {
        	System.out.print(a[i] + ",");
        }
        //ArrayList al = new ArrayList();
    }

    public void quickSort(int[] a, int p, int r)
    {
        if(p < r)
        {
            int q=partition(a,p,r);
            quickSort(a,p,q);
            quickSort(a,q+1,r);
        }
    }

    private int partition(int[] a, int p, int r) {

	//get the first element in array as the pivot. 
        int x = a[p];
        
        int i = p-1 ;
        
        int j = r+1 ;

        while (true) {
            i++;
            while ( i< r && a[i] < x)
                i++;
            
            j--;
            while (j>p && a[j] > x)
                j--;

            //swap the element of a[i] and a[j]. 
            if (i < j)
                swap(a, i, j);
            else
                return j;
        }
    }

    private void swap(int[] a, int i, int j) {
        // TODO Auto-generated method stub
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
