package com.capgemini.wsb.persistence.dao.impl;


import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.persistence.TypedQuery;
import java.time.LocalDate;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{
    @Override
    public List<PatientEntity> findPatientsByLastName(String lastName) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "select p from PatientEntity p where p.lastName = :lastName",
                PatientEntity.class
        );
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }
    @Override
    public List<PatientEntity> findPatientsWithMoreThanXVisits(int x) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "select p from PatientEntity p where size(p.visits) > :x ",
                PatientEntity.class
        );
        query.setParameter("x", x);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsOlderThan(int x) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "select p from PatientEntity p where p.age > :x",
                PatientEntity.class
        );
        query.setParameter("x", x);
        return query.getResultList();
    }
}

