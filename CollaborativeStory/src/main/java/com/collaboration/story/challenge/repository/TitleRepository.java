package com.collaboration.story.challenge.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.collaboration.story.challenge.model.Paragraph;
import com.collaboration.story.challenge.model.Title;

public interface TitleRepository extends JpaRepository<Title, Integer> {

	@Transactional
	@Query("Select t from Title t where t.status = com.collaboration.story.challenge.model.Status.INPROCESS ")
	List<Title> getTitleDetails();

	@Transactional
	@Query("Select p from Title t JOIN t.listOfPara p  where "
			+ "p.status = com.collaboration.story.challenge.model.Status.INPROCESS and t.id=:title_id ")
	List<Paragraph> getParagraphDetails(@Param("title_id") int title_id);

	@Transactional
	@Query("Select COUNT(p.id) from Title t JOIN t.listOfPara p where t.id=:title_id ")
	int getParagraphCount(@Param("title_id") int title_id);

	@Transactional
	@Modifying
	@Query("update Title t set t.update_at=:lastUpdationDate where t.id = :t_id")
	void updatdate(@Param("lastUpdationDate") Date lastUpdationDate,
			@Param("t_id") int t_id );

	@Transactional
	@Query("Select t from Title t where t.id = :id ")
	Title getTitleStory(@Param("id") int id);

	

}
