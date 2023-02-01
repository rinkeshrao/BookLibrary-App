package Books;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/add")
public class ValidatinFilterForRegistration implements Filter {
 
	public void destroy() {
		
	}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		res.setContentType("text/html");
		String Code=req.getParameter("code");
		String Name=req.getParameter("name");
		String Author=req.getParameter("author");
		float Price=(Float.parseFloat(req.getParameter("price")));
		int Qty=(Integer.parseInt(req.getParameter("qty")));
		
		PrintWriter out=res.getWriter();
		if(Code.equals("")) {
			out.println("<center>Fst Name cant br empty</center>");
		}
		    chain.doFilter(req, res);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
