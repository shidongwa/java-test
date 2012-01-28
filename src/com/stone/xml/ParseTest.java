package com.stone.xml;


import java.io.InputStream;
import java.util.List;



public class ParseTest{

	public static void main(String[] args) throws Exception{
//		InputStream input = new ParseTest().getClass().getClassLoader().getResourceAsStream("book.xml");
		InputStream input = ParseTest.class.getClassLoader().getResourceAsStream("com/stone/xml/books.xml");
		DomParseService dom = new DomParseService();
		List<Book> books = dom.getBooks(input);
		for(Book book : books){
			System.out.println(book.toString());
		}
	}
}