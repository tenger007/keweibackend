package cn.cncic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cncic.models.Book;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public Book byId(long id){
		return this.bookRepository.findOne(id);
	}
}
