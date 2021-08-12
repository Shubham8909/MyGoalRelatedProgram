package com.collaboration.story.challenge.service;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.collaboration.story.challenge.exception.InvalidRequestException;
import com.collaboration.story.challenge.exception.MultipleWordException;
import com.collaboration.story.challenge.exception.StoryNotPresentException;
import com.collaboration.story.challenge.executor.StoryExecutor;
import com.collaboration.story.challenge.executor.StoryThread;
import com.collaboration.story.challenge.model.Order;
import com.collaboration.story.challenge.model.QueryResponse;
import com.collaboration.story.challenge.model.Request;
import com.collaboration.story.challenge.model.Response;
import com.collaboration.story.challenge.model.ResponseStatus;
import com.collaboration.story.challenge.model.Sort;
import com.collaboration.story.challenge.model.Title;
import com.collaboration.story.challenge.repository.TitleRepository;
import com.collaboration.story.challenge.utils.SequenceGen;
import com.collaboration.story.challenge.utils.StoryUtils;


@Service
public class StoryService {

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
	
	static volatile String title="";
	static volatile String sentence="";
	static volatile int wordCount=0;

	@Autowired
	private TitleRepository titleRepository;
	
	@Autowired
	private CommanService commanService;
	

	public Title getStoryByid(int id) {
		Title titleStory = titleRepository.getTitleStory(id);
		if(titleStory==null) {
			throw new StoryNotPresentException("Story not Present of given id");
		}
		return titleStory;
	}

	public Response createAndStory(@Valid Request request, ResponseStatus respStataus) {
		
		if (!StoryUtils.isValidRequest(request)) {
			throw new InvalidRequestException("request/word is empty");
		}
		if (!StoryUtils.isValidWordRequest(request.getWord(), createRequestWordLimit)) {
			throw new MultipleWordException("multiple words sent");
		}
		//Check Title Limit..
		if(SequenceGen.titleWordLength.get()==0) {
			SequenceGen.TitleWordLenghtNext();
			int tid=SequenceGen.titleSeqSer.get();
			title=request.getWord();
			respStataus.changeHttpStatus(HttpStatus.CREATED);
		    StoryExecutor.getStoryExcecutorInstance().submit(new StoryThread(request,commanService));
			return new Response(tid,title, "");
		}
	
		if(SequenceGen.titleWordLength.get()<Integer.parseInt(createRequestTitleLimit)) {
			SequenceGen.TitleWordLenghtNext();
			int tid=SequenceGen.titleSeqSer.get();
			title=title.concat(" ").concat(request.getWord());
			respStataus.changeHttpStatus(HttpStatus.OK);
		    StoryExecutor.getStoryExcecutorInstance().submit(new StoryThread(request,commanService));
			return new Response(tid,title, "");
		}

		int totalWordCount =Integer.parseInt(createRequestParagraphLimit)* Integer.parseInt(createRequestSentenceLimit) * Integer.parseInt(createRequestSentenceWordLimit);
	
		if(wordCount<totalWordCount) {
			if(SequenceGen.sentenceWordLength.get()==0) {
	            wordCount++;
				SequenceGen.sentenceWordLengthNext();
				int tid=SequenceGen.titleSeqSer.get();
				sentence=request.getWord();
				respStataus.changeHttpStatus(HttpStatus.OK);
			    StoryExecutor.getStoryExcecutorInstance().submit(new StoryThread(request,commanService));
				return new Response(tid,title, sentence);
			}
			if(SequenceGen.sentenceWordLength.get()<Integer.parseInt(createRequestSentenceWordLimit)) {
				wordCount++;
				SequenceGen.sentenceWordLengthNext();
				int tid=SequenceGen.titleSeqSer.get();
				sentence=sentence.concat(" ").concat(request.getWord());
				respStataus.changeHttpStatus(HttpStatus.OK);
			    StoryExecutor.getStoryExcecutorInstance().submit(new StoryThread(request,commanService));
				return new Response(tid,title, sentence);
			}
			SequenceGen.sentenceWordLength.set(0);
			wordCount++;
			SequenceGen.sentenceWordLengthNext();
			int tid=SequenceGen.titleSeqSer.get();
			sentence=request.getWord();
			respStataus.changeHttpStatus(HttpStatus.OK);
		    StoryExecutor.getStoryExcecutorInstance().submit(new StoryThread(request,commanService));
			return new Response(tid,title, sentence);
		}
		wordCount=0;
		SequenceGen.titleWordLength.set(0);
		SequenceGen.TitleWordLenghtNext();
		SequenceGen.titleNextNumInServic();
		int tid=SequenceGen.titleSeqSer.get();
		title=request.getWord();
		respStataus.changeHttpStatus(HttpStatus.CREATED);
	    StoryExecutor.getStoryExcecutorInstance().submit(new StoryThread(request,commanService));
		return new Response(tid,title, "");
		

	}

	public QueryResponse getQueryResposeOfStory(Optional<Integer> offset,Optional<Integer> limit,@RequestParam Optional<Order> order,Optional<Sort> sortby) {
		Direction dir=null;
		 String requestOrder=  order.orElse(Order.asc).toString();
		 if(requestOrder.equalsIgnoreCase("asc")) 
			  dir= Direction.ASC;
		 else
			 dir= Direction.DESC;
		
		Page<Title> pTitle =titleRepository.findAll(PageRequest.of(offset.orElse(0), limit.orElse(10), dir,
				sortby.orElse(Sort.title).toString()));
		List<Title> list=pTitle.toList();
        int count =list.size();
		return new QueryResponse(limit.orElse(10),offset.orElse(0), count, list);
	}
	


}
