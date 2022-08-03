package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<AssignmentBuildingEntity,Long> {
    //void deleteByBuildingEntityAndUserEntity(AssignmentBuildingEntity entity);
    //void deleteByBuildingIdAndUserId(long buildingId, long userId);


    @Transactional
    void deleteByBuildingEntityAndUserEntity(
            @Param("buildingEntity") BuildingEntity buildingEntity,
            @Param("userEntity") UserEntity userEntity);

    @Transactional
    void deleteByBuildingEntityIn(List<BuildingEntity> buildingEntity);
//    @Transactional
//    void deleteByUserEntity(UserEntity entity);

}
