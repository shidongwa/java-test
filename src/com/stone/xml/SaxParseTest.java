package com.stone.xml;

import java.io.InputStream;
import java.util.List;





public class SaxParseTest {

	public static void main(String[] args) throws Exception{
		SaxParseService sax = new SaxParseService();
		InputStream input = new SaxParseTest().getClass().getClassLoader().getResourceAsStream("com/stone/xml/books.xml");
		List<Book> books = sax.getBooks(input);
		for(Book book : books){
			System.out.println(book.toString());
		}
	}
}
