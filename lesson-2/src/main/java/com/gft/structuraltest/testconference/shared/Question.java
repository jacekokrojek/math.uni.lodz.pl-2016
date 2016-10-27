package com.gft.structuraltest.testconference.shared;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="QUESTION")
@XmlType(name="QUESTION", propOrder={"id","questionText","type","answers"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Question {
	
	@XmlElement(name="ID")
	private Long id;
	@XmlElement(name="QUESTION_TEXT")
	private String questionText;
	@XmlElement(name="QUESTION_TYPE")
	private String type;	
	@XmlElement(name="ANSWER")
	private List<Answer> answers;
		
	public Question() {
		answers = new ArrayList<Answer>();
	}
		
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getQuestionText() {
		return questionText;
	}
	
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}
	
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
			
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", questionText=" + questionText
				+ ", type=" + type + ", answers=" + answers + "]";
	}

}
