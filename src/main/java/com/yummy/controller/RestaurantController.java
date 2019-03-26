package com.yummy.controller;
/*
 * author: SJZ
 * date: 2019/3/18
 */

import com.yummy.module.DiscountModule;
import com.yummy.module.ProductModule;
import com.yummy.module.RestaurantModule;
import com.yummy.module.responsemodule.DiscountResponseModule;
import com.yummy.module.responsemodule.Response;
import com.yummy.module.responsemodule.restaurantResponse.*;
import com.yummy.service.RestaurantService.RestaurantInfoService;
import com.yummy.service.RestaurantService.RestaurantLoginService;
import com.yummy.service.RestaurantService.RestaurantOrderService;
import com.yummy.service.RestaurantService.RestaurantProductService;
import com.yummy.util.message.servicemessage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class RestaurantController {

    private final RestaurantLoginService restaurantLoginService;
    private final RestaurantProductService restaurantProductService;
    private final RestaurantInfoService restaurantInfoService;
    private final RestaurantOrderService restaurantOrderService;
    @Autowired
    public RestaurantController(RestaurantLoginService restaurantLoginService,
                                RestaurantProductService restaurantProductService,
                                RestaurantInfoService restaurantInfoService,
                                RestaurantOrderService restaurantOrderService) {
        this.restaurantLoginService = restaurantLoginService;
        this.restaurantProductService=restaurantProductService;
        this.restaurantInfoService=restaurantInfoService;
        this.restaurantOrderService=restaurantOrderService;
    }

    private final String USERNAME="username";
    private final String ID="restaurantIdCode";
    private final String RESTAURANT_ADDRESS="restaurantAddress";
    private final String RESTAURANT_TYPE="restaurantType";
    private final String RESTAURANT_NAME="restaurantName";
    private final String RESTAURANT_EMAIL="email";

    @PostMapping("/restaurant-login")
    @ResponseBody
    public RestaurantLoginResponseModule restaurantLogin(@RequestBody Map map){
        String restaurantIdCode=(String) map.get(USERNAME);
        RestaurantLoginResponseModule restaurantLoginResponseModule=new RestaurantLoginResponseModule();
        LoginMessage loginMessage=restaurantLoginService.login(restaurantIdCode);
        if(loginMessage.equals(LoginMessage.SUCCESS)){
            restaurantLoginResponseModule.setResult("success");
        }else{
            restaurantLoginResponseModule.setResult("no-user");
        }
        return restaurantLoginResponseModule;
    }

    @PostMapping("/restaurant-signUp")
    @ResponseBody
    public RestaurantSignUpResponseModule restaurantSignUp(@RequestBody Map map){
        String restaurantAddress=(String)map.get(RESTAURANT_ADDRESS);
        String restaurantType=(String)map.get(RESTAURANT_TYPE);
        String restaurantName=(String)map.get(RESTAURANT_NAME);
        String restaurantEmail=(String)map.get(RESTAURANT_EMAIL);
        SignupMessage signupMessage=restaurantLoginService.signUp(restaurantEmail,restaurantAddress,restaurantType,restaurantName);
        RestaurantSignUpResponseModule restaurantSignUpResponseModule=new RestaurantSignUpResponseModule();
        if(signupMessage.equals(SignupMessage.SIGNUP_SUCCESS)){
            restaurantSignUpResponseModule.setResult("success");
        }else if(signupMessage.equals(SignupMessage.DUPLICATED_USER)){
            restaurantSignUpResponseModule.setResult("duplicated-user");
        }else{
            restaurantSignUpResponseModule.setResult("fail");
        }
        return restaurantSignUpResponseModule;
    }

    @PostMapping("/restaurant-saveRestaurantInfo")
    @ResponseBody
    public RestaurantSaveInfoModule restaurantSaveInfo(@RequestBody Map map){
        String restaurantIdCode=(String)map.get(ID);
        String restaurantAddress=(String)map.get(RESTAURANT_ADDRESS);
        String restaurantType=(String)map.get(RESTAURANT_TYPE);
        String restaurantName=(String) map.get("restaurantName");
        RestaurantModule restaurantModule=new RestaurantModule();
        restaurantModule.setIdCode(restaurantIdCode);
        restaurantModule.setAddress(restaurantAddress);
        restaurantModule.setType(restaurantType);
        restaurantModule.setName(restaurantName);
        ModifyMessage modifyMessage=restaurantInfoService.modifyRestaurantMessage(restaurantModule);
        RestaurantSaveInfoModule restaurantSaveInfoModule=new RestaurantSaveInfoModule();
        if(modifyMessage.equals(ModifyMessage.MODIFY_SUCCESS)){
            restaurantSaveInfoModule.setResult("success");
        }else{
            restaurantSaveInfoModule.setResult("fail");
        }
        return restaurantSaveInfoModule;
    }

    @PostMapping("/restaurant-createProduct")
    @ResponseBody
    public Response createProduct(@RequestBody Map map){
        String restaurantIdCode=(String)map.get(ID);
        String productName=(String) map.get("productName");
        Integer productNum=((int) map.get("productNum"));
        Double productPrice=Double.parseDouble((String) map.get("productPrice"));
        String limitTime=(String) map.get("date");
        String productDescription=(String)map.get("productDescription");
        ProductModule productModule=new ProductModule(
                productName,
                limitTime,
                productPrice,
                productNum,
                productDescription,
                restaurantIdCode);
        ProductUpdateMessage productUpdateMessage=restaurantProductService.createProduct(productModule);
        Response response=new Response();
        if(productUpdateMessage.equals(ProductUpdateMessage.UPDATE_SUCCESS)){
            response.setResult("success");
        }else{
            response.setResult("fail");
        }
        return response;
    }

    @PostMapping("/restaurant-createDiscount")
    @ResponseBody
    public Response createDiscount(@RequestBody Map map){
        String restaurantIdCode=(String) map.get(ID);
        String date=(String) map.get("date");
        int discount=((Double)map.get("discount")).intValue();
        Response response=new Response();
        DiscountModule discountModule=new DiscountModule(restaurantIdCode,date,discount);
        ProductUpdateMessage productUpdateMessage=restaurantProductService.createDiscount(discountModule);
        if(productUpdateMessage.equals(ProductUpdateMessage.UPDATE_SUCCESS)){
            response.setResult("success");
        }else{
            response.setResult("fail");
        }
        return response;
    }

    @PostMapping("/restaurant-getDiscount")
    @ResponseBody
    public DiscountResponseModule getDiscount(@RequestBody Map map){
        String restaurantIdCode=(String)map.get(ID);
        DiscountModule discountModule=restaurantProductService.getDiscount(restaurantIdCode);
        if(discountModule==null){
            return null;
        }
        return new DiscountResponseModule(discountModule.getLimitTime(),discountModule.getDiscount());
    }

    @PostMapping("/restaurant-getRunningOrders")
    @ResponseBody
    public List<RestaurantOrderModule> getRestaurantOrders(@RequestBody Map map){
        String restaurantIdCode=(String)map.get(ID);
        return restaurantOrderService.getRestaurantOrders(restaurantIdCode);
    }

    @PostMapping("/restaurant-getFinishedOrders")
    @ResponseBody
    public List<RestaurantFinishedOrderModule> getRestaurantFinishedOrders(@RequestBody Map map){
        String restaurantIdCode=(String)map.get(ID);
        return restaurantOrderService.getRestaurantFinishedOrders(restaurantIdCode);
    }

    @PostMapping("/restaurant-cancelOrder")
    @ResponseBody
    public Response cancelOrder(@RequestBody Map map){
        int orderId=(int)map.get("orderId");
        Response response=new Response();
        DeleteMessage deleteMessage=restaurantOrderService.cancelOrder(orderId);
        if(deleteMessage.equals(DeleteMessage.SUCCESS)){
            response.setResult("success");
        }else{
            response.setResult("fail");
        }
        return response;
    }

    @PostMapping("/restaurant-finishOrder")
    @ResponseBody
    public Response finishOrder(@RequestBody Map map){
        int orderId=(int)map.get("orderId");
        Response response=new Response();
        ModifyMessage modifyMessage=restaurantOrderService.finishOrder(orderId);
        if(modifyMessage.equals(ModifyMessage.MODIFY_SUCCESS)){
            response.setResult("success");
        }else{
            response.setResult("fail");
        }
        return response;
    }

    @PostMapping("/restaurant-productList")
    @ResponseBody
    public List<ProductModule> getProductList(@RequestBody Map map){
        String restaurantIdCode=(String)map.get(ID);
        return restaurantProductService.getProductList(restaurantIdCode);
    }

    @PostMapping("/restaurant-deleteProduct")
    @ResponseBody
    public Response deleteProduct(@RequestBody Map map){
        int productId=(int)map.get("productId");
        String productDate=(String)map.get("productDate");
        int leftNum=(int)map.get("leftNum");
        String productName=(String)map.get("productName");
        String productDescription=(String)map.get("productDescription");
        ProductModule productModule=new ProductModule();
        productModule.setName(productName);
        productModule.setLimitTime(productDate);
        productModule.setDescrip(productDescription);
        productModule.setLeftNum(leftNum);
        productModule.setId(productId);
        ProductUpdateMessage updateMessage=restaurantProductService.deleteProduct(productModule);
        Response response=new Response();
        if(updateMessage.equals(ProductUpdateMessage.UPDATE_SUCCESS)){
            response.setResult("success");
        }else{
            response.setResult("fail");
        }
        return response;

    }
}

