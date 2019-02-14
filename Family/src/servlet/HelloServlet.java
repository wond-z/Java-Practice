package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import service.Service;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		List list;
		Service service = new Service();
		list = service.getList();
//		JSONArray ja = new JSONArray();
//		for(int i = 0; i < list.size(); i ++) {
			JSONObject json = new JSONObject();
			json.put("total", list.size());
			json.put("data", list);
			
//		}
//		System.out.println(json.toString());
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");  
		response.getWriter().write(json.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
//		System.out.println("POST Request...");
//
////		Service service = new Service();
////		list = service.addRecord(request);
//		
//		JSONObject json = new JSONObject();
//		json.put("name", request.getParameter("name"));
//		json.put("name", request.getParameter("name"));
//		json.put("name", request.getParameter("name"));
//		json.put("name", request.getParameter("name"));
//		
//		System.out.println();
		
	}

}
