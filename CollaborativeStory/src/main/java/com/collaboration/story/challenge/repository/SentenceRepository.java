package com.collaboration.story.challenge.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.collaboration.story.challenge.model.Sentence;

public interface SentenceRepository extends JpaRepository<Sentence, Integer> {
	
	
	@Transactional
	@Modifying
	@Query("update Sentence s set s.status=com.collaboration.story.challenge.model.Status.COMPLETE where s.id = :s_id")
	void updateStatus(@Param("s_id") int s_id );

}
