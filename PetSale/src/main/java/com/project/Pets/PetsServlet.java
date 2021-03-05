package com.project.Pets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Pets.model.*;



/**
 * Servlet implementation class PetsServlet
 */

public class PetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int valid=1;
		String petid=request.getParameter("petid");
		int idnumber=1;
		
		try {
		idnumber = Integer.parseInt(petid);
		
		}
		catch(NumberFormatException e) {
			valid =0;
			
		}
		try {
			
        	PrintWriter out = response.getWriter();
            out.println("<html><body>");
                 
            InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
            Properties props = new Properties();
            props.load(in);
                
            DBConnect conn = new DBConnect(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
        	Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        	 ResultSet rst = stmt.executeQuery("select * from products");
        	 out.println("<div align=center>");
        	 out.println("<h1>Pet With ID: "+petid+"</h1>");
            
             
             if(valid==1) {
             while (rst.next()) { 
                 if(rst.getInt("id")==idnumber) {
                	 out.println("<table><tr><th>Name</th><th>Color</th><th>Price</th></tr>");
            	 out.println("<tr><td>" + rst.getString("name") + "</td>" + "<td>" +
                 		rst.getString("color") + "</td><td>" + rst.getBigDecimal("price") + "</td></tr>");
            	 out.println("</table>");
            	 valid=2;
                 }
             }
             }
             else if(valid==0) {
            	 out.println("<h2 style=\"color:red;\">Invalid ID format, please try again</h2>"); 
             }
             
             
             if(valid==1) {
            	 out.println("<h2 style=\"color:red;\">No pet available with that ID</h2>"); 
             }
             
             
             
             
             
             
             out.println("<h2> </h2>"); 
             out.println("<input type=button value="+"\"Try Again\""+ " onclick=history.back()>");
             stmt.close();        
    
         
             out.println("</body></html>");
             conn.closeConnection();
         
         } catch (ClassNotFoundException e) {
         	e.printStackTrace();
         } catch (SQLException e) {
         	e.printStackTrace();
         }
 	}

}
