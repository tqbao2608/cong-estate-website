package com.laptrinhjavaweb.utils;

import java.util.Map;

public class MapUtils {
    public static Object mapValue(Map<String, Object> map, String key) {
        return map.containsKey(key) ? map.get(key) : null;

    }

    public static boolean checkMap(Map<String, Object> map) {
        return map != null ? true : false;
    }
}
