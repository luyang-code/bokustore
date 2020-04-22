package com.tsc.graduateproj.bokubookstore.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static boolean isEmpty(List list) {
        return list == null || (list.size() <= 0);
    }

    public static <T> List<T> page(List<T> list, int page, int size) {
        page = page - 1 > 0 ? page - 1 : 0;

        int start = page * size;
        int end = page * size + size;

        end = end > list.size() ? list.size() : end;
        //start>=end
        if (start > end) {
            return new ArrayList<>();
        }

        return list.subList(start, end);
    }

}
