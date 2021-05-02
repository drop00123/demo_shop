package com.qian.service.impl;

import com.qian.dao.AddressDao;
import com.qian.dao.impl.AddressDaoImpl;
import com.qian.pojo.Address;
import com.qian.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao;
    public AddressServiceImpl() {
        addressDao=new AddressDaoImpl();
    }

    @Override
    public List<Address> findAddressByUid(int uid) {
        List<Address> addresses = addressDao.selectAddressByUid(uid);
        return addresses;
    }

    @Override
    public void addAddress(Address address) {
        addressDao.updateAddress(address);
    }

    @Override
    public void setAddressDefault(String aid, int uid) {
        addressDao.updateAddressDefault(aid);
        addressDao.updateAddressNotDefault(aid,uid);
    }

    @Override
    public void deleteAddress(String aid) {
        addressDao.updateAddressByAid(aid);
    }

    @Override
    public void updateAddress(Address address) {
        addressDao.updateAddressByAddress(address);
    }
}
