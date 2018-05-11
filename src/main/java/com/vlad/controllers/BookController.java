package com.vlad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.vlad.dao.interfaces.BookDao;
import com.vlad.dao.models.Book;

@RestController
public class BookController {

	@Autowired
	private BookDao bookDao;

	@RequestMapping(method = RequestMethod.GET, value = "/books")
	public List<Book> allBooks() {
		return bookDao.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/books/{id}")
	public Book getBook(@PathVariable Integer id) {
		return bookDao.getById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/books")
	public void addBook(@RequestBody Book book) {
		bookDao.add(book);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/books/")
	public void updateBook(@RequestBody Book book) {
		bookDao.update(book);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
	public void deleteBook(@PathVariable Integer id) {
		bookDao.remove(id);
	}
}
