package com.example.fsatask.application;

import com.example.fsatask.api.AddressDto;

import java.util.Collection;

public interface DvdRentalApiService {
    AddressDto getAddressById(Long id);

    Collection<AddressDto> findAddressesByPostalCode(String postalCode);

    long createNewAddress(AddressDto newAddress);

    void replaceAddress(AddressDto newAddress, Long id);

    void deleteAddress(Long id);
}
