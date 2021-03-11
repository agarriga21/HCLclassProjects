package project;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PetsServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean validfname;
		boolean validlname;
		boolean validusername;
		boolean validpassword;
		boolean oldusername=false;
		
		String username = request.getParameter("username");
		
		 try {
             SessionFactory factory = HibernateUtil.getSessionFactory();
             
             Session session = factory.openSession();
           
             List<User> list = session.createQuery("from User", User.class).list();
             session.close();
		 
		 
		
		UserModel productModel = new UserModel();
		User user = new User();
        PrintWriter out = response.getWriter();
        if(request.getParameter("firstname").isEmpty()==false) {
        	user.setFirstName(request.getParameter("firstname"));
        	validfname=true;
        }
        	else {
        		validfname=false;	
        	}
        if(request.getParameter("lastname").isEmpty()==false) {
        	user.setLastName(request.getParameter("lastname"));
        	validlname=true;
        }
        	else {
        		validlname=false;	
        	}
           
        if(request.getParameter("username").isEmpty()==false) {
            	user.setUserName(request.getParameter("username"));
            	validusername=true;
            	}
            
            	else {
            		validusername=false;
            		oldusername = false;
            	}
        
        if(validusername) {
        	for(User p: list) { 
                if(p.getUserName().equals(username)){
                	oldusername = true;
                	break;
                }
                else {
                	oldusername = false;
                }
        }
        }
            if(request.getParameter("password").isEmpty()==false) {
            	user.setPassword(request.getParameter("password"));
            	validpassword=true;
            }
            	else {
            		validpassword=false;	
            	}
            
       if(validfname && validlname && validusername && validpassword&&!oldusername) {
        
        if (productModel.save(user)) {
        	 out.println("<html><body>");
        	 out.println("<div align=\"center\">");
        	 
             out.println("<h2 style=\"color:green;\">Successfully Registered!</h2>");
             out.println("<h3>Your information:</h3>");
             out.println("<h2> </h2>"); 
             out.println("First Name: " + user.getFirstName()+ "<br>"+
                     "Last Name: " + String.valueOf(user.getLastName()) +"<br>"+ "Username: " + user.getUserName().toString() + "<br>");
             out.println("<h2> </h2>");
             out.println("<a href=\"index.jsp\">");
             out.println("<input type=\"submit\" value=\"Main Menu\"/>");
             out.println("</a>");
             out.println("</div></body></html>");
		} else {
			 out.println("<html><body>");
			 out.println("<div align=\"center\">");
             out.println("<h2 style=\"color:red\">Failed registration</h2>");
             out.println("<b>Valid input, unknown error </b> ");
             out.println("<h2> </h2>"); 
             out.println("<input type=button value="+"\"Try Again\""+ " onclick=history.back()>");
             out.println("</div></body></html>");
		}
		}
       else {
    	   out.println("<html><body>");
    	   out.println("<div align=\"center\">");
    	   out.println("<h2 style=\"color:red;\">Failed registration</h2>");
          if(validfname==false) {
        	  out.println("<b style=\"color:red;\">Invalid first name entry </b> <br>");  
          }
          if(validlname==false) {
        	  out.println("<b style=\"color:red;\">Invalid last name entry </b> <br>");  
          }
          if(validusername==false) {
        	  out.println("<b style=\"color:red;\">Invalid username entry</b> <br>");  
          }
          if(oldusername==true) {
        	  out.println("<b style=\"color:red;\">Username already being used</b> <br>");  
          }
       if(validpassword==false) {
     	  out.println("<b style=\"color:red;\">Invalid password entry</b> <br>");  
       }
          out.println("<h2> </h2>"); 
          out.println("<input type=button value="+"\"Try Again\""+ " onclick=history.back()>");
           out.println("</div></body></html>");
       }
		 }
       catch (Exception ex) {
           throw ex;
   }
       }
	}
