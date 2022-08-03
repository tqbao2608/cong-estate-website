package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.builder.BuildingSearch;
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import com.laptrinhjavaweb.utils.MapUtils;
import com.laptrinhjavaweb.utils.SqlUtils;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findBuildingByBuilder(BuildingSearch buildingSearch) {
        StringBuilder sql = new StringBuilder("SELECT b.*  FROM building AS b");
        StringBuilder joinQuery = new StringBuilder();
        StringBuilder whereQuery = new StringBuilder();
        buildQueryWithJoin(buildingSearch,joinQuery, whereQuery);
        buildQueryWithoutJoin(buildingSearch,whereQuery);
        sql.append(joinQuery)
                .append("\nWHERE 1 = 1")
                .append(whereQuery)
                .append("\nGROUP BY b.id");

        Query query = entityManager.createNativeQuery(sql.toString(),BuildingEntity.class);
        return query.getResultList();

    }

    private void buildQueryWithoutJoin(BuildingSearch buildingSearch, StringBuilder whereQuery) {
        // common
        buildNormalQuery(buildingSearch, whereQuery);
        //special
        Integer areaRentFrom = ValidateUtils.isValidInteger(buildingSearch.getAreaFrom());
        Integer areaRentTo = ValidateUtils.isValidInteger(buildingSearch.getAreaTo());
        Integer rentPriceFrom = ValidateUtils.isValidInteger(buildingSearch.getRentPriceFrom());
        Integer rentPriceTo = ValidateUtils.isValidInteger(buildingSearch.getRentPriceTo());
        if (null != areaRentFrom || null != areaRentTo) {
            whereQuery.append("\nAND EXISTS (SELECT * FROM rentarea ra WHERE b.id = ra.buildingid")
                    .append(SqlUtils.buildQueryUsingBetween("ra.value", areaRentFrom, areaRentTo))
                    .append(" )");
        }
        if (null != rentPriceFrom || null != rentPriceTo) {
            whereQuery.append(SqlUtils.buildQueryUsingBetween("b.rentprice", rentPriceFrom, rentPriceTo));
        }
    }

    private void buildNormalQuery(BuildingSearch buildingSearch, StringBuilder whereQuery) {
        Field[] fields = buildingSearch.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(buildingSearch);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            String colunmName = field.getName().toLowerCase();

            if (!SystemConstant.SPECIAL_PARAMS_FOR_BUILDING_SEARCH.contains(colunmName)) {
                String column = SystemConstant.BUILDING_ALIAS + colunmName;
                if (value != null && !value.toString().isEmpty()) {
                    if (value instanceof String){
                        whereQuery.append(SqlUtils.queryUsingLike(column, value));
                    }
                } else if (value != null) {
                    if (value instanceof Integer){
                        whereQuery.append(SqlUtils.queryUsingOperator(column, SystemConstant.EQUAL_OPERATOR, value));
                    }
                }
            }
        }
    }

    private void buildQueryWithJoin(BuildingSearch buildingSearch, StringBuilder joinQuery, StringBuilder whereQuery) {
        Long staffId =buildingSearch.getStaffId();
        List<String> list = buildingSearch.getTypesList();
        if (staffId != null && staffId != -1){
            joinQuery.append(" \nINNER JOIN assignmentbuilding AS ab ON b.id = ab.building_id ")
                    .append(" \nINNER JOIN  users AS us ON ab.staff_id = us.id ");

            whereQuery.append(SqlUtils.queryUsingOperator("ab.staff_id", "=",staffId));
        }

        if (ValidateUtils.isValid(list)) {
            whereQuery.append(" AND");
            String stringList;
            List<String> listValues = new ArrayList<>();
            for (int i = 0; i < list.size(); i++){
                stringList = " b.type LIKE '%" +list.get(i) +"%'";
                listValues.add(stringList);
            }
            //String join = String.join("OR",listValues);
            whereQuery.append( String.join("OR",listValues));
        }
    }
}
