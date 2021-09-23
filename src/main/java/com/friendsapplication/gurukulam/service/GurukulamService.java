package com.friendsapplication.gurukulam.service;

import com.friendsapplication.gurukulam.model.TeluguConcepts;
import com.friendsapplication.gurukulam.model.SubjectMaster;
import com.friendsapplication.gurukulam.model.SubjectWithSyllabus;
import com.friendsapplication.gurukulam.model.SyllabusMaster;

import java.util.List;

public interface GurukulamService {
    Iterable<SubjectMaster> getSubjectsInfo();

    Iterable<SyllabusMaster> getSyllabusInfo();

    List<SyllabusMaster> getSyllabus(String subjectCode);

    List<SubjectWithSyllabus> getSubject_SyllabusInfo();

    List<TeluguConcepts> getSyllabus_ConceptsInfo();

    List<TeluguConcepts> getSyllabusPerConceptsInfo(int syllabusId);

    List<TeluguConcepts> getSyllabus_Concepts_Random(int syllabusId);
}
