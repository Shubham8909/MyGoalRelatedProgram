package com.collaboration.story.challenge.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Sentence {

	@Id
	@JsonIgnore
	private int id;
	@Enumerated(EnumType.STRING)
	@JsonIgnore
	private Status status;
	@JsonProperty("sentence")
	private String sentence_text;
}
