package RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpEx {
public static boolean RegEx(String pattern, String content) {
	//Create Pattern
	Pattern p = Pattern.compile(pattern);
	//Create Matcher
	Matcher m = p.matcher(content); 
	if(m.matches()){
		return true;	
	}
	else 
	{
		return false;
	}

}
	public static void main(String[] args) {		
	
		boolean res = RegEx("^[q|Q][a-zA-Z]{3,23}[t|T]$", "qahhbjyrijhknnjhknhdt");
		System.out.println(res);
		boolean res1 = RegEx("^[1-9][0-9]{9}", "1293456708");
		System.out.println(res1);
		boolean res2 = RegEx("^[789][0-9]{9}", "7898905697");
		System.out.println(res2);
			
	}

}
