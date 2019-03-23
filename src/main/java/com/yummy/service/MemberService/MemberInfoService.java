package com.yummy.service.MemberService;
/*
 * author: SJZ
 * date: 2019/2/17
 */

import com.yummy.entity.Member;
import com.yummy.module.MemberModule;
import com.yummy.util.message.servicemessage.ModifyMessage;
import org.springframework.stereotype.Service;

@Service
public interface MemberInfoService {

    /**
     * 通过邮箱获得用户所有信息
     * @param email 邮箱（完整）
     * @return 用户信息（如果用户存在）
     * 用户不存在则返回null
     */
    Member getMemberInfo(String email);

    /**
     * 修改会员信息，不包括会员level，会员email不能修改
     * @param memberModule 会员module
     * @return 修改成功、修改失败
     */
    ModifyMessage modifyMemberInfo(MemberModule memberModule);

    /**
     * 删除会员
     * @param email 邮箱（完整）
     * @return ModifyMessage
     */
    ModifyMessage deleteMember(String email);
}
