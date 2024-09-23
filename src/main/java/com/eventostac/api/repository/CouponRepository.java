package com.eventostac.api.repository;

import com.eventostac.api.domain.coupon.Coupon;
import com.eventostac.api.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CouponRepository extends JpaRepository<Coupon, UUID> {
}
