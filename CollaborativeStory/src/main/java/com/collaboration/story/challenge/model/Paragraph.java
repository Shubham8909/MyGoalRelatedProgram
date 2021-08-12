package com.collaboration.story.challenge.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Paragraph {
	@Id
	@JsonIgnore
	private int id;
	@Enumerated(EnumType.STRING)
	@JsonIgnore
	private Status status;
	@OneToMany(targetEntity =Sentence.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="paragraph_fk",referencedColumnName = "id")
	@JsonProperty("sentences")
	private List<Sentence> listOfSentence;
	
	public Paragraph() {
		this.listOfSentence=new ArrayList<Sentence>();
	}
	
}
