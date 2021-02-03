package com.hcl.emailvalid;

import java.util.Arrays;

public class EmailGenerator {
	private String emaillist[] = new String[20];
	
	public void GetEmailList() {
		CreateList();
		PrintList();
	}
	public boolean inArray(String s)
	{	
		String lowercased = s.toLowerCase();
		CreateList();
		boolean result = Arrays.stream(emaillist).anyMatch(lowercased::equals);
		
	    return result;  

	}
	private void CreateList() {
	emaillist[0]="johndoe@yahoo.com";
	emaillist[1]="legend345@gmail.com";	
	emaillist[2]="djones@eru.edu";
	emaillist[3]="melvin.gonzales@yahoo.com";
	emaillist[4]="georgetheman3@aol.com";
	emaillist[5]="jkurst5@gmail.com";
	emaillist[6]="urus43@microsoft.com";
	emaillist[7]="davishome@att.net";
	emaillist[8]="pauljenk2@gmail.com";
	emaillist[9]="garydjsam3@aol.com";
	emaillist[10]="texasman5@yahoo.com";
	emaillist[11]="timleke4@gmail.com";
	emaillist[12]="Jamesgarfield3@yahoo.com";
	emaillist[13]="Jake435@gmail.com";
	emaillist[14]="melissabarn3@yahoo.com";
	emaillist[15]="georgelopez43@aol.com";
	emaillist[16]="giberson55@yahoo.com";
	emaillist[17]="frankybob0@gmail.com";
	emaillist[18]="tonyl32@yahoo.com";
	emaillist[19]="carguy@att.net";
	
	}
	private void PrintList() {
		System.out.println("List of emails in this array:");
		System.out.println("|-----------------------------------------------------------------------------------------------|");
		int x = 0;
		for (int i = 0; i < 5; i++) {
			StringBuffer buffer = new StringBuffer("");	
		buffer.append("|");
			
			for (int j = 0; j < 4; j++) {
				buffer.append(" " + String.valueOf(emaillist[x])+ " ");
				x++;
			}
			
			System.out.println(buffer.toString());
		}
		System.out.println("|-----------------------------------------------------------------------------------------------|");
		System.out.println("note:emails are made up");
	}
	}
	


