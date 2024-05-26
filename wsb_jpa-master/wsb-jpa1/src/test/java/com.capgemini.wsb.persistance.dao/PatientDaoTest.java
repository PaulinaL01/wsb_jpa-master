package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    public void shouldFindPatientByLastName() {
        String lastName = "Nudziara";
        List<PatientEntity>  patients = patientDao.findPatientsByLastName(lastName);

        assertNotNull(patients);
        assertEquals(1, patients.size());

        for (PatientEntity patient: patients) {
            assertEquals(lastName, patient.getLastName());
        }
    }

    @Test
    public void shouldFindPatientWhoHasMoreThanXVisits() {
        int X = 0;
        List<PatientEntity> patients = patientDao.findPatientsWithMoreThanXVisits(X);

        assertNotNull(patients);
        assertEquals(5, patients.size());
    }

    @Test
    public void shouldFindPatientOlderThan() {
        int age = 100;
        List<PatientEntity> patients = patientDao.findPatientsOlderThan(age);

        assertNotNull(patients);
        assertEquals(1, patients.size());
    }
}
