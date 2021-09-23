package com.friendsapplication.gurukulam.service;

import com.friendsapplication.gurukulam.model.TeluguConcepts;
import com.friendsapplication.gurukulam.model.SubjectMaster;
import com.friendsapplication.gurukulam.model.SubjectWithSyllabus;
import com.friendsapplication.gurukulam.model.SyllabusMaster;
import com.friendsapplication.gurukulam.repository.GurukulamConceptsDAO;
import com.friendsapplication.gurukulam.repository.GurukulamJDBCRepo;
import com.friendsapplication.gurukulam.repository.GurukulamSyllabusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GurukulamServiceImpl implements GurukulamService{

    @Autowired
    public GurukulamJDBCRepo gurukulamJDBCRepo;

    @Autowired
    public GurukulamSyllabusRepo gurukulamSyllabusRepo;

    @Autowired
    public GurukulamConceptsDAO gurukulamConceptsDAO;

    @Override
    public Iterable<SubjectMaster> getSubjectsInfo() {
        return gurukulamJDBCRepo.findAll();
    }

    @Override
    public Iterable<SyllabusMaster> getSyllabusInfo() {
        return gurukulamSyllabusRepo.findAll();
    }

    @Override
    public List<SyllabusMaster> getSyllabus(String subjectCode) {
        return (List<SyllabusMaster>) gurukulamSyllabusRepo.findBySubjectCode(subjectCode);
    }

    @Override
    public List<SubjectWithSyllabus> getSubject_SyllabusInfo() {
        List<SubjectWithSyllabus> subjectSyllabusInfo = new ArrayList<SubjectWithSyllabus>();

        Iterable<SubjectMaster> subjects= getSubjectsInfo();
        subjects.forEach(i -> {
            SubjectWithSyllabus subSyllabus = new SubjectWithSyllabus();
            subSyllabus.setSubject(i);
            subSyllabus.setSyllabus(getSyllabus(i.getSubjectCode()));
            subjectSyllabusInfo.add(subSyllabus);
        });
        return subjectSyllabusInfo;
    }

    @Override
    public List<TeluguConcepts> getSyllabus_ConceptsInfo() {
        List<TeluguConcepts> conceptsMaster = (List<TeluguConcepts>) gurukulamConceptsDAO.findAll();
        return conceptsMaster;
    }

    @Override
    public List<TeluguConcepts> getSyllabusPerConceptsInfo(int syllabusId) {
        List<TeluguConcepts> conceptsMaster = (List<TeluguConcepts>) gurukulamConceptsDAO.findBySyllabusId(syllabusId).stream().sorted(Comparator.comparing(TeluguConcepts::getConceptOrder)).collect(Collectors.toList());
        return conceptsMaster;
    }

    @Override
    public List<TeluguConcepts> getSyllabus_Concepts_Random(int syllabusId) {
        List<TeluguConcepts> conceptsMaster_1 = (List<TeluguConcepts>) gurukulamConceptsDAO.findBySyllabusId(syllabusId).stream().sorted(Comparator.comparing(TeluguConcepts::getConceptOrder)).collect(Collectors.toList());
        int listSize = conceptsMaster_1.size();
        List<TeluguConcepts> conceptsMaster_2 = conceptsMaster_1.stream().collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
            Collections.shuffle(collected);
            return collected.stream();
        })).limit(listSize).collect(Collectors.toList());
        return conceptsMaster_2;
    }
}
