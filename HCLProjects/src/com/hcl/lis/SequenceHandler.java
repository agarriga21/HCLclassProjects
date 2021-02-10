package com.hcl.lis;

import java.util.ArrayList;
import java.util.HashMap;

public class SequenceHandler {
	
public ArrayList<Integer> CreateArrayList(int n)
{
	
	ArrayList<Integer> sequence = new ArrayList<Integer>();
	for(int i =0; n>i; i++) {
		double randomD = Math.random();
		int randomInt = (int) (randomD*100.0);
	sequence.add(randomInt);
	
	}
	
	
	
	return sequence;
	
}

public ArrayList<Integer> SubArray(ArrayList<Integer> seq, int n,int i) {
	 
	
	
	ArrayList<Integer> subseq = new ArrayList<Integer>();
	 
	 
	 subseq.add(seq.get(i));
		
		 for (int j = i+1; n > j; j++ ) {  
                if(seq.get(j)>seq.get(i))  { 
                	subseq.add(seq.get(j));
                	i=j;
                	
                }
			 
			 
                }
			 
			
		 
	 return subseq;
	 }
	 
	
    
public void Compare(ArrayList<Integer> subseq, int n) {
	int i;
	int maxSizeTemp=0;
	int maxSizeFinal=0;
	SequenceHandler sh = new SequenceHandler();
	ArrayList<ArrayList<Integer>> subList = new ArrayList<ArrayList<Integer>>();
	
	for (i = 0; (n) > i; i++ ) {
	subList.add(i, sh.SubArray(subseq, n, i));
		
	}
	for (i = 0; (n) > i; i++ ) {
		//System.out.println(subList.get(i));
		//if(subList.get(i-1).size()>=subList.get(i).size()) 
		//{
		maxSizeTemp=subList.get(i).size();
		if(maxSizeTemp>=maxSizeFinal) {
			maxSizeFinal=maxSizeTemp;
		}
		//}
	
}

	System.out.println(maxSizeFinal);
	for (i = 0; (n) > i; i++ ) {
		if(maxSizeFinal==subList.get(i).size()) {
			System.out.println(subList.get(i));
		}
			
		}
}
}


