package com.yummy.dao;

import com.yummy.entity.Member;

public interface MemberDao extends Dao<Member> {
    Member getMemberByEmail(String email);
}
