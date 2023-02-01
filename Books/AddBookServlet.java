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
@WebServlet("/add")
public class AddBookServlet extends GenericServlet {
	public BookBean bb=null;
	public void init() throws ServletException{
		bb=new BookBean();//creating bean object
	}
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException{
		bb.setCode(req.getParameter("code"));
		bb.setName(req.getParameter("name"));
		bb.setAuthor(req.getParameter("author"));
		bb.setPrice(Float.parseFloat(req.getParameter("price")));
		bb.setQty(Integer.parseInt(req.getParameter("qty")));
		
		int k=new BookDAO().insert(bb);
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		if(k>0) {
			pw.println("<h1>Book Added Successfully</h1><br>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
		}
	}

}
