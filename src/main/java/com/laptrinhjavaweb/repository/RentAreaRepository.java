package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long> {

   List<RentAreaEntity> findByBuildingId(Long id);

   @Transactional
   void deleteByBuildingIn(List<BuildingEntity> building);
   @Transactional
   void deleteByBuilding(BuildingEntity entity);
}
