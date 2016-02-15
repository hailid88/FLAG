package com.zenefits;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FirstPhoneInterveiw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	



//	// HTML
//	<script src='foo.js'></script>
//
//	// code for foo.js
//	var bar = require('bar.js')
//	bar main = require('main.js')
//
//	// code for bar.js
//	var lib = require('lib.js')
//
//	dep['foo.js'] = ['bar.js', 'main.js']
//	dep['bar.js'] = ['lib.js']
//	dep['lib.js'] = ['foo.js']
//
//	file = foo_js
//	file.title = "foo.js"
//	file.dependencies = ['bar.js', 'main.js']
//
//	getOrder(file) => ['lib.js', 'bar.js', 'main.js', 'foo.js']


//	List<String> getOrder(String file){
//	    List<String> resl = new ArrayList<>();
//	    resl.add(file);
//	    Queue<String> queue = new LinkedList<>();
//	    Set<String> hs = new HashSet<>();
//	    queue.offer(file);
//	    hs.add(file);
//	    while(!queue.isEmpty()){
//	        String temp = queue.poll();
//	        List<String> depds = temp.dependencies;
//	        resl.addAll(depds);
//	        for(String depd:depds){
//	            if(hs.add(depd)){
//	                queue.offer(depd);
//	            }
//	        }
//	    }
//	    return Collections.reverse(resl);
//	}

}

