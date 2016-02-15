package com.sikka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataTable {
	
	Integer ID;
	String name;
	Integer PID;
	Map<Integer, Info> hm = new HashMap<>();    
	//this hashmap is used to save row information. key is the ID, value is the info class containing the information of name and PID.  
	
	public void addRow(Integer ID, String name, Integer PID){
		if(ID == null){
			System.out.println("ID must be unique, null is not permitted");
			return;
		}
		Info newInfo = new Info(name, PID);
		if(hm.containsKey(ID)){
			System.out.println("You are adding the same ID = " + ID + " again, the pervious one is overwritten by current one");
		}
		hm.put(ID, newInfo);
	}
	
	
	//basic version, with time complexity as O(n^2). 
	public Map<String, List<String>> processDataTable() {
		Map<String, List<String>> resl = new HashMap<>();
		if(hm==null || hm.size()<=0) return resl;
		Set<Integer> IDs = hm.keySet();       //return all the unique IDs from hm. 
		for(Integer item:IDs){
			String itemName = hm.get(item).name;             
			Integer itemPID = hm.get(item).PID;	          

			while(itemPID!=null){      //add itemName to the children list of its direct parent and indirect parents 
				String itemPName = hm.get(itemPID).name;
				if(!resl.containsKey(itemPName)){
					resl.put(itemPName, new ArrayList<String>());
				}
				resl.get(itemPName).add(itemName);           
				
				itemPID = hm.get(itemPID).PID;           
			}
		}
		return resl;
	} 
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataTable dt = new DataTable();
	    dt.addRow(0, "A", null);
	    dt.addRow(1, "B", 0);
	    //dt.addRow(null, "G", 0);
	    dt.addRow(2, "C", 0);
	    dt.addRow(4, "D", 1);
	    dt.addRow(5, "E", 1);
	    dt.addRow(6, "F", 4);
	    dt.addRow(3, "G", 0);
	    //dt.addRow(3, "G", 0);
	    System.out.println("Input:");
	    for(Integer ID:dt.hm.keySet()){
	    	 System.out.print(ID);
	    	 System.out.print(", "+ dt.hm.get(ID).name + ", " + dt.hm.get(ID).PID);
	    	 System.out.println();
	    }
	    System.out.println();
	    
	    System.out.println("Output:");
	    System.out.println(dt.processDataTable());
	    
	    System.out.println();
	    System.out.println();
	    
		dt = new DataTable();
	    dt.addRow(0, "A", null);
	    dt.addRow(1, "B", 0);
	    dt.addRow(2, "C", 0);
	    dt.addRow(2, "C", 1);
	    dt.addRow(3, "D", 2);
	    dt.addRow(4, "E", 3);
	    dt.addRow(5, "F", 4);
	    dt.addRow(6, "G", 5);
	    
	    System.out.println("Input:");
	    for(Integer ID:dt.hm.keySet()){
	    	 System.out.print(ID);
	    	 System.out.print(", "+ dt.hm.get(ID).name + ", " + dt.hm.get(ID).PID);
	    	 System.out.println();
	    }
	    System.out.println();
	    
	    //dt.addRow(3, "G", 0);
	    System.out.println("Output:");
	    System.out.println(dt.processDataTable());
	    
	}

}



class Info{
	String name;
	Integer PID;
	public Info(String name, Integer PID){
		this.name = name;
		this.PID = PID;
	}
}




