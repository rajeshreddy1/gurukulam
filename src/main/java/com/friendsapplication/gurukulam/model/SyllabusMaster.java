package com.friendsapplication.gurukulam.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class SyllabusMaster {
    @Id
    @Column(name = "syllabus_id")
    private int syllabusId;
    private String syllabusName;
    private String subjectCode;
}
