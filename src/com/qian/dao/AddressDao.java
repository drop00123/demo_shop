package com.qian.dao;

import com.qian.pojo.Address;

import java.util.List;

public interface AddressDao {
    List<Address> selectAddressByUid(int uid);

    void updateAddress(Address address);

    void updateAddressByAid(String aid);

    void updateAddressDefault(String aid);

    void updateAddressNotDefault(String aid, int uid);

    void updateAddressByAddress(Address address);
}

