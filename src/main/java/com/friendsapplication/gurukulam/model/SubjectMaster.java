package com.friendsapplication.gurukulam.model;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class SubjectMaster {
    @Id
    private int subjectId;
    private String subjectName;
    private String subjectCode;

    public SubjectMaster() {
    }

    public SubjectMaster(int subjectId, String subjectName, String subjectCode) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    @Override
    public String toString() {
        return "SubjectMaster{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectCode='" + subjectCode + '\'' +
                '}';
    }
}
