package com.hcl.emailvalid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEmail {
	
	final String regex = "\\w+\\@\\w+\\.\\w+";

	final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
	// final

	public boolean isValid(String s)
	{
		Matcher matcher = pattern.matcher(s);
		boolean isValid;
		if ((matcher.matches()==true)) 
	    		{ 
	    	isValid = true;
	    }  else  { 
	    	isValid = false;
	    }
	    return isValid;  

	}

}
