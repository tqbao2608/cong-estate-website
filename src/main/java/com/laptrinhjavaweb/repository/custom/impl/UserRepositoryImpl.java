package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> findByBuildingId(long id) {
        StringBuilder sql = new StringBuilder("SELECT u.* FROM users as u");
        if(id != 0){
            sql.append(" inner join assignmentbuilding as ab on u.id= ab.staff_id");
            sql.append(" inner join building as b on b.id = ab.building_id where b.id = " + id);
        }
        Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
        return query.getResultList();
    }
}
