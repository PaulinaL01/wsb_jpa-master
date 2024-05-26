package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitRelationTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
public class VisitRelationMapper {
    public static VisitRelationTO mapToTO(DoctorEntity doctorEntity, PatientEntity patientEntity, VisitEntity visitEntity){
        VisitRelationTO visitRelationTO = new VisitRelationTO();
        visitRelationTO.setVisit(VisitTOMapper.mapToTO(visitEntity));
        visitRelationTO.setPatient(PatientMapper.mapToTO(patientEntity));
        visitRelationTO.setDoctor(DoctorMapper.mapToTO(doctorEntity));

        return visitRelationTO;
    }
}
