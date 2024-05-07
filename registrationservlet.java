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


public class registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public registrationservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email = request.getParameter("gmail");
		String firstname = request.getParameter("fname");
		String Lastname = request.getParameter("lname");
		String phonenumber = request.getParameter("phone");
		String Dateofbirth = request.getParameter("date");
		String Address = request.getParameter("text");
		String password = request.getParameter("password");
		
		
		try {
		     Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
		     PreparedStatement ps = con.prepareStatement("insert into registration_table value(?,?,?,?,?,?,?)");
		     ps.setString(1,Email);
		     ps.setString(2,firstname);
		     ps.setString(3,Lastname);
		     ps.setString(4,phonenumber);
		     ps.setString(5,Dateofbirth);
		     ps.setString(6,Address);
		     ps.setString(7,password);
		 
		   
		     
		     int i = ps.executeUpdate();
		     if(i>0) {
		    	 System.out.println("registration successfully");
		    	 RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		    	 
		    	 rd.forward(request, response);
		    	 
		     }
		     else {
		    	 System.out.println("registration failed");
		     }
		     
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
