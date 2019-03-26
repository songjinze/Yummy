package com.yummy.service.impl;

import com.yummy.dao.RestaurantDao;
import com.yummy.dao.SignUpToCheckDao;
import com.yummy.entity.Restaurant;
import com.yummy.entity.SignUpToCheck;
import com.yummy.module.SignUpToCheckModule;
import com.yummy.service.ManagerService.ManagerCheckService;
import com.yummy.util.EmailSender;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import com.yummy.util.message.servicemessage.ModifyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerCheckServiceImpl implements ManagerCheckService {

    private final SignUpToCheckDao signUpToCheckDao;
    private final RestaurantDao restaurantDao;
    private final EmailSender emailSender;

    @Autowired
    public ManagerCheckServiceImpl(SignUpToCheckDao signUpToCheckDao, RestaurantDao restaurantDao, EmailSender emailSender) {
        this.signUpToCheckDao = signUpToCheckDao;
        this.restaurantDao = restaurantDao;
        this.emailSender = emailSender;
    }

    @Override
    public List<SignUpToCheckModule> getSignUpToCheckList() {
        List<SignUpToCheck> signUpToChecks=signUpToCheckDao.getByQuery("from SignUpToCheck");
        List<SignUpToCheckModule> signUpToCheckModules=new ArrayList<>();
        for(SignUpToCheck signUpToCheck:signUpToChecks){
            signUpToCheckModules.add(new SignUpToCheckModule(
                    signUpToCheck.getId(),
                    signUpToCheck.getEmail(),
                    signUpToCheck.getAddress(),
                    signUpToCheck.getName(),
                    signUpToCheck.getType()
            ));
        }
        return signUpToCheckModules;
    }

    private synchronized String createRestaurantIdCode(int id){
        StringBuilder stringBuilder=new StringBuilder();
        int count=0,temp=id;
        for(;count<7;count++){
            if(temp!=0){
                stringBuilder.append((char)(temp%26+'A'));
                temp=temp/26;
            }else{
                stringBuilder.append('A');
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public synchronized ModifyMessage checkSignUp(SignUpToCheckModule signUpToCheckModule) {
        int id=signUpToCheckModule.getId();
        SignUpToCheck signUpToCheck=signUpToCheckDao.get(id);
        if(signUpToCheck==null){
            return ModifyMessage.MODIFY_FAIL;
        }
        Restaurant restaurant=new Restaurant();
        String restaurantIdCode=createRestaurantIdCode(id);
        emailSender.sendEmail(signUpToCheck.getEmail(),
                "您的餐厅："+signUpToCheck.getName()+
                "  地址："+signUpToCheck.getAddress()+
                "  对应标识码为："+restaurantIdCode);
        restaurant.setIdCode(restaurantIdCode);
        restaurant.setAddress(signUpToCheck.getAddress());
        restaurant.setName(signUpToCheck.getName());
        restaurant.setType(signUpToCheck.getType());
        UpdateDataMessage updateDataMessage=restaurantDao.save(restaurant);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            signUpToCheckDao.delete(signUpToCheck);
            return ModifyMessage.MODIFY_SUCCESS;
        }else{
            return ModifyMessage.MODIFY_FAIL;
        }
    }
}
