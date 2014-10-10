package Base;

import javax.servlet.http.HttpSession;

public class ModelAndView {
	
	private static String key;
	private static String value;
	
	public static void addAttribute(String getkey, String getvalue)
	{
		key = getkey;
		value = getvalue;
		
	
	}
}
