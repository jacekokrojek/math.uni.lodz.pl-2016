package com.gft.structuraltest.testconference.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="ANSWER")
@XmlType(name="ANSWER", propOrder={"id","answerText"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Answer{

	@XmlElement(name="ID")
	private Long id;
	@XmlElement(name="ANSWER_TEXT")
	private String answerText;
	
	public Answer() {}
	
	public Answer(String answer) {
		this.answerText = answer;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	
	@Override
	public String toString() {
		return "Answer [answerText=" + answerText + "]";
	}
	
	
}
