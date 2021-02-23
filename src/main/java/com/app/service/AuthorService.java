package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Author;
import com.app.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
    private AuthorRepository authorRepo;
	//add new Author
	public Author addAuthor(Author author){
	   return authorRepo.save(author);
    }
	//fetch Author by id
	public Optional<Author> getAuthorById(int id){
		return authorRepo.findById(id);
	}
	//fetch Author by name
	public List<Author> getAuthorByName(String name){
		return authorRepo.findByName(name);
	}
	//fetch all Authors 
	public List<Author> getAllAuthors(){
		return authorRepo.findAll();
	}
	//delete Author by name
	public Author deleteAuthorByName(Author author){
	    return authorRepo.deleteByName(author);	
	}
}
