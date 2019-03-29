package com.yummy.service.impl;

import com.yummy.dao.MemberDao;
import com.yummy.entity.Member;
import com.yummy.module.MemberModule;
import com.yummy.service.memberservice.MemberInfoService;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import com.yummy.util.message.servicemessage.ModifyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MemberInfoServiceImpl implements MemberInfoService {

    private final MemberDao memberDao;

    @Autowired
    public MemberInfoServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public MemberModule getMemberInfo(String email) {
        Member member=memberDao.getMemberByEmail(email);
        return new MemberModule(member.getId(),
                member.getEmail(),
                member.getPassword(),
                member.getName(),
                member.getPhone());
    }

    @Override
    public ModifyMessage modifyMemberInfo(MemberModule memberModule) {
        String email=memberModule.getEmail();
        Member member=memberDao.getMemberByEmail(email);
        member.setPassword(memberModule.getPassword());
        member.setName(memberModule.getName());
        member.setPhone(memberModule.getPhone());
        UpdateDataMessage updateDataMessage=memberDao.update(member);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return ModifyMessage.MODIFY_SUCCESS;
        }else{
            return ModifyMessage.MODIFY_FAIL;
        }
    }

    @Override
    public ModifyMessage deleteMember(String email) {
        Member member=memberDao.getMemberByEmail(email);
        UpdateDataMessage updateDataMessage=memberDao.delete(member);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return ModifyMessage.MODIFY_SUCCESS;
        }else{
            return ModifyMessage.MODIFY_FAIL;
        }
    }
}
