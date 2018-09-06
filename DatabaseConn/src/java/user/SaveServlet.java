
package user;

import dao.EmpDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Emp;

/**
 *
 * @author hi
 */
public class SaveServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
                String password= request.getParameter("password");
		String email=request.getParameter("email");
                String address= request.getParameter("address");
				
		Emp e= new Emp();
		e.setName(name);
		e.setEmail(email);
		e.setPassword(password);
                e.setAddress(address);
		
		System.out.println("name:"+name);
		System.out.println("email:"+email);
		System.out.println("password:"+password);
		
		int status= EmpDao.save(e);
		if(status>0) {
			out.print("<p>Record saved successfully</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else {
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}


}
