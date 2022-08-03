package com.laptrinhjavaweb.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlUtils {


    public static String queryUsingLike(String column, Object value) {
        return value != null ?
                String.format("\nAND %s LIKE %s", column, "'%" +value+ "%'") : "";
    }

    public static String queryUsingOperator(String column,String operator ,Object value) {
        return value != null ?
                String.format("\nAND %s %s %s", column, operator,value) : "";
    }
    public static String buildQueryUsingBetween(String column, Object from, Object to) {
        if (null == from && null == to) return "";
        else {
            if (null == from) from = 0;
            if (null == to) {
                if (from instanceof Integer) {
                    to = Integer.MAX_VALUE;
                } else if (from instanceof Double) {
                    to = Double.MAX_VALUE;
                }
            }

            return String.format("%nAND %s BETWEEN %s AND %s", column, from, to);
        }
    }
    public static <T> String buildQueryUsingIn(String column , List<T> values) {
        List<Object> convertedValues = new ArrayList<>();
        String joinValues;

        if (values.get(0) instanceof String) {
            for (Object item : values) {
                StringBuilder convertedItem = new StringBuilder();

                convertedItem.append("'")
                        .append(item.toString())
                        .append("'");

                convertedValues.add(convertedItem.toString());
            }
            joinValues = String.join(",", (List<String>)(Object) convertedValues);
        } else {
            String listString = values.toString();
            joinValues = listString.substring(1, listString.length()-1);
        }

        return String.format("%nAND %s IN (%s)", column, joinValues);
    }

}
