package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



import project.HibernateUtil;
import project.User;

/**
 * Servlet implementation class UserAuthenticate
 */
@WebServlet
public class AuthenticateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean valid = false;
       
           
            try {
                SessionFactory factory = HibernateUtil.getSessionFactory();
                PrintWriter out = response.getWriter();
                Session session = factory.openSession();
              
                List<User> list = session.createQuery("from User", User.class).list();
                session.close();
                for(User p: list) { 
                    if(p.getUserName().equals(username)&&p.getPassword().equals(password)) {
                    	out.println("<html><body>");
                    	out.println("<div align=\"center\">");
                        out.println("<h2 style=\"color:green;\">Successful Login!</h2>");
                        out.println("<h2>Welcome " +  p.getUserName() +"!" + "</h2><br>"); 
                        out.println("<h2>Or better known as " + p.getFirstName().toString() +" "+ p.getLastName().toString()+ "</h2><br>");
                
                out.println("<h2> </h2>"); 
                out.println("<a href=\"index.jsp\">");
                out.println("<input type=\"submit\" value=\"Logout\"/>");
                out.println("</a>");
            out.println("</div></body></html>");
                        valid = true;
               	break;
                    }
                    
                    
                }
                
                
               if(!valid)  {
                
 
               	request.setAttribute("error", "Invalid login information, please try again");
                   request.getRequestDispatcher("/login.jsp").forward(request, response);}
         } catch (Exception ex) {
                 throw ex;
         }

 		
 		
    }
	}

