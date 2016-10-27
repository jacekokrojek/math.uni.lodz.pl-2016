package com.gft.structuraltest.testconference.registrationdata;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class QuestionEAO extends BaseEAO {
	
	private static final Logger logger = Logger.getLogger(QuestionEAO.class);

    @Override
    public Class getEntityClass() {
        return QuestionEntity.class;
    }

    public void persist(QuestionEntity entity) throws Exception{
		logger.debug("Persisting the following Question entity: " + entity);	
		for (int a = 0; a < entity.getAnswers().size(); a++) {
			AnswerEntity mergerAnswer = entity.getAnswers().get(a);
			getSession().persist(mergerAnswer);
			mergerAnswer = (AnswerEntity) getSession().merge(mergerAnswer);
			if (entity.getCorrectAnswer().equals(new Integer(a).longValue())) {
				entity.setCorrectAnswer(mergerAnswer.getId());
			}
		}
		getSession().persist(entity);
		
	}
	
	public void merge(QuestionEntity entity) throws Exception{
		logger.debug("Merging the following Question entity: " + entity);
		getSession().merge(entity);
	}

	
	public int countAllQuestions(String type) {
		logger.debug("EAO counting all questions for the type: " + type);
		
		Criteria criteria = getCriteria();
		if (type != null && type.length() > 0 && !type.equals("ALL")) {
			criteria.add(Restrictions.like("type", type));
		}
		
		Long number = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();		
		return number.intValue();
	}

	
	public List<QuestionEntity> getQuestions(int rangeStart, int rangeEnd, String type) {
		logger.debug("EAO acquiring all questions for type: " + type +
				" range start: " + rangeStart + " range end: " + rangeEnd);
		
		Criteria criteria = getCriteria();
		if (type != null && type.length() > 0 && !type.equals("ALL")) {
			logger.debug("EAO using type criteria: " + type);
			criteria.add(Restrictions.like("type", type));
		}
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				
		criteria.setFirstResult(rangeStart);
		criteria.setMaxResults(rangeEnd - rangeStart);
		
		return criteria.list();
	}
	
	public void removeQuestion(long id) throws Exception{		
		QuestionEntity deleting = 
				(QuestionEntity) getSession().get(QuestionEntity.class, id);
		logger.debug("EAO removing the following question: " + deleting);
		if (deleting == null) {
			throw new Exception("Could not find question to be deleted.");
		}
		getSession().delete(deleting);
		
	}
	
	public QuestionEntity getQuestionById(long id){
		return (QuestionEntity) getSession().get(QuestionEntity.class, id);
	}
	
	public AnswerEntity getAnswerById(long id){
		return (AnswerEntity) getSession().get(AnswerEntity.class, id);
	}
}
