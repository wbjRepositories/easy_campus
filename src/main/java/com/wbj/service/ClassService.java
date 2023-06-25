package com.wbj.service;

import com.wbj.common.R;
import com.wbj.pojo.Class;

import java.util.ArrayList;

public interface ClassService {
    R<ArrayList<Class>> getAllClass();

    R addClass(Class c);

    R updateClass(Class c);

    R removeClass(int ...ids);
}
