package com.eventostac.api.repository;

import com.eventostac.api.domain.address.Address;
import com.eventostac.api.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
