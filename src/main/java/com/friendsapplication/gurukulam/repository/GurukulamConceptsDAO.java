package com.friendsapplication.gurukulam.repository;

import com.friendsapplication.gurukulam.model.TeluguConcepts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GurukulamConceptsDAO extends CrudRepository<TeluguConcepts, Integer> {
    List<TeluguConcepts> findBySyllabusId(int syllabusId);
}
