package com.eventostac.api.service;
import com.eventostac.api.domain.coupon.Coupon;
import com.eventostac.api.domain.coupon.CouponRequestDTO;
import com.eventostac.api.domain.event.Event;
import com.eventostac.api.repository.CouponRepository;
import com.eventostac.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CouponService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CouponRepository couponRepository;

    public Coupon addCouponToEvent(UUID eventId, CouponRequestDTO couponRequestDTO){
        Event event = eventRepository.findById(eventId)
                .orElseThrow(()-> new IllegalArgumentException("Evento não encontrado"));

        Coupon coupon = new Coupon();
        coupon.setCode(couponRequestDTO.code());
        coupon.setDiscount(couponRequestDTO.discount());
        coupon.setValid(new Date(couponRequestDTO.valid()));
        coupon.setEvent(event);

        return couponRepository.save(coupon);
    }

    public List<Coupon> consultCoupons(UUID eventId, Date currentDate){
        return couponRepository.findByEventIdAndValidAfter(eventId, currentDate);
    }
}
