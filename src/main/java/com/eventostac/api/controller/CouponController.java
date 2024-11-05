package com.eventostac.api.controller;

import com.eventostac.api.domain.coupon.Coupon;
import com.eventostac.api.domain.coupon.CouponRequestDTO;
import com.eventostac.api.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/{eventId}")
    public ResponseEntity<List<Coupon>> getListCoupons(@PathVariable UUID eventId, @RequestParam("currentDate") @DateTimeFormat(pattern = "dd/MM/yyyy") Date currentDate) {
        List<Coupon> coupon = this.couponService.consultCoupons(eventId, currentDate);
        return ResponseEntity.ok().body(coupon);
    }

    @PostMapping("/{eventId}")
    public ResponseEntity<Coupon> addCouponToEvent(@PathVariable UUID eventId, @RequestBody CouponRequestDTO data){
        Coupon coupon = couponService.addCouponToEvent(eventId, data);
        return ResponseEntity.ok().body(coupon);
    }
}
