package com.capgemini.wsb.dto;

public class VisitRelationTO {
    private DoctorTO doctor;

    private PatientTO patient;
    private VisitTO visit;

    public DoctorTO getDoctor() {
        return doctor;
    }

    public PatientTO getPatient() {
        return patient;
    }

    public VisitTO getVisit() {
        return visit;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    public void setPatient(PatientTO patient) {
        this.patient = patient;
    }

    public void setVisit(VisitTO visit) {
        this.visit = visit;
    }
}
