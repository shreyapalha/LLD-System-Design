package com.base.parkingLot.gates;

import com.base.parkingLot.manager.ParkingSpotManager;
import com.base.parkingLot.parkingSpot.ParkingSpot;
import com.base.parkingLot.parkingStrategy.ParkingStrategy;
import com.base.parkingLot.ticket.Ticket;
import com.base.parkingLot.vehicle.Vehicle;

public class EntryGate {

    private ParkingSpotManager parkingSpotManager;

    private Vehicle vehicle;

    private ParkingStrategy parkingStrategy;

    public EntryGate(ParkingSpotManager parkingSpotManager,Vehicle vehicle,ParkingStrategy parkingStrategy){
        this.parkingSpotManager=parkingSpotManager;
        this.vehicle=vehicle;
        this.parkingStrategy=parkingStrategy;
    }

    public ParkingSpot findParkingSpot(){
        return parkingStrategy.findParkingSpot(parkingSpotManager,vehicle);
    }

    public Ticket assignTicket(){
        ParkingSpot parkingSpot=findParkingSpot();
        parkingSpotManager.assignVehicle(vehicle);
        return new Ticket(parkingSpot);
    }
}
