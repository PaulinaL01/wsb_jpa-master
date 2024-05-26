package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import java.util.List;

public interface PatientService
{
    PatientTO findPatientById(Long id);

    void deletePatient(Long id);

    List<VisitTO> findAllVisitsByPatientID(Long id);
}
