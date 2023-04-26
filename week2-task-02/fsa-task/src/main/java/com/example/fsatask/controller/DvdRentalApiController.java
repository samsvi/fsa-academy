package com.example.fsatask.controller;

import com.example.fsatask.api.AddressDto;
import com.example.fsatask.api.DvdRentalApi;
import com.example.fsatask.application.DvdRentalApiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class DvdRentalApiController implements DvdRentalApi {

    @Autowired
    private DvdRentalApiService dvdRentalApiService;


    @Override
    public AddressDto getAddress(Long id) {
        return dvdRentalApiService.getAddressById(id);
    }

    @Override
    public Collection<AddressDto> all(String postalCode) {
        return dvdRentalApiService.findAddressesByPostalCode(postalCode);
    }

    @Override
    public long newAddress(AddressDto newAddress) {
        return dvdRentalApiService.createNewAddress(newAddress);
    }

    @Override
    public void updateAddress(AddressDto newAddress, Long id) {
        dvdRentalApiService.replaceAddress(newAddress, id);
    }

    @Override
    public void deleteAddress(Long id) {
        dvdRentalApiService.deleteAddress(id);
    }
}
