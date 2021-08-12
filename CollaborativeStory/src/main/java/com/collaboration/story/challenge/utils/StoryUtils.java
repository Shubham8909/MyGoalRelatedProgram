package com.collaboration.story.challenge.utils;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.collaboration.story.challenge.model.Paragraph;
import com.collaboration.story.challenge.model.Request;
import com.collaboration.story.challenge.model.Sentence;
import com.collaboration.story.challenge.model.Status;
import com.collaboration.story.challenge.model.Title;

public interface StoryUtils {

	static boolean isValidWordRequest(String word, String createRequestWordLimit) {
		String words[] = word.trim().split(" ");
		if (words.length > Integer.parseInt(createRequestWordLimit))
			return false;
		return true;
	}
	
	static boolean isReachedLimitLength(String word, String limit) {
		String words[] = word.trim().split(" ");
		if (words.length == Integer.parseInt(limit))
			return true;
		return false;
	}

	static boolean isValidRequest(Request resquest) {
		if (resquest == null || StringUtils.isEmpty(resquest.getWord()))
			return false;

		return true;
	}
	


	static Title getNewTitleObject(Request request) {
		Title t=new Title();
		int id =SequenceGen.titleNextNum();
		t.setId(id);
		t.setTitle(request.getWord().trim());
		t.setStatus(Status.INPROCESS);
		t.setCreated_at(new Date());
		t.setUpdate_at(new Date());
		return t;
	}

	static void updateTitleObject(Title t1, Request request) {
		t1.setTitle(t1.getTitle()+" "+request.getWord().trim());
		t1.setUpdate_at(new Date());
	}

	static Paragraph createParagraphObject() {
		Paragraph p= new Paragraph();
		int pid=SequenceGen.paragraphNextNum();
		p.setId(pid);
		p.setStatus(Status.INPROCESS);
		return p;
	}

	static Sentence createSentenceObject(Request request) {
		Sentence s=new Sentence();
		int sid=SequenceGen.sentenceNextNum();
		s.setId(sid);
		s.setSentence_text(request.getWord().trim());
		s.setStatus(Status.INPROCESS);
		return s;
	}

}
