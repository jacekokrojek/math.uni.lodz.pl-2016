package com.gft.structuraltest.testconference.registrationdata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="REGISTRATIONS",
		uniqueConstraints={@UniqueConstraint(columnNames={"ID","EMAIL"})})
public class RegistrationEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", unique=true, nullable=false)
	private Long id;
	
	@Column(name="FIRST_NAME", length=20, nullable=false)
	private String firstName;
	
	@Column(name="LAST_NAME", length=40, nullable=false)
	private String lastName;
	
	@Column(name="EMAIL", length=50, unique=true, nullable=false)
	private String email;
	
	@Column(name="PHONE", length=20)
	private String phone;
	
	@Column(name="CITY", length=50)
	private String city;
	
	@Column(name="INTERESTS", length=250)
	private String interests;

	@OneToOne(fetch=FetchType.EAGER)
	private QuestionEntity question;
		
	@OneToOne(fetch=FetchType.EAGER)
	private AnswerEntity answer;

	@Column(name="CORRECT")
	private boolean correct;
	
	@Column(name="PRIZE")
	private Integer prize = 0;
	
	@Column(name="CONTRACT_TYPE")
	private Boolean contractType;
	
	@Column(name="PERMANENT_TYPE")
	private Boolean permanentType;
	
	@Column(name="GRADUATE_TYPE")
	private Boolean graduateType;
	
	@Column(name="SUMMER_TYPE")
	private Boolean summerType;
		
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public QuestionEntity getQuestion() {
		return question;
	}

	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}

	public AnswerEntity getAnswer() {
		return answer;
	}

	public void setAnswer(AnswerEntity answer) {
		this.answer = answer;
	}
	
	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	public Integer getPrize() {
		return prize;
	}

	public void setPrize(Integer prize) {
		this.prize = prize;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}
	
	
	public Boolean getContractType() {
		return contractType;
	}

	public void setContractType(Boolean contractType) {
		this.contractType = contractType;
	}

	public Boolean getPermanentType() {
		return permanentType;
	}

	public void setPermanentType(Boolean permanentType) {
		this.permanentType = permanentType;
	}

	public Boolean getGraduateType() {
		return graduateType;
	}

	public void setGraduateType(Boolean graduateType) {
		this.graduateType = graduateType;
	}

	public Boolean getSummerType() {
		return summerType;
	}

	public void setSummerType(Boolean summerType) {
		this.summerType = summerType;
	}

	@Override
	public String toString() {
		return "RegistrationEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", question=" + question + ", answer=" + answer + ", correct=" + correct + ", prize=" + prize
				+ ", phone=" + phone + ", city=" + city + ", interests=" + interests + ", contractType=" + contractType
				+ ", permanentType=" + ", graduateType=" + graduateType + ", summerType:" + summerType + "]";
	}
	
}
