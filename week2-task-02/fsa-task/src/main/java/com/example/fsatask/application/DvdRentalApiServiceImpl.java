package com.example.fsatask.application;

import com.example.fsatask.api.AddressDto;
import com.example.fsatask.application.assembler.AddressAssembler;
import com.example.fsatask.application.repository.AddressJpaRepository;
import com.example.fsatask.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Component
public class DvdRentalApiServiceImpl implements DvdRentalApiService{
    @Autowired
    private AddressJpaRepository addressJpaRepository;

    private AddressAssembler addressAssembler = new AddressAssembler();

    @Override
    public AddressDto getAddressById(Long id) {
        Optional<Address> actor = addressJpaRepository.findById(id);
        return actor.map(addressAssembler::toDto)
                .orElseThrow();
    }

    @Override
    public Collection<AddressDto> findAddressesByPostalCode (String postalCode) {
        if (postalCode == null || postalCode.isBlank()) {
            return addressAssembler.toDto(addressJpaRepository.findAll());
        } else {
            return addressAssembler.toDto(addressJpaRepository.findAllByPostalCode(postalCode));
        }
    }

    @Override
    public long createNewAddress(AddressDto dto) {
        dto.lastUptade= new Date();
        Address newActor = addressJpaRepository.save(addressAssembler.fromDto(dto));
        return newActor.getAddressId();
    }

    @Override
    public void replaceAddress(AddressDto newAddress, Long id) {
        Optional<Address> actorResult = addressJpaRepository.findById(id);

        Address address;
        if (actorResult.isPresent()) {
            address = actorResult.get();
            address.setAddress(newAddress.address);
            address.setAddress2(newAddress.address2);
            address.setLastUptade(new Date());
        } else {
            newAddress.addressId = id;
            address = addressAssembler.fromDto(newAddress);
        }

        addressJpaRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressJpaRepository.deleteById(id);
    }
}
