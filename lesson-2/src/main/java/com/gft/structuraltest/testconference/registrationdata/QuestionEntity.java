package com.gft.structuraltest.testconference.registrationdata;

	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Lob;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;

	@Entity
	@Table(name="QUESTIONS")
	public class QuestionEntity {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="ID", unique=true, nullable=false)
		private Long id;

		@Column(name="TYPE")
		private String type;

		@Column(name="QUESTION_TEXT", length=1000)
		@Lob
		private String questionText;

		@OneToMany(mappedBy="question", fetch=FetchType.EAGER,
				cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
		private List<AnswerEntity> answers;

		@Column(name="CORRECT_ANSWER")
		private Long correctAnswer;

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

		public List<AnswerEntity> getAnswers() {
			return answers;
		}

		public void setAnswers(List<AnswerEntity> answers) {
			this.answers = answers;
		}

		public Long getCorrectAnswer() {
			return correctAnswer;
		}

		public void setCorrectAnswer(Long correctAnswer) {
			this.correctAnswer = correctAnswer;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return "QuestionEntity [id=" + id + ", type=" + type
					+ ", questionText=" + questionText + ", correctAnswer="
					+ correctAnswer + "]";
		}



	}
