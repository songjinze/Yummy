package com.yummy.dao;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.pojo.Member;

public interface MemberDao {

    /**
     * 插入会员
     * @param member 会员bean
     * @return memberId，若插入失败返回-1
     */
    int insertMember(Member member);

    /**
     * 更新会员信息
     * @param member 会员bean
     * @return true 更新成功 false 更新失败
     */
    boolean updateMember(Member member);

    /**
     * 删除会员
     * @param email 会员email
     * @return true 删除成功 false 删除失败
     */
    boolean deleteMember(String email);

    /**
     * 根据会员email查找会员信息
     * @param email 会员email
     * @return Member 如果查找失败则返回null
     */
    Member getMemberByEmail(String email);
}
