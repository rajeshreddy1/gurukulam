package com.friendsapplication.gurukulam.repository;

import com.friendsapplication.gurukulam.model.SyllabusMaster;
import org.springframework.data.repository.CrudRepository;

public interface GurukulamSyllabusRepo extends CrudRepository<SyllabusMaster, Integer> {
    Iterable<SyllabusMaster> findBySubjectCode(String subjectCode);
}
