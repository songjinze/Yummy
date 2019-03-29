package com.yummy.service.restaurantservice;
/*
 * author: SJZ
 * date: 2019/2/25
 */

import com.yummy.module.DiscountModule;
import com.yummy.module.ProductModule;
import com.yummy.util.message.servicemessage.ProductUpdateMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantProductService {
    /**
     * 发布一个单品信息
     * @param productModule 单品
     * @return 成功、失败
     */
    ProductUpdateMessage createProduct(ProductModule productModule);

    /**
     * 删除一个单品信息
     * @param productModule 单品
     * @return 成功、失败
     */
    ProductUpdateMessage deleteProduct(ProductModule productModule);

    /**
     * 创建一个折扣
     * @param discountModule 折扣
     * @return 成功、失败
     */
    ProductUpdateMessage createDiscount(DiscountModule discountModule);

    /**
     * 更新一个折扣
     * @param discountModule
     * @return
     */
    ProductUpdateMessage modifyDiscount(DiscountModule discountModule);

    /**
     * 获得餐厅当前折扣
     * @param restaurantIdCode
     * @return
     */
    DiscountModule getDiscount(String restaurantIdCode);

    /**
     * 获得餐厅所有商品列表（包括套餐，不包括折扣）
     * @param restaurantIdCode
     * @return
     */
    List<ProductModule> getProductList(String restaurantIdCode);
}
