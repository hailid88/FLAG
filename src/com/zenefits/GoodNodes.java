package com.zenefits;
import java.util.*;

public class GoodNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> visited = new ArrayList<Integer>(3);
		visited.add(1);
		visited.add(1);
		visited.add(1);
		int curr = 0;
		for(Integer visit:visited){
			if(result(curr++)){
				System.out.println("If");
			}
			System.out.println(curr);
		}


	}
	public static boolean result(int curr){
		return false;
	}
	
	public static int nChangesToMakeAllNodesGood(List<Integer> nodes)
    {
		
        if(nodes.isEmpty())
            return 0;
        
        int n = nodes.size();

        // list of marked items
        List<Integer> visited = new ArrayList<Integer>(n);
        
        
        for(int i = 0; i < n; ++i)
            visited.set(i, -1);
        
        int ncomponents = 1, npass = 0;
        visited.set(0, 0);
        for(int i = 0; i < n; ++i)
        {
            if( isNewComponent(nodes, visited, i, npass++) )
                ++ncomponents;
        }
        
        return ncomponents-1;        
    }
    public static Boolean isNewComponent(List<Integer> nodes_list, List<Integer> visited_list, int i, int cur_pass)
    {
        // delete link from first node: if first node, then it's an old component and return
        if(i == 0)
            return false;

        // found node visited on previous passes: old component
        if(visited_list.get(i) > 0 && visited_list.get(i) != cur_pass )
            return false;
        // found node visited in this pass: new component
        if(visited_list.get(i) == cur_pass)
            return true;
        // current node hasn't been visited: mark as cur_pass
        visited_list.set(i, cur_pass);
        
        return isNewComponent(nodes_list, visited_list, nodes_list.get(i), cur_pass);  
    }

}
