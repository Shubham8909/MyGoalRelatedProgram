package com.collaboration.story.challenge.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.story.challenge.model.Paragraph;
import com.collaboration.story.challenge.model.Request;
import com.collaboration.story.challenge.model.Sentence;
import com.collaboration.story.challenge.model.Status;
import com.collaboration.story.challenge.model.Title;
import com.collaboration.story.challenge.repository.ParaGraphRepository;
import com.collaboration.story.challenge.repository.SentenceRepository;
import com.collaboration.story.challenge.repository.TitleRepository;
import com.collaboration.story.challenge.utils.StoryUtils;

@Service
public class CommanService {
	
	private final Logger logger = LoggerFactory.getLogger(CommanService.class);
	
	@Value("${story.create.resquest.word.limit}")
	private String createRequestWordLimit;
	@Value("${story.create.resquest.title.limit}")
	private String createRequestTitleLimit;
	@Value("${story.create.resquest.paragraph.limit}")
	private String createRequestParagraphLimit;
	@Value("${story.create.resquest.sentence.limit}")
	private String createRequestSentenceLimit;
	@Value("${story.create.resquest.sentence.word.limit}")
	private String createRequestSentenceWordLimit;
	
	@Autowired
	private TitleRepository titleRepository;

	@Autowired
	private ParaGraphRepository paraGraphRepository;

	@Autowired
	private SentenceRepository sentenceRepository;
	
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	public void  createAndStory(Request request) {

		List<Title> titleList = titleRepository.getTitleDetails();
		// Title is not present
		if (titleList.size() == 0) {
			logger.info("No title is there with inprocess status");
			Title t = StoryUtils.getNewTitleObject(request);
			titleRepository.save(t);
			return;
		}

		//Title is present.
		Title t1 = titleList.get(0);
		// Not exceed the configured limit
		if (!StoryUtils.isReachedLimitLength(t1.getTitle(), createRequestTitleLimit)) {
			StoryUtils.updateTitleObject(t1, request);
			titleRepository.save(t1);
			return;
		}
		// exceed the limit then checking for paragraph
		List<Paragraph> pList = titleRepository.getParagraphDetails(t1.getId());

		// Paragraph is not Present
		if (pList.size() == 0) {
			logger.info("No paragraph is there with inprocess status");
			// paragraph
			Paragraph p = StoryUtils.createParagraphObject();
			// sentence
			Sentence s = StoryUtils.createSentenceObject(request);
			p.getListOfSentence().add(s);
			t1.getListOfPara().add(p);
			t1.setUpdate_at(new Date());
			titleRepository.save(t1);
			return;

		}

		// paragraph size having size
		Paragraph p1 = pList.get(0);
		List<Sentence> sentenceList = paraGraphRepository.getSentenceDetails(p1.getId());

		Sentence s = sentenceList.get(0);
		if (!StoryUtils.isReachedLimitLength(s.getSentence_text(), createRequestSentenceWordLimit)) {
			s.setSentence_text(s.getSentence_text() + " " + request.getWord());
			sentenceRepository.save(s);
			titleRepository.updatdate(new Date(), t1.getId());
			return;
		}
        // Completed Sentence
		s.setStatus(Status.COMPLETE);
		sentenceRepository.save(s);

		int countSentence = paraGraphRepository.getSentenceCount(p1.getId());
		//If Sentence Limit reached configured limit
		if (countSentence == Integer.parseInt(createRequestSentenceLimit)) {
			int countOfPara = titleRepository.getParagraphCount(t1.getId());
			
			//If Paragraph Limit reached configured limit
			if (countOfPara == Integer.parseInt(createRequestParagraphLimit)) {
				// Completed Paragraph.
				p1.setStatus(Status.COMPLETE);
				paraGraphRepository.save(p1);
				//Completed Title Of Story
				t1.setStatus(Status.COMPLETE);
				t1.setUpdate_at(new Date());
				titleRepository.save(t1);
				// Created New Title Of Story
				Title tNew = StoryUtils.getNewTitleObject(request);
				titleRepository.save(tNew);
				return;
			}
			//If Paragraph Limit not reach to configured limit
			// Completed Paragraph.
			p1.setStatus(Status.COMPLETE);
			paraGraphRepository.save(p1);
			// Created new Paragraph.
			Paragraph p = StoryUtils.createParagraphObject();
			// Created new Sentence.
			Sentence s2 = StoryUtils.createSentenceObject(request);
			p.getListOfSentence().add(s2);
			t1.getListOfPara().add(p);
			t1.setUpdate_at(new Date());
			titleRepository.save(t1);
			return;
		}

		Sentence sn = StoryUtils.createSentenceObject(request);
		p1.getListOfSentence().add(sn);
		paraGraphRepository.save(p1);
		titleRepository.updatdate(new Date(), t1.getId());
		return;

	}
	

}
