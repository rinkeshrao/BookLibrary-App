package Books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletRequest;

public class BookDAO {
	public int k=0;
	public int insert(BookBean bb) {//for insert
		try {
			Connection con=ConnectionDAO.getCon();
			PreparedStatement pst=con.prepareStatement
		("insert into BookLiabrary values(?,?,?,?,?)");
			pst.setString(1,bb.getCode());
			pst.setString(2,bb.getName());
			pst.setString(3,bb.getAuthor());
			pst.setFloat(4,bb.getPrice());
			pst.setInt(5,bb.getQty());
			k=pst.executeUpdate();
		}
		catch(Exception e) {e.printStackTrace();}
		return k;
	}
	public int delete(BookBean bb) {
		try {
			Connection con=ConnectionDAO.getCon();
			PreparedStatement pst=con.prepareStatement
			("delete from BookLiabrary where code=?");
			pst.setString(1,bb.getCode());//code use for delete
			k=pst.executeUpdate();
		}
		catch (Exception e) {e.printStackTrace();}
		return k;
	}
	public BookBean bb=null;
	public BookBean retrive(ServletRequest req) 
	{
		try {
			Connection con=ConnectionDAO.getCon();
			PreparedStatement pst=con.prepareStatement
			("select * from BookLiabrary where code=?");
			pst.setString(1,req.getParameter("code"));
			
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				bb=new BookBean();//Bean Object create
				bb.setCode(rs.getString(1));
				bb.setName(rs.getString(2));
				bb.setAuthor(rs.getString(3));
				bb.setPrice(rs.getFloat(4));
				bb.setQty(rs.getInt(5));	
			}
		}
			catch (Exception e) {e.printStackTrace();}
			return bb;	
	    }
	public int update(ServletRequest req) {
		try {
			Connection con=ConnectionDAO.getCon();
			PreparedStatement pst=con.prepareStatement
 ("update BookLiabrary set name=?,author=?,price=?,qty=? where code=?");
			pst.setString(1,req.getParameter("name"));
			pst.setString(2,req.getParameter("author"));
			pst.setFloat(3,Float.parseFloat(req.getParameter("price")));
			pst.setInt(4,Integer.parseInt(req.getParameter("qty")));
			pst.setString(5,req.getParameter("code"));
			
			k=pst.executeUpdate();	
		}
		catch(Exception e) {e.printStackTrace();}
		return k;
	}
	public ArrayList<BookBean> al=new ArrayList<BookBean>();
	public ArrayList<BookBean> retrieve()
	{
		try {
			Connection con=ConnectionDAO.getCon();
			PreparedStatement pst=con.prepareStatement
			("select * from BookLiabrary");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				BookBean bb=new BookBean();
				bb.setCode(rs.getString(1));
				bb.setName(rs.getString(2));
				bb.setAuthor(rs.getString(3));
				bb.setPrice(rs.getFloat(4));
				bb.setQty(rs.getInt(5));
				al.add(bb);//Adding bean to ArrayList
			}//end of loop
		}
			catch (Exception e) {e.printStackTrace();}
			return al;
		}		
}
