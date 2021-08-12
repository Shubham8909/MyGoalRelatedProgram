package com.collaboration.story.challenge.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.collaboration.story.challenge.model.Paragraph;
import com.collaboration.story.challenge.model.Sentence;

public interface ParaGraphRepository extends JpaRepository<Paragraph, Integer> {
	
	  @Transactional
	  @Query("Select s from Paragraph p JOIN p.listOfSentence s  where "
	  		+ "s.status = com.collaboration.story.challenge.model.Status.INPROCESS and p.id=:paragraph_id ")
	  List<Sentence> getSentenceDetails(@Param("paragraph_id") int paragraph_id);
	  
	  @Transactional
	  @Query("Select COUNT(s.id) from Paragraph p JOIN p.listOfSentence s  where  p.id=:paragraph_id ")
	  int getSentenceCount(@Param("paragraph_id") int paragraph_id);
}
