package com.base.parkingLot.parkingStrategy;

import com.base.parkingLot.manager.ParkingSpotManager;
import com.base.parkingLot.parkingSpot.ParkingSpot;
import com.base.parkingLot.vehicle.Vehicle;

public class DefaultParkingStrategy implements ParkingStrategy{

    private ParkingSpotManager parkingSpotManager;

    public DefaultParkingStrategy(ParkingSpotManager parkingSpotManager){
        this.parkingSpotManager = parkingSpotManager;
    }

    @Override
    public ParkingSpot findParkingSpot(ParkingSpotManager parkingSpotManager, Vehicle vehicle) {
        return parkingSpotManager.assignVehicle(vehicle);
    }
}
