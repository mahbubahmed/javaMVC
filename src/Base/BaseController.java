package Base;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
	
	 private String[] uri;
	 Map<String, Object> data = new HashMap <String, Object>();
	 private String View;
	
     public void setValue(Map<String, Object> map)
     {
        this.data = map;
     }
     public Map<String, Object> getValue()
     {
       return this.data;
     }
	
	 public void LoadView(String ViewFileName)
	 {
		 this.View = ViewFileName;
	 }
	
	 public String getView()
	 {
		 return this.View;
	 }
	 
	 
	 public void set_uri(String[] params){

			this.uri = params;
	}
		
	public String[] get_uri()
	{
			return this.uri;
	}
	
}
