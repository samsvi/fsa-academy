package com.example.fsatask.api;

import com.example.fsatask.domain.Address;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/v1")
public interface DvdRentalApi {

    @GetMapping("/address/{id}")
    AddressDto getAddress(@PathVariable Long id);

    @GetMapping("/actors/all")
    Collection<AddressDto> all(@RequestParam(name = "postalCode", required = false) String postalCode);

    @PostMapping("/address")
    long newAddress(@RequestBody AddressDto newAddress);

    @PutMapping("/address/update/{id}")
    void updateAddress(@RequestBody AddressDto newAddress, @PathVariable Long id);

    @DeleteMapping("/address/delete/{id}")
    void deleteAddress(@PathVariable Long id);
}
