package com.eventostac.api.domain.address;

import com.eventostac.api.domain.event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "address")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private UUID id;

    private String uf;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String city;


}
