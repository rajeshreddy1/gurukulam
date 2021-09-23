package com.friendsapplication.gurukulam.repository;

import com.friendsapplication.gurukulam.model.SubjectMaster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GurukulamJDBCRepo extends CrudRepository<SubjectMaster, Integer> {
}

