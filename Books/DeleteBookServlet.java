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
@WebServlet("/delete")
public class DeleteBookServlet extends GenericServlet{
	public BookBean bb=null;
	public BookDAO ob=null;
	public void init()throws ServletException{
		bb=new BookBean();
	}
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		bb.setCode(req.getParameter("code"));
		int k=new BookDAO().delete(bb);
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		if(k>0) {
			pw.print("<h1>Book Deleted Successfully...</h1><br>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
			}
		else {
			pw.print("<h1>Invalid Book Code</h1><br>");
			RequestDispatcher rd=req.getRequestDispatcher("deletebook.html");
			rd.include(req, res);
		}
	}
	public void destroy() {
		bb=null;
		ob=null;
		}	
	}