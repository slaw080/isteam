package com.bjgoodwill.isteam.system.service;


import com.bjgoodwill.isteam.common.domain.QueryRequest;
import com.bjgoodwill.isteam.common.service.IService;
import com.bjgoodwill.isteam.system.domain.Dict;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @ClassName DictService
 * @Description 字典服务
 * @Author LI JUN
 * @Date 2018/11/7 11:24
 * @Version 0.0.1
 */
@CacheConfig(cacheNames = "DictService")
public interface DictService extends IService<Dict> {

    @Cacheable(key = "#p0.toString() + (#p1 != null ? #p1.toString() : '')")
    List<Dict> findAllDicts(Dict dict, QueryRequest request);

    @Cacheable(key = "#p0")
    Dict findById(Long dictId);

    @CacheEvict(allEntries = true)
    void addDict(Dict dict);

    @CacheEvict(key = "#p0", allEntries = true)
    void deleteDicts(String dictIds);

    @CacheEvict(key = "#p0", allEntries = true)
    void updateDict(Dict dicdt);
}
