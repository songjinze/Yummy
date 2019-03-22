package com.yummy.service.RestaurantService;
/*
 * author: SJZ
 * date: 2019/2/27
 */

import com.yummy.dao.RestaurantDao;
import com.yummy.entity.Product;
import com.yummy.entity.Restaurant;
import com.yummy.module.DiscountModule;
import com.yummy.module.ProductModule;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import com.yummy.util.message.servicemessage.ProductUpdateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public class RestaurantProductServiceImpl implements RestaurantProductService {
    private final RestaurantDao restaurantDao;
    @Autowired
    public RestaurantProductServiceImpl(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    @Override
    public ProductUpdateMessage createProduct(ProductModule productModule) {
        Product product=new Product();
        product.setName(productModule.getName());
        product.setLimitTime(productModule.getLimitTime());
        product.setPrice(productModule.getPrice());
        product.setLeftNum(productModule.getLeftNum());
        product.setDescrip(productModule.getDescrip());
        String restaurantIdCode=productModule.getRestaurantIdCode();
        Restaurant restaurant=restaurantDao.getRestaurantByIdCode(restaurantIdCode);
        restaurant.getProductSet().add(product);
        UpdateDataMessage updateDataMessage=restaurantDao.updateRestaurant(restaurant);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return ProductUpdateMessage.UPDATE_SUCCESS;
        }else{
            return ProductUpdateMessage.UPDATE_FAIL;
        }
    }

    @Override
    public ProductUpdateMessage createDiscount(DiscountModule discountModule) {
        return null;
    }

    @Override
    public ProductUpdateMessage modifyDiscount(DiscountModule discountModule) {
        return null;
    }

    @Override
    public DiscountModule getDiscount(String restaurantIdCode) {
        return null;
    }

    @Override
    public List<ProductModule> getProductList(String restaurantIdCode) {
        return null;
    }

    @Override
    public ProductUpdateMessage deleteProduct(ProductModule productModule) {
        Restaurant restaurant=restaurantDao.getRestaurantByIdCode(productModule.getRestaurantIdCode());
        Iterator iterator=restaurant.getProductSet().iterator();
        Product product=null;
        while(iterator.hasNext()){
            product=(Product) iterator.next();
            if(product.getName().equals(productModule.getName())){
                break;
            }
        }
        restaurant.getProductSet().remove(product);
        UpdateDataMessage updateDataMessage=restaurantDao.updateRestaurant(restaurant);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return ProductUpdateMessage.UPDATE_SUCCESS;
        }else{
            return ProductUpdateMessage.UPDATE_FAIL;
        }
    }
}
