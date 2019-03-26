package com.yummy.dao;

import com.yummy.util.message.datamessage.UpdateDataMessage;

import java.util.List;

public interface Dao<T> {
    T get(int id);

    List<T> getByQuery(String Query);

    UpdateDataMessage save(T t);

    UpdateDataMessage update(T t);

    UpdateDataMessage delete(T t);
}
