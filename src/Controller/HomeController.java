package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Base.BaseController;

public class HomeController extends BaseController  {
	

	public void index()
	{	
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<String> myString = new ArrayList<String>();		
		myString.add("This is my First String");
		myString.add("This is my Second String");		
		map.put("view", "Home");
		map.put("fruit", "mango");
		map.put("myArray", myString);	
		setValue(map);
		LoadView("home");
		
	}
	
	
}
