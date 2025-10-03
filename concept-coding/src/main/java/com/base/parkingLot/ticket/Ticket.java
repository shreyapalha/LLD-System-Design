package com.base.parkingLot.ticket;

import com.base.parkingLot.parkingSpot.ParkingSpot;

import java.time.LocalDate;
import java.util.random.RandomGenerator;

public class Ticket {

    private int id;
    private LocalDate localDate;
    private ParkingSpot parkingSpot;

    public Ticket(ParkingSpot parkingSpot){
        id= RandomGenerator.getDefault().nextInt();
        localDate= LocalDate.now();
        this.parkingSpot=parkingSpot;
    }
}
