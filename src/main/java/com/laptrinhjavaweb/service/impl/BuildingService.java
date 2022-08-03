package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.BuildingSearch;
import com.laptrinhjavaweb.buildingenum.DistrictEnum;
import com.laptrinhjavaweb.buildingenum.TypeBuildingEnum;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.request.BuildingRequestDTO;
import com.laptrinhjavaweb.dto.request.BuildingSearchDTO;
import com.laptrinhjavaweb.dto.response.BuildingManagerResponseDTO;
import com.laptrinhjavaweb.dto.response.BuildingResponseDTO;
import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.AssignmentRepository;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import com.laptrinhjavaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private BuildingRepositoryCustom buildingRepositoryCustom;

    @Override
    public List<BuildingResponseDTO> findAll() {
        List<BuildingEntity> entities = buildingRepository.findAll();
        List<BuildingResponseDTO> result = new ArrayList<>();
        for (BuildingEntity item: entities) {
            BuildingResponseDTO  dto = buildingConverter.convertToDto(item);
            result.add(dto);
        }
         List<String> districts = new ArrayList<>();
        for (DistrictEnum item: DistrictEnum.values()) {
            districts.add(item.getValue());
        }
        return result;
    }

    @Override
    public Map<String, String> getDistrictEnum() {
        Map<String, String> result = new HashMap<>();
        for (DistrictEnum item: DistrictEnum.values()) {
            result.put(item.name(),item.getValue());
        }
        return result;
    }

    @Override
    public Map<String, String> getTypeBuildingEnum() {
        Map<String, String> result = new HashMap<>();
        for (TypeBuildingEnum item: TypeBuildingEnum.values()) {
            result.put(item.name(),item.getValue());
        }
        return result;
    }

    @Override
    public List<BuildingResponseDTO> findBuilding(BuildingSearchDTO dto) {
        List<BuildingResponseDTO>  result = new ArrayList<>();
        List<BuildingEntity> buildingEntities = buildingRepositoryCustom.findBuildingByBuilder(convertDtoToBuilder(dto));
        for (BuildingEntity item: buildingEntities) {

            result.add(buildingConverter.convertToDto(item));
        }
        return result;
    }


    @Override
    @Transactional
    public BuildingResponseDTO save(long id,BuildingRequestDTO dto) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(dto);
        if (id > 0){
            buildingEntity.setId(id);
        }
        buildingRepository.save(buildingEntity);
        List<RentAreaEntity> rentAreaEntityList = buildingEntity.getRentAreaEntityList();
        if (buildingEntity.getId() != null){
            rentAreaRepository.deleteByBuilding(buildingEntity);
        }
        if(rentAreaEntityList != null && !rentAreaEntityList.isEmpty()){
            rentAreaRepository.save(rentAreaEntityList);
        }
        return buildingConverter.convertToDto(buildingEntity);
    }

    @Override
    @Transactional
    public void deleteBuilding(long[] id) {
        if (id.length > 0 && id != null){
            List<BuildingEntity> buildingEntities = buildingRepository.findByIdIn(id);
            if (!buildingEntities.isEmpty() && buildingEntities != null){
                rentAreaRepository.deleteByBuildingIn(buildingEntities);
                assignmentRepository.deleteByBuildingEntityIn(buildingEntities);
            }
            buildingRepository.deleteByIdIn(id);
        }

    }

    @Override
    public BuildingResponseDTO findBuildingById(long id) {
        BuildingEntity buildingEntity = buildingRepository.findOne(id);
        return buildingConverter.convertToDto(buildingEntity);
    }


    @Override
    @Transactional
    public void assignmentBuildingForStaffs(long buildingId, List<Long> staffIds) {
        BuildingEntity buildingEntity = buildingRepository.findById(buildingId);
        List<AssignmentBuildingEntity> assignmentBuildingEntityList = buildingEntity.getAssignmentBuildingEntities();
        List<Long> oldStaffs = new ArrayList<>();
        List<Long> newStaffs = new ArrayList<>();
        // danh sách nhân viên quản lý tòa nhà
        List<Long> currentStaffs = new ArrayList<>();

        // id = 1 có nhân viên 2 3
        // nhân viên 3 4
        for (AssignmentBuildingEntity item : assignmentBuildingEntityList) {
            currentStaffs.add(item.getUserEntity().getId());
        }
        checkNewStaffAndOldStaff(staffIds, currentStaffs, newStaffs, oldStaffs);
        BuildingEntity buildingAction = new BuildingEntity();
        buildingAction.setId(buildingId);

        deleteBuildingFromOldStaffs(buildingAction, oldStaffs);
        saveBuildingFromNewStaffs(buildingAction, newStaffs);
    }

    private void deleteBuildingFromOldStaffs(BuildingEntity buildingAction, List<Long> oldStaffs) {
        if(!oldStaffs.isEmpty()){
            for (Long item: oldStaffs) {
                UserEntity userEntity = new UserEntity();
                userEntity.setId(item);
                assignmentRepository.deleteByBuildingEntityAndUserEntity(buildingAction,userEntity);
            }
        }
    }

    private void saveBuildingFromNewStaffs(BuildingEntity buildingAction, List<Long> newStaffs) {
        if(!newStaffs.isEmpty()){
            for (Long item: newStaffs) {
                UserEntity userEntity = new UserEntity();
                userEntity.setId(item);
                AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
                assignmentBuildingEntity.setUserEntity(userEntity);
                assignmentBuildingEntity.setBuildingEntity(buildingAction);
                assignmentRepository.save(assignmentBuildingEntity);

            }
        }
    }

    private void checkNewStaffAndOldStaff(List<Long> staffIds, List<Long> currentStaffs, List<Long> newStaffs, List<Long> oldStaffs) {
        if (staffIds.isEmpty()) {
            if (currentStaffs.isEmpty())
                return;
            oldStaffs.addAll(currentStaffs);
        } else {
            if (!currentStaffs.isEmpty()) {

                for (int i = 0; i < currentStaffs.size(); i++) {
                    if (!staffIds.contains(currentStaffs.get(i))) {
                        oldStaffs.add(currentStaffs.get(i));
                    } else {
                        staffIds.remove(currentStaffs.get(i));
                    }
                }
                if (staffIds.isEmpty())
                    return;
            }
            newStaffs.addAll(staffIds);
        }
    }

    private void convertObjectToMap(Map<String, Object> objectMap, List<String> list, BuildingSearchDTO dto) {
        Field[] allFields = dto.getClass().getDeclaredFields();
        for (Field field : allFields) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(dto);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if ( value != null && !value.equals("") && !(value instanceof Collection)){
                objectMap.put(field.getName().toLowerCase(), value);
            } else if (value instanceof Collection){
                list.addAll((List<String>) value);
            }
        }
    }

    private BuildingSearch convertDtoToBuilder(BuildingSearchDTO dto){
        BuildingSearch buildingSearch = new BuildingSearch.BuildingSearchBuilder()
                .name(dto.getName())
                .district(dto.getDistrict())
                .floorArea(dto.getFloorArea())
                .ward(dto.getWard())
                .street(dto.getStreet())
                .numberOfBasement(dto.getNumberOfBasement())
                .direction(dto.getDirection())
                .level(dto.getLevel())
                .areaFrom(dto.getAreaFrom())
                .areaTo(dto.getAreaTo())
                .rentPriceFrom(dto.getRentPriceFrom())
                .rentPriceTo(dto.getRentPriceTo())
                .managerName(dto.getManagerName())
                .managerPhone(dto.getManagerPhone())
                .staffId(dto.getStaffId())
                .typesList(dto.getTypesList())
                .build();
        return  buildingSearch;
    }


}
