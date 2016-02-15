package com.tree.graphs;
import java.util.*;

public class BFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GraphNode n = new GraphNode(3);
		GraphNode n1 = new GraphNode(2), n2 = new GraphNode(1), n3 = new GraphNode(4);
		n.ajacentNodes.add(n1);
		n1.ajacentNodes.add(n);
		n.ajacentNodes.add(n2);
		n2.ajacentNodes.add(n);
		n.ajacentNodes.add(n3);
		n3.ajacentNodes.add(n);
		GraphNode n4 = new GraphNode(100);
		n1.ajacentNodes.add(n4);
		n4.ajacentNodes.add(n1);
		
		BFS obj = new BFS();
		int result = obj.bfs(n, n4);
		System.out.println(result);

	}
	
	//bfs return the steps from source to dest. 
	public int bfs(GraphNode source, GraphNode dest){
		if(source == dest) return 0;
		int steps = 0;
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		source.visit = true;
		queue.offer(source);
		while(!queue.isEmpty()){
			GraphNode r = queue.poll();
			steps++;
			for(GraphNode i : r.ajacentNodes){
				if(i == dest) return steps;
				if(i.visit==false){
					i.visit = true;
					queue.offer(i);
				}
			}
		}
		return Integer.MAX_VALUE;
	}

}



