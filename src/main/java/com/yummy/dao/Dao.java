package com.yummy.dao;

import com.yummy.util.message.datamessage.UpdateDataMessage;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    T get(int id);

    List<T> getByQuery(String Query);

    UpdateDataMessage save(T t);

    UpdateDataMessage update(T t);

    UpdateDataMessage delete(T t);
}
