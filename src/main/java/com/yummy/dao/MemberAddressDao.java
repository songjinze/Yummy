package com.yummy.dao;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import com.yummy.entity.MemberAddress;
import com.yummy.util.message.datamessage.UpdateDataMessage;

import java.util.List;

public interface MemberAddressDao {

    int insertMemberAddress(MemberAddress memberAddress);
    UpdateDataMessage updateMemberAddress(MemberAddress memberAddress);
    UpdateDataMessage deleteMemberAddress(MemberAddress memberAddress);
    List<MemberAddress> getMemberAddressByMid(int mid);

}
