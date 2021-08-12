package com.collaboration.story.challenge.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Title {
	@Id
	@GeneratedValue
	private int id;
	private String title;
	@Enumerated(EnumType.STRING)
	@JsonIgnore
	private Status status;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.00'Z'")
	@Column(name="created_at")
	private Date created_at;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.00'Z'")
	@Column(name="updated_at")
	private Date  update_at;
	@OneToMany(targetEntity =Paragraph.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="title_fk",referencedColumnName = "id")
	@JsonProperty("paragraphs")
	private List<Paragraph> listOfPara;
	
	public Title() {
		this.listOfPara=new ArrayList<Paragraph>();
	}
	
}
