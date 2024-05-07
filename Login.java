package login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gmail = request.getParameter("email");
		String password = request.getParameter("upass");
		try {
		     Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
		     PreparedStatement ps = con.prepareStatement("select Email,PassWord from registration_table  where Email = ? and passWord = ?");
		     ps.setString(1, gmail);
		     ps.setString(2, password);
		     ResultSet rs  = ps.executeQuery();
		     if(rs.next()) {
		    	 System.out.println("login successful");
		    	 RequestDispatcher rs1 = request.getRequestDispatcher("/Dashboard.jsp");
		          rs1.forward(request, response);
		    	 
		    	 // HttpSession hs = request.getSession();
			    	//  hs.setAttribute("Email",gmail);
		    	   
		     }
		     else {
		    	 
		    	 System.out.println("login failed");
		    	  response.setContentType("text/html");
			      response.getWriter().write("Invalid details please register");
			      RequestDispatcher rd = request.getRequestDispatcher("/Registration.jsp");
			      rd.include(request, response);                                 
		         
		     }
		           con.close();
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
