package com.hcl.lis;

public class SequenceHandler {
public int[] CreateArray(int n)
{
	
	int[] sequence = new int[n];
	for(int i =0; n>i; i++) {
		double randomD = Math.random();
		int randomInt = (int) (randomD*100.0);
	sequence[i]=randomInt;
	
	}
	
	
	
	return sequence;
	
}



}
