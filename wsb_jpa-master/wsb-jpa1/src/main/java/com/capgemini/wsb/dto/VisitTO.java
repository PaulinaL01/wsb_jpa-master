package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class VisitTO {

    private Long id;

    private String description;

    private LocalDateTime time;

    private VisitRelationTO visitRelation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public VisitRelationTO getVisitRelation(){return visitRelation;}

    public void setVisitRelation(VisitRelationTO visitRelation){this.visitRelation=visitRelation;}
}
