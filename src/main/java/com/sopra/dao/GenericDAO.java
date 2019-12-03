package com.sopra.dao;

import java.util.List;

import com.sopra.model.Client;
import com.sopra.model.Login;

public interface GenericDAO<T, K> {
List<T> findAll();
T findByKey(K id);
T insert (T obj);
T update(T obj);
void deleteByKey(K key);
}
