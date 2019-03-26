package com.yummy.service.impl;

import com.yummy.dao.DiscountDao;
import com.yummy.dao.ProductDao;
import com.yummy.dao.RestaurantDao;
import com.yummy.entity.Discount;
import com.yummy.entity.Product;
import com.yummy.entity.Restaurant;
import com.yummy.module.DiscountModule;
import com.yummy.module.ProductModule;
import com.yummy.service.RestaurantService.RestaurantProductService;
import com.yummy.util.Date;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import com.yummy.util.message.servicemessage.ProductUpdateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RestaurantProductServiceImpl implements RestaurantProductService {
    private final RestaurantDao restaurantDao;
    private final ProductDao productDao;
    private final DiscountDao discountDao;
    private final Date date;

    @Autowired
    public RestaurantProductServiceImpl(DiscountDao discountDao, RestaurantDao restaurantDao, ProductDao productDao, Date date) {
        this.restaurantDao = restaurantDao;
        this.productDao = productDao;
        this.discountDao=discountDao;
        this.date = date;
    }

    @Override
    public ProductUpdateMessage createProduct(ProductModule productModule) {
        Product product=new Product();
        Restaurant restaurant=restaurantDao.getRestaurantByIdCode(productModule.getRestaurantIdCode());
        product.setRestaurant(restaurant);
        product.setName(productModule.getName());
        product.setLimitTime(productModule.getLimitTime());
        product.setPrice(productModule.getPrice());
        product.setLeftNum(productModule.getLeftNum());
        product.setDescrip(productModule.getDescrip());
        UpdateDataMessage updateDataMessage=productDao.save(product);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return ProductUpdateMessage.UPDATE_SUCCESS;
        }else{
            return ProductUpdateMessage.UPDATE_FAIL;
        }
    }

    @Override
    public ProductUpdateMessage deleteProduct(ProductModule productModule) {
        Product product=productDao.get(productModule.getId());
        if(product==null){
            return ProductUpdateMessage.UPDATE_FAIL;
        }
        UpdateDataMessage updateDataMessage=productDao.delete(product);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return ProductUpdateMessage.UPDATE_SUCCESS;
        }else{
            return ProductUpdateMessage.UPDATE_FAIL;
        }
    }

    @Override
    public ProductUpdateMessage createDiscount(DiscountModule discountModule) {
        return modifyDiscount(discountModule);
    }

    @Override
    public ProductUpdateMessage modifyDiscount(DiscountModule discountModule) {
        Discount discount=new Discount();
        discount.setLimitTime(discountModule.getLimitTime());
        discount.setDiscount(discountModule.getDiscount());
        Restaurant restaurant=restaurantDao.getRestaurantByIdCode(discountModule.getRestaurantIdCode());
        discount.setRestaurant(restaurant);
        UpdateDataMessage updateDataMessage=discountDao.update(discount);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return ProductUpdateMessage.UPDATE_SUCCESS;
        }else{
            return ProductUpdateMessage.UPDATE_FAIL;
        }
    }

    @Override
    public DiscountModule getDiscount(String restaurantIdCode) {
        Restaurant restaurant=restaurantDao.getRestaurantByIdCode(restaurantIdCode);
        if(restaurant==null){
            return null;
        }else{
            Discount discount=restaurant.getDiscount();
            return new DiscountModule(null,discount.getLimitTime(),discount.getDiscount());
        }
    }

    @Override
    public List<ProductModule> getProductList(String restaurantIdCode) {
        Restaurant restaurant=restaurantDao.getRestaurantByIdCode(restaurantIdCode);
        List<ProductModule> productModules=new ArrayList<>();
        String now=date.getDate();
        if(restaurant!=null){
            Set<Product> productSet=restaurant.getProductSet();
            for(Product product:productSet){
                if(date.compareTo(now,product.getLimitTime())==-1) {
                    productModules.add(new ProductModule(
                            product.getId(),
                            product.getName(),
                            product.getLimitTime(),
                            product.getPrice(),
                            product.getLeftNum(),
                            product.getDescrip(),
                            null
                    ));
                }
            }
        }
        return productModules;
    }
}
