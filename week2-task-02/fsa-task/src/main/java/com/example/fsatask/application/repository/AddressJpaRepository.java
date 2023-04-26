package com.example.fsatask.application.repository;

import com.example.fsatask.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressJpaRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByPostalCode(String postalCode);
}
