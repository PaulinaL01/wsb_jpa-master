package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import java.util.List;
import java.time.LocalDate;

public interface PatientDao extends Dao<PatientEntity, Long>
{
    List<PatientEntity> findPatientsByLastName(String lastName);

    List<PatientEntity> findPatientsWithMoreThanXVisits(int x);

    List<PatientEntity> findPatientsOlderThan(int x);
}
