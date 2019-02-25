package com.yummy.service.MemberService;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.dao.MemberDao;
import com.yummy.entity.Member;
import com.yummy.util.message.ModifyMessage;
import com.yummy.util.message.UpdateDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberInfoServiceImpl implements MemberInfoService {

    private final
    MemberDao memberDao;

    @Autowired
    public MemberInfoServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public Member getMemberInfo(String email) {
        return memberDao.getMemberByEmail(email);
    }

    @Override
    public ModifyMessage modifyMemberInfo(Member member) {
        UpdateDataMessage updateDataMessage=memberDao.updateMember(member);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return ModifyMessage.MODIFY_SUCCESS;
        }else{
            return ModifyMessage.MODIFY_FAIL;
        }
    }

    @Override
    public ModifyMessage deleteMember(String email) {
        UpdateDataMessage updateDataMessage=memberDao.deleteMember(email);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return ModifyMessage.MODIFY_SUCCESS;
        }else{
            return ModifyMessage.MODIFY_FAIL;
        }
    }
}
