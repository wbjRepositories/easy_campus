package com.wbj.service;

import com.wbj.common.R;
import com.wbj.pojo.Businessman;

import java.util.ArrayList;

public interface BusinessmanService {
    R<ArrayList<Businessman>> getBusinessmanByPage(int currentPage, int pageSize);
}
