package com.yummy.service.RestaurantService;
/*
 * author: SJZ
 * date: 2019/2/25
 */

import com.yummy.entity.Product;
import com.yummy.module.ProductModule;
import com.yummy.util.message.servicemessage.ProductUpdateMessage;

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

}
