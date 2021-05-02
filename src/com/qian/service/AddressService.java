package com.qian.service;

import com.qian.pojo.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAddressByUid(int uid);

    void addAddress(Address address);

    void deleteAddress(String aid);

    void setAddressDefault(String aid, int uid);

    void updateAddress(Address address);
}
