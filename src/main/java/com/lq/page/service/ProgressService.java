package com.lq.page.service;

import com.lq.page.domain.entity.Progress;

public interface ProgressService {
    Progress queryById(Integer mid);
    int insert(Progress progress);
}
