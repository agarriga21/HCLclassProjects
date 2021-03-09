package com.project;

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

import com.project.Product;
/**
 * Servlet implementation class PetsServlet
 */
public class PetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
        try {
               SessionFactory factory = Hibernate.getSessionFactory();
               
               Session session = factory.openSession();
             
               List<Product> list = session.createQuery("from Product", Product.class).list();
               
               session.close();
               
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<b>Product Listing</b><br>");
                for(Product p: list) {
                        out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
                                        ", Price: " + String.valueOf(p.getPrice()) + ", Color: " + p.getColor().toString() + "<br>");
                }
                out.println("<h2> </h2>"); 
                out.println("<input type=button value="+"\"Back\""+ " onclick=history.back()>");
            out.println("</body></html>");
            
            
        } catch (Exception ex) {
                throw ex;
        }

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean validname;
		boolean validprice;
		boolean validcolor;
		PetModel productModel = new PetModel();
        Product pet = new Product();
        PrintWriter out = response.getWriter();
        if(request.getParameter("name").isEmpty()==false) {
        	pet.setName(request.getParameter("name"));
        	validname=true;
        }
        	else {
        		validname=false;	
        	}
            
            if(request.getParameter("color").isEmpty()==false) {
            	pet.setColor(request.getParameter("color"));
            	validcolor=true;
            }
            	else {
            		validcolor=false;	
            	}
        
        try {
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        pet.setPrice(price);
        validprice=true;
        }
        catch(NumberFormatException e) {
        	validprice=false;
        }
       if(validname && validcolor && validprice) {
        
        if (productModel.update(pet)) {
        	 out.println("<html><body>");
        	 out.println("<div align=\"center\">");
        	 
             out.println("<h2 style=\"color:green;\">Success adding the new pet!</h2>");
             out.println("<h3>New pet summary</h3>");
             out.println("<h2> </h2>"); 
             out.println("ID: " + String.valueOf(pet.getID()) + ", Name: " + pet.getName() +
                     ", Price: " + String.valueOf(pet.getPrice()) + ", Color: " + pet.getColor().toString() + "<br>");
             out.println("<h2> </h2>");
             out.println("<input type=button value="+"\"Add Another Pet\""+ " onclick=history.back()>");
            
             out.println("</div></body></html>");
		} else {
			 out.println("<html><body>");
			 out.println("<div align=\"center\">");
             out.println("<h2 style=\"color:red\">Failed adding the new pet</h2>");
             out.println("<b>Valid input, unknown error </b> ");
             out.println("<h2> </h2>"); 
             out.println("<input type=button value="+"\"Try Again\""+ " onclick=history.back()>");
             out.println("</div></body></html>");
		}
		}
       else {
    	   out.println("<html><body>");
    	   out.println("<div align=\"center\">");
    	   out.println("<h2 style=\"color:red;\">Failed adding the new pet</h2>");
          if(validname==false) {
        	  out.println("<b style=\"color:red;\">Invalid name entry </b> <br>");  
          }
          if(validcolor==false) {
        	  out.println("<b style=\"color:red;\">Invalid color entry </b> <br>");  
          }
          if(validprice==false) {
        	  out.println("<b style=\"color:red;\">Invalid price entry</b> <br>");  
          }
          out.println("<h2> </h2>"); 
          out.println("<input type=button value="+"\"Try Again\""+ " onclick=history.back()>");
           out.println("</div></body></html>");
       }
	}
		//doGet(request, response);
	}
