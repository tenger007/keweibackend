package cn.cncic.service;

import org.springframework.data.repository.CrudRepository;

import cn.cncic.models.Book;
import cn.cncic.models.User;

interface BookRepository extends CrudRepository<Book, Long>{

}

interface UserRepository extends CrudRepository<User, Long>{

}