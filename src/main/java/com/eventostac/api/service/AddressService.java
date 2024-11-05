package com.eventostac.api.service;
import com.eventostac.api.domain.address.Address;
import com.eventostac.api.domain.event.Event;
import com.eventostac.api.domain.event.EventRequestDTO;
import com.eventostac.api.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;


    public Address createAddress(EventRequestDTO eventRequestDTO, Event event){
        Address address = new Address();
        address.setEvent(event);
        address.setUf(eventRequestDTO.state());
        address.setCity(eventRequestDTO.city());

        return addressRepository.save(address);
    }
}
