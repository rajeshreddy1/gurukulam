package com.friendsapplication.gurukulam.model;

import lombok.Data;
import java.util.List;

@Data
public class SubjectWithSyllabus {

    private SubjectMaster subject;

    private List<SyllabusMaster> syllabus;

    public SubjectWithSyllabus() {
    }

    public SubjectWithSyllabus(SubjectMaster subject, List<SyllabusMaster> syllabus) {
        this.subject = subject;
        this.syllabus = syllabus;
    }

    public SubjectMaster getSubject() {
        return subject;
    }

    public void setSubject(SubjectMaster subject) {
        this.subject = subject;
    }

    public List<SyllabusMaster> getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(List<SyllabusMaster> syllabus) {
        this.syllabus = syllabus;
    }

    @Override
    public String toString() {
        return "SubjectWithSyllabus{" +
                "subject=" + subject +
                ", syllabus=" + syllabus +
                '}';
    }
}
