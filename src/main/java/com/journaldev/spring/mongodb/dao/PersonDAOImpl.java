package com.journaldev.spring.mongodb.dao;

import com.journaldev.spring.mongodb.model.Person;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("personDAO")
public class PersonDAOImpl implements PersonDAO {
	@Autowired
	private MongoOperations mongoOps;
	private static final String PERSON_COLLECTION = "Person";

	public PersonDAOImpl() {
	}

	public PersonDAOImpl(MongoOperations mongoOps){
		this.mongoOps=mongoOps;
	}

	public void create(Person p) {
		this.mongoOps.insert(p, PERSON_COLLECTION);
		System.out.println("MongoTempl - "+mongoOps.toString());
	}

	public Person readById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoOps.findOne(query, Person.class, PERSON_COLLECTION);

	}

	public void update(Person p) {
		this.mongoOps.save(p, PERSON_COLLECTION);
		System.out.println("MongoTempl - "+mongoOps.toString());
	}

	public int deleteById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult result = this.mongoOps.remove(query, Person.class, PERSON_COLLECTION);
		System.out.println("MongoTempl - "+mongoOps.toString());
		return result.getN();
	}

}


