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
		int offset = Integer.parseInt(request.getParameter("offset"));
		int size = Integer.parseInt(request.getParameter("size"));

		Service service = new Service();
		list = service.getList(offset, size);
		int count = service.getPageCount();
		
		
		JSONObject json = new JSONObject();
		json.put("total", count);
		json.put("data", list);
//		System.out.println(json.toString());
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-type", "application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");  
		response.getWriter().print(json.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("POST Request...");

//		Service service = new Service();
//		list = service.addRecord(request);
		
		JSONObject json = new JSONObject();
		json.put("name", request.getParameter("name"));
		json.put("gender", request.getParameter("gender"));
		json.put("birthday", request.getParameter("birthday"));
		json.put("phone", request.getParameter("phone"));
		json.put("idCard", request.getParameter("idCard"));
//		System.out.println(json);
//		System.out.println(json.getString("name"));

		Service service = new Service();
		service.addRecord(json);

		
	}

}
