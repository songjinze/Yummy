package com.yummy.dao;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import com.yummy.entity.Product;
import com.yummy.util.message.UpdateDataMessage;

import java.util.List;

public interface ProductDao{

    int insertProduct(Product product);
    UpdateDataMessage updateProduct(Product product);
    UpdateDataMessage deleteProduct(Product product);

    List<Product> getProductByRid(int rid);
    List<Product> getProductByName(String name);

}
