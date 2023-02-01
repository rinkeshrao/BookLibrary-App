package Books;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Spliterator;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewBookServlet extends GenericServlet {
	public BookDAO ob=null;
	public BookBean bb=null;
	
	public void init()throws ServletException{
		ob=new BookDAO();
	}
	public void service(ServletRequest req, ServletResponse res)
		throws ServletException, IOException {
		ArrayList<BookBean> al=ob.retrieve();
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		if(al.size()==0) {
		pw.println("Books Not Available");	
		}
		else {
			pw.print("body style=\"background-color:#E6E6FA;\">");
			pw.print("</body>");
			
			//CSS styles
			pw.print("<style>");
			pw.print("table,th,td{border:3px solod black;border-collapse:collapse}");
			pw.print("th,td{padding:10px;}");
			pw.print("th{background-color:colar;color:white}");
			pw.print("tr:hover{background-color:colar:colar}");
			pw.print("table center{margin-left:auto;margin-right:auto}");
			pw.print("</style>");
			
			pw.println("<h1><font color=\"white\"><marquee bgcolor=\"colar\">"
					+ "BookDetails"+"</h1></marquee></font><h1>");
			pw.print("<table class=\"center\">");
			pw.print("<tr>");
			pw.println("<th>"+"Code"+"</th>"+"<th>"+"Name"+"</th>"+"<th>"+"Author"+"</th>"
					+ "<th>"+"Price"+"</th>"+"<th>"+"Qty"+"</th>");
			pw.print("</tr>");
			
			Spliterator<BookBean> sp=al.spliterator();
			sp.forEachRemaining((k)->{
				BookBean bb=(BookBean)k;
				pw.print("<tr>");
				
				pw.println("<td>"+bb.getCode().toUpperCase()+"</td>"+"<td>"+bb.getName()
				.toUpperCase()+"</td>"+"<td>"+bb.getAuthor().toUpperCase()+"</td>"+"<td>"
						+bb.getPrice()+"</td>"+"<td>"+bb.getQty()+"</td>");
				pw.print("</tr>");
			});
			pw.print("</table>");	
		}
		}
	public void destroy() {
		ob=null;
	}
}
