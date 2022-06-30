package com.javatraining.model;

import java.util.ArrayList;
import java.util.List;

public abstract class BookRespository implements CrudRespository<Book>{
	
	private List<Book> BookList;

	
	public BookRespository() {
		super();
		this.BookList=new ArrayList<Book>();
	}
	public Book add(Book t)
	{
		boolean isAdded=this.BookList.add(t);
		if(isAdded)
		{
			return t;
		}
		else
		{
			return null;
		}
	}
   public List<Book>findAll()
   {
	   return this.BookList;
   }
  
}
