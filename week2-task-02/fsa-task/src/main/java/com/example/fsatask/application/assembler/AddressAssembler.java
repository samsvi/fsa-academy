package com.example.fsatask.application.assembler;

import com.example.fsatask.api.AddressDto;
import com.example.fsatask.domain.Address;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class AddressAssembler {
    public Collection<AddressDto> toDto(Iterable<Address> addresses) {
        return StreamSupport.stream(addresses.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public AddressDto toDto(Address address) {
        AddressDto result = new AddressDto();

        result.addressId = address.getAddressId();
        result.address = address.getAddress();
        result.address2 = address.getAddress2();
        result.postalCode = address.getPostalCode();
        result.district = address.getDistrict();
        result.phone = address.getPhone();
        result.lastUptade = address.getLastUptade();

        return result;
    }

    public Address fromDto(AddressDto dto) {
        Address result = new Address();

        result.setAddressId(dto.addressId);
        result.setAddress(dto.address);
        result.setAddress2(dto.address2);
        result.setPhone(dto.phone);
        result.setPostalCode(dto.postalCode);
        result.setDistrict(dto.district);
        result.setLastUptade(dto.lastUptade);

        return result;
    }
}
