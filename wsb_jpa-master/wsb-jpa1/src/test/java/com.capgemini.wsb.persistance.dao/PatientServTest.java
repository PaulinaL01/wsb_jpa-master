package com.capgemini.wsb.persistance.dao;


import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.dao.PatientDao;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.enums.Specialization;
import com.capgemini.wsb.persistence.enums.TreatmentType;
import com.capgemini.wsb.service.PatientService;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PatientServTest {
    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientService patientService;

    @Autowired
    private EntityManager entityManager;

    private PatientEntity firstpatientEntity(){
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setAge(5);
        patientEntity.setPatientNumber("1");
        patientEntity.setEmail("koty@koniec.com");
        patientEntity.setFirstName("Boo");
        patientEntity.setLastName("Tak");
        patientEntity.setTelephoneNumber("666666666");
        patientEntity.setDateOfBirth(LocalDate.of(2019,6,6));

        return patientEntity;
    }

    private DoctorEntity firstDoctorEntity(){
        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setFirstName("Alan");
        doctorEntity.setLastName("Szaman");
        doctorEntity.setEmail("alanmaszame@gmail.com");
        doctorEntity.setTelephoneNumber("111666666");
        doctorEntity.setSpecialization(Specialization.SURGEON);
        doctorEntity.setDoctorNumber("1");

        return doctorEntity;
    }
    private VisitEntity firstVisitEntity(){
        VisitEntity visitEntity = new VisitEntity();
        DoctorEntity doctorEntity = firstDoctorEntity();
        entityManager.persist(doctorEntity);

        visitEntity.setDescription("Sth");
        visitEntity.setDoctor(doctorEntity);
        visitEntity.setTime(LocalDateTime.now());
        visitEntity.setPatient(firstpatientEntity());

        return visitEntity;
    }

    @Test
    public void shouldFindPatientByPatientId() {
        PatientEntity patientEntity = firstpatientEntity();
        patientDao.save(patientEntity);

        PatientTO patientTO = patientService.findPatientById(patientEntity.getId());

        assertNotNull(patientTO);

        assertEquals(patientEntity.getId(), patientTO.getId());
        assertEquals(patientEntity.getFirstName(), patientTO.getFirstName());
        assertEquals(patientEntity.getLastName(), patientTO.getLastName());
        assertEquals(patientEntity.getTelephoneNumber(), patientTO.getTelephoneNumber());
        assertEquals(patientEntity.getEmail(), patientTO.getEmail());
        assertEquals(patientEntity.getPatientNumber(),  patientTO.getPatientNumber());
        assertEquals(patientEntity.getDateOfBirth(), patientTO.getDateOfBirth());
        assertEquals(patientEntity.getAge(), patientTO.getAge());
    }

    @Test
    public void shouldDeleteCascadePatient() {
        PatientEntity patientEntity = firstpatientEntity();
        patientDao.save(patientEntity);

        VisitEntity visitEntity = firstVisitEntity();
        visitEntity.setPatient(patientEntity);
        entityManager.persist(visitEntity);

        patientService.deletePatient(patientEntity.getId());
        PatientTO patientTO = patientService.findPatientById(patientEntity.getId());
        assertNull(patientTO);

        List<VisitEntity> visits = entityManager.createQuery("SELECT v from VisitEntity v WHERE v.patient.id = :patientId", VisitEntity.class).setParameter("patientId", patientEntity.getId()).getResultList();

        assertTrue(visits.isEmpty());

        DoctorEntity doctorEntity = entityManager.find(DoctorEntity.class, visitEntity.getDoctor().getId());
        assertNotNull(doctorEntity);
    }

    @Test
    public void shouldListVisitsByPatientId() {
        Long patientId = 1L;
        List<VisitTO> visits = patientService.findAllVisitsByPatientID(patientId);

        assertNotNull(visits);
        assertEquals(1, visits.size());
    }

}
