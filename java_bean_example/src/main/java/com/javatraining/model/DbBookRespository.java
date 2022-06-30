package com.javatraining.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javatraining.model.Book;
import com.javatraining.model.CrudRespository;

public class DbBookRespository implements CrudRespository <Book> {
	private Connection con;
	
	public DbBookRespository(Connection con) 
	{
		super();
		this.con=con;
	}
	

	public Book add(Book t) {
		int rowAdded=0;
		String sql="insert into book values(?,?,?,?)";
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setInt(1,t.getBookNumber());
			psmt.setString(2,t.getBoookName());
			psmt.setString(3,t.getAuthourName());
			psmt.setDouble(4,t.getPrice());
			
			rowAdded = psmt.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return rowAdded==1?t:null;
	}

	@Override
	public List<Book> findAll() {
	
	
		// TODO Auto-generated method stub
	 String sql="select *from Book;";
	 List<Book> bookList=new ArrayList<>();
	 try {
		 PreparedStatement psmt=con.prepareStatement(sql);
		 
		 ResultSet rs=psmt.executeQuery();
		 
		 while(rs.next())
		 {
		
			 int bookNumber=rs.getInt("bookNumber");
			 String bookName=rs.getString("bookName");
			 String authourName=rs.getString("authourName");
			 double price=rs.getDouble("price");
			 
			 Book eachBook = new Book(bookNumber,bookName,authourName,price);
			 bookList.add(eachBook);
			 
		 }
		
}
	 catch (Exception e) {
		 e.printStackTrace();
	}
	return bookList;
	}


	@Override
	public Book findByName(String bookName) {
		return null;
		
	}


	@Override
	public <T> T removedById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
 
}