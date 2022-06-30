package com.javatraining.model;

import java.util.List;

public interface CrudRespository<Book> {
	public Book add(Book t);

	List<Book> findAll();

	public Book findByName(String bookName);

	public <T> T removedById(int id);

}
