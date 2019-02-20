package com.yummy.service.MemberService;
/*
 * author: SJZ
 * date: 2019/2/17
 */

import com.yummy.pojo.Member;
import com.yummy.util.message.ModifyMessage;

public interface MemberInfoService {

    /**
     * 通过邮箱获得用户所有信息
     * @param email 邮箱（完整）
     * @return 用户信息（如果用户存在）
     * 用户不存在则返回null
     */
    Member getMemberInfo(String email);

    /**
     * 修改会员信息
     * @param member 修改后的会员信息，主键不能修改
     * @return ModifyMessage
     */
    ModifyMessage modifyMemberInfo(Member member);

    /**
     * 删除会员
     * @param email 邮箱（完整）
     * @return ModifyMessage
     */
    ModifyMessage deleteMember(String email);
}
