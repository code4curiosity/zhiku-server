package com.ccbjb.common.mybatis;

import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * BaseDao
 */
public interface BaseDao<T> {
    void save(T model);//持久化
    void save(List<T> models);//批量持久化
    void deleteById(Long id);//通过主鍵刪除
    void update(T model);//更新
    T findById(Long id);//通过ID查找
    List<T> findAll();//获取所有
}
