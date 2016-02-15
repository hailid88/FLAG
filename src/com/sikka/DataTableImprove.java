package com.sikka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class DataTableImprove {
	
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
	
	
	//improved version, with time complexity as O(n). 
	public Map<String, List<String>> processDataTable() {
		Map<String, List<String>> resl = new HashMap<>();
		if(hm==null || hm.size()<=0) return resl;
		Set<Integer> IDs = hm.keySet();       //return all the unique IDs from hm. 
		
		for(Integer item:IDs){
			String itemName = hm.get(item).name;             
			Integer itemPID = hm.get(item).PID;
			if(itemPID!=null){
				//ArrayList<Integer> PIDs = 
			}

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
		DataTableImprove dt = new DataTableImprove();
	    dt.addRow(0, "A", null);
	    dt.addRow(1, "B", 0);
	    //dt.addRow(null, "G", 0);
	    dt.addRow(2, "C", 0);
	    dt.addRow(4, "D", 1);
	    dt.addRow(5, "E", 1);
	    dt.addRow(6, "F", 4);
	    dt.addRow(3, "G", 0);
	    //dt.addRow(3, "G", 0);
	    System.out.println("Output:");
	    System.out.println(dt.processDataTable());
	    
	}
	
	
}


class ID_Parents{
	Integer ID;
	List<Integer> PIDs;
	public ID_Parents(Integer ID, List<Integer> PIDs){
		this.ID = ID;
		this.PIDs = PIDs;
	}
}