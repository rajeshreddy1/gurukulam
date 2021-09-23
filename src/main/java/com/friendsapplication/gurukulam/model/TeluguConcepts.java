package com.friendsapplication.gurukulam.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class TeluguConcepts {
    @Id
    @Column(name="concept_id")
    private int conceptId;
    @Column(name="syllabus_id")
    private int syllabusId;
    private String conceptPath;
    private int conceptOrder;
    private String conceptDetails;

    public TeluguConcepts() {
    }

    public TeluguConcepts(int conceptId, int syllabusId, String conceptPath, int conceptOrder, String conceptDetails) {
        this.conceptId = conceptId;
        this.syllabusId = syllabusId;
        this.conceptPath = conceptPath;
        this.conceptOrder = conceptOrder;
        this.conceptDetails = conceptDetails;
    }

    public int getConceptId() {
        return conceptId;
    }

    public void setConceptId(int conceptId) {
        this.conceptId = conceptId;
    }

    public int getSyllabusId() {
        return syllabusId;
    }

    public void setSyllabusId(int syllabusId) {
        this.syllabusId = syllabusId;
    }

    public String getConceptPath() {
        return conceptPath;
    }

    public void setConceptPath(String conceptPath) {
        this.conceptPath = conceptPath;
    }

    public int getConceptOrder() {
        return conceptOrder;
    }

    public void setConceptOrder(int conceptOrder) {
        this.conceptOrder = conceptOrder;
    }

    public String getConceptDetails() {
        return conceptDetails;
    }

    public void setConceptDetails(String conceptDetails) {
        this.conceptDetails = conceptDetails;
    }

    @Override
    public String toString() {
        return "TeluguConcepts{" +
                "conceptId=" + conceptId +
                ", syllabusId=" + syllabusId +
                ", conceptPath='" + conceptPath + '\'' +
                ", conceptOrder=" + conceptOrder +
                ", conceptDetails='" + conceptDetails + '\'' +
                '}';
    }
}
