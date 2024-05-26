package com.capgemini.wsb.service.impl;
import java.util.List;
import java.util.stream.Collectors;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitTOMapper;

import com.capgemini.wsb.persistence.dao.PatientDao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;


@Service
@Transactional
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public PatientTO findPatientById(Long id) {
        PatientEntity patientEntity = patientDao.findOne(id);

        return PatientMapper.mapToTO(patientEntity);

    }

    @Override
    @Transactional
    public void deletePatient(Long id){

        String jpql = "DELETE FROM VisitEntity v WHERE v.patient.id = :patientId";
        entityManager.createQuery(jpql)
                .setParameter("patientId", id)
                .executeUpdate();

        PatientEntity patientEntity = patientDao.findOne(id);
        patientDao.delete(patientEntity);
    }

    @Override
    public List<VisitTO> findAllVisitsByPatientID(Long id) {
        PatientEntity patientEntity = patientDao.findOne(id);

        if (patientEntity == null) {
            return null;
        }

        return patientEntity.getVisits().stream()
                .map(VisitTOMapper::mapToTO)
                .collect(Collectors.toList());

    }

}
