package com.javatraining.model;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

public class BookService {
	
 private CrudRespository<Book> repo;
 
 private Connection con;

 
 public BookService(Connection con) {
		super();
		
		this.con = con;
		this.repo = new DbBookRespository(con);
	  
  }
  public List<Book> findAll(){
	  return this.repo.findAll();
	  
  }
  public Book add(Book entity)
  {
	return this.repo.add(entity);
	 
  }
  public Book findBookByName(String bookName) {
	  return  this.repo.findByName(bookName);
  }
public Book remove(int id) {
	// TODO Auto-generated method stub
	return null;
}
}
 