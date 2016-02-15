package com.array.string;

public class MajorityElement {

	/**
	 * @param args
	 * Problem 4. Assume you have an array A[1...n] of n elements. A majority element
of A is any element occurring in more than n=2 positions (so if n = 6 or n = 7, any
majority element will occur in at least 4 positions). Assume that elements cannot
be ordered or sorted, but can be compared for equality. (You might think of the
elements as chips, and there is a tester that can be used to determine whether or
not two chips are identical.) 
Design an efficient divide and conquer algorithm to find a majority element in
A (or determine that no majority element exists).
Aim for an algorithm that does O(nlgn) equality comparisons between the elements.
A more difficult O(n) algorithm is possible, but may be difficult to find.
Solution. A O(nlogn) running time divide and conquer algorithm:
The algorithm begins by splitting the array in half repeatedly and calling itself
on each half. This is similar to what is done in the merge sort algorithm. When
we get down to single elements, that single element is returned as the majority of
its (1-element) array. At every other level, it will get return values from its two
recursive calls.
The key to this algorithm is the fact that if there is a majority element in the
combined array, then that element must be the majority element in either the left
half of the array, or in the right half of the array. There are 4 scenarios:
a. Both return "no majority". Then neither half of the array has a majority
element, and the combined array cannot have a majority element. Therefore,
the call returns "no majority."
b. The right side is a majority, and the left isn't. The only possible majority for
this level is with the value that formed a majority on the right half, therefore,
just compare every element in the combined array and count the number of
elements that are equal to this value. If it is a majority element then return
that element, else return "no majority."
c. Same as above, but with the left returning a majority, and the right returning
"no majority."
d. Both sub-calls return a majority element. Count the number of elements equal
to both of the candidates for majority element. If either is a majority element
in the combined array, then return it. Otherwise, return "no majority."
The top level simply returns either a majority element or that no majority element
exists in the same way.
To analyze the running time, we can first see that at each level, two calls are
made recursively with each call having half the size of the original array. For the
non-recursive costs, we can see that at each level, we have to compare each number
at most twice (which only happens in the last case described above). Therefore,
the non-recursive cost is at most 2n comparisons when the procedure is called with
an array of size n. This lets us upper bound the number of comparisons done by
T(n) defined by the recurrence T(1) = 0 and
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int majorityElement(int[] num) {
        int len = num.length;
        int count = 1;
        int majorityElement = num[0];
        for (int i = 1; i < len; i++) {
            if (count == 0)
                majorityElement = num[i];
            if (num[i] == majorityElement) 
                count++;
            else
                count--;
        }
        count = 0;
        for (int i = 0; i < len; i++)
            if (num[i] == majorityElement)
                count++;
        if (count > len/2)
            return majorityElement;
        return -1;
    }
	
	

	
	

}
