package com.yummy.service.MemberService;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.pojo.Member;
import com.yummy.util.message.ModifyMessage;
import org.springframework.stereotype.Service;

@Service
public class MemberInfoServiceImpl implements MemberInfoService {

    @Override
    public Member getMemberInfo(String email) {
        return null;
    }

    @Override
    public ModifyMessage modifyMemberInfo(Member member) {
        return null;
    }

    @Override
    public ModifyMessage deleteMember(String email) {
        return null;
    }
}
