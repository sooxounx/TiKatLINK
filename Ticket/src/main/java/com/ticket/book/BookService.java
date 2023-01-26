package com.ticket.book;

public class BookService {

	public BookDAO bookDao;
	
	public BookService(BookDAO bookDao) {
		this.bookDao = bookDao;
	}
	
}
