package com.laptrinhjavaweb.utils;

import java.util.Collection;

public class ValidateUtils {
    public static boolean isValid(Object obj) {
        boolean isTrue = null != obj && !"".equals(obj.toString());

        if (isTrue) {
            if (obj instanceof String) {
                return true;
            } else if (obj instanceof Integer) {
                return true;
            } else if (obj instanceof Collection) {
                return !((Collection<?>) obj).isEmpty();
            }
        }
        return false;
    }
    public static Integer isValidInteger(Integer value){
        return value != null && value != -1 ? value : null ;
    }
}
