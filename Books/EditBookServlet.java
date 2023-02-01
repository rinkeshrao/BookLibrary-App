package Books;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditBookServlet extends GenericServlet {
	public BookDAO ob=null;
	public void init()throws ServletException{
		ob=new BookDAO();//object creation
	}
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		BookBean bb=ob.retrive(req);
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		if(bb==null) {
			pw.println("<h1>Invalid Book Code</h1><br>");
			RequestDispatcher rd=req.getRequestDispatcher("editbook.html");
			rd.include(req,res);
		}
		else {
			
			pw.println("<form action='update' method='post'>");
			pw.println("<input type='hidden' name='code' value='"+bb.getCode()+"'>");
			pw.println("<h1>Book Name:</h1><input tupe='text' name='name' value='"+bb.getName()+"'>");
			pw.println("<h1>Book Author:</h1><input type='text' name='author' value='"+bb.getAuthor()+"'><br>");
			pw.println("<h1>Book Price:</h1><input type='text' name='price' value='"+bb.getPrice()+"'><br>");
			pw.println("<h1>Quantity:</h1><input type='text' name='qty' value='"+bb.getQty()+"'><br></br>");
			pw.println("<input type='submit' value='Update'><br>");
			pw.println("</form>");
		}
	}  
	public void destroy() {
		ob=null;	
	}
}
