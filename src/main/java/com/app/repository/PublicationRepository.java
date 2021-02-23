package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Publication;
@Repository
public interface PublicationRepository extends JpaRepository<Publication,Integer>{
    public List<Publication> findByName(Publication publication);
    public Publication deleteByName(Publication publication);
}
