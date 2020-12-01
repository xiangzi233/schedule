package com.youkeda.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.youkeda.model.*;
import com.youkeda.service.*;

public class ClassesServiceImpl implements ClassesService {

    private static List<Classes> CLASSESS = new ArrayList<>();

    public void add(Classes classes) {
        CLASSESS.add(classes);
    }

    public List<Classes> getAll() {
        return CLASSESS;
    }

}