package com.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.app.entities.Author;
@EnableJpaRepositories
@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer>{
	
   public Author deleteByName(Author author);
   
   public List<Author> findByName(String name);

}
