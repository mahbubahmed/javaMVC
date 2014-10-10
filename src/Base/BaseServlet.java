package Base;


import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;









@WebServlet(description = "The main servlet to controller all the operation", urlPatterns = { "/"})
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Object b ;
 
    public BaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HomeController myController = new HomeController();
		//String controllerOutput = myController.index();
		
		PrintWriter out = response.getWriter();
		//out.println(controllerOutput);
		//out.flush();
		
		StringBuffer requestURL = request.getRequestURL();
		if (request.getQueryString() != null) 
		{
		    requestURL.append("?").append(request.getQueryString());
		}			
		String completeURL = requestURL.toString().trim();
		String base_url = "http://localhost:8080/BoomMVC/";
		String uri = completeURL.replace(base_url, "");		
		String[] controller_and_uri_segment = uri.split("/");
		String ControllerName = controller_and_uri_segment[0];		
		String[] uri_segment = Arrays.copyOfRange(controller_and_uri_segment, 1, controller_and_uri_segment.length);
		String ControllerMethodName = uri_segment[0];
		

	    try {
	    	/*
	    	// WOrking Part
	    	Class<?> clazz = Class.forName("Controller."+ controllerName);           
	    	Object obj = clazz.newInstance();	    	
	    	Method method = clazz.getMethod(uri_segment[0]);
	    	String returnValue = (String) method.invoke(obj, null);		    	    	
	    	request.getRequestDispatcher("/WEB-INF/"+ returnValue + ".jsp").include(request, response);
	    	// End of WOrking Part
	    	*/
	    	Class<?> clazz = Class.forName("Controller."+ ControllerName);           
	    	Object obj = clazz.newInstance();	    	
	    	Method Targetmethod = clazz.getMethod(ControllerMethodName);
	    	Targetmethod.invoke(obj, null);
	    		    	
	    	Method methodGetViewFile = clazz.getMethod("getView");
	    	String ViewFile = (String) methodGetViewFile.invoke(obj, null);
	    	
	    	
	    	Method ValuesSetByUsers = clazz.getMethod("getValue");
	    	Map data = (Map) ValuesSetByUsers.invoke(obj);
	    	
	    	for(int i = 0; i < data.keySet().size(); i++)
	    	{
	    		String s = (String) data.keySet().toArray()[i];
	    		request.setAttribute( s , data.get( data.keySet().toArray()[i] ));	    		
	    	}
	       	request.getRequestDispatcher("/WEB-INF/"+ ViewFile + ".jsp").include(request, response);
	    	
	    	
	    	/*Class<?> clazz = Class.forName("Controller."+ controllerName);           
	    	Object obj = clazz.newInstance();	    	    	
	    	Class[] paramTypes = new Class[1];	    	
	    	paramTypes[0]=String.class;
	    	Method method = clazz.getDeclaredMethod(uri_segment[0],paramTypes);
	    	String returnValue = (String) method.invoke(obj, "sr");	    	 
	    	out.println(returnValue);*/
	    	 
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
