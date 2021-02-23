package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Publication;
import com.app.repository.PublicationRepository;

@Service
public class PublicationService {
   @Autowired	
   private PublicationRepository publicationRepo;
   //add new publication
   public Publication addPublication(Publication publication) {
	   return publicationRepo.save(publication);
   }
   //find publication by name
   public List<Publication> getByName(Publication publication){
	  return publicationRepo.findByName(publication);
   }
 //find All publication 
   public List<Publication> getAll(){
	  return publicationRepo.findAll();
   }
   //delete publication by name
   public Publication deleteByName(Publication publication){
		  return publicationRepo.deleteByName(publication);
   }
}
