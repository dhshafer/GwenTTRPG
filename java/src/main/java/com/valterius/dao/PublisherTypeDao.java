package com.valterius.dao;

import java.util.List;

import com.valterius.model.PublisherType;

public interface PublisherTypeDao {
	/*
	 * get all (list)
	 * get by id
	 * add
	 * edit
	 * delete
	 */
	List<PublisherType> getAllPublisherTypes();
	PublisherType getPublisherTypeById(PublisherType publisherType);
	PublisherType addPubisherType(PublisherType publisherType);
	PublisherType editPublisherType(PublisherType publisherType);
	void deletePublisherType(PublisherType publisherType);
}
