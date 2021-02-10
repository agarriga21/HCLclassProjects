package com.hcl.lis;

import java.util.ArrayList;
import java.util.Arrays;

public class LongIncSubMain {

	public static void main(String[] args) {
		int n = 10;
		SequenceHandler sh = new SequenceHandler();
		ArrayList<Integer> mySequence = sh.CreateArrayList(n);
		
		
		
		ArrayList<Integer> mySub =sh.SubArray(mySequence, n,0);
		
		System.out.println(mySequence);
		//System.out.println(mySub);
		sh.Compare(mySequence, n);
		
	}

}
