package com.youkeda.service;

import com.youkeda.model.*;

import java.util.List;

/**
 * ClassesService
 */
public interface ClassesService {

    void add(Classes classes);

    List<Classes> getAll();

    default Classes get(String classesId) {
        List<Classes> classess = getAll();
        for (Classes classes : classess) {
            if (classes.getId().equals(classesId)) {
                return classes;
            }
        }
        return null;
    }

}