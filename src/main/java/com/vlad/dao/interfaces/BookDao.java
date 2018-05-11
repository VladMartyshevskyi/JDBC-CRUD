package com.vlad.dao.interfaces;

import java.util.List;
import com.vlad.dao.models.Book;

public interface BookDao {
	
	void add(Book book);
	void remove(Integer id);
	void update(Book book);
	List<Book> getAll();
	Book getById(Integer id);
}
