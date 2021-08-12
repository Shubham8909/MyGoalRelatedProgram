package com.collaboration.story.challenge.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGen {
	
	public static AtomicInteger titleSeq = new AtomicInteger(1);
	public static AtomicInteger paragraphSeq = new AtomicInteger(1);
	public static AtomicInteger sentenceSeq = new AtomicInteger(1);
	
	public static AtomicInteger titleSeqSer = new AtomicInteger(1);
	public static AtomicInteger sentenceSeqSer = new AtomicInteger(0);
	
	public static AtomicInteger titleWordLength = new AtomicInteger(0);
	public static AtomicInteger sentenceWordLength = new AtomicInteger(0);
	
	public static int titleNextNum() {
		return titleSeq.getAndIncrement();
	}
	public static int titleNextNumInServic() {
		return titleSeqSer.getAndIncrement();
	}
	public static int paragraphNextNum() {
		return paragraphSeq.getAndIncrement();
	}
	public static int sentenceNextNum() {
		return sentenceSeq.getAndIncrement();
	}
	public static int sentenceNextNumSer() {
		return sentenceSeqSer.getAndIncrement();
	}
	
	
	public static int TitleWordLenghtNext() {
		return titleWordLength.getAndIncrement();
	}
	public static int sentenceWordLengthNext() {
		return sentenceWordLength.getAndIncrement();
	}
	
}