package com.benhession.mockspinemhsoutbound.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.benhession.mockspinemhsoutbound.model.EhrExtractStatus;

@Repository
public interface EhrExtractStatusRepository extends CrudRepository<EhrExtractStatus, String> {
     EhrExtractStatus findEhrExtractStatusByConversationId(String conversationId);
}
