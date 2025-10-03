package com.base.parkingLot.parkingStrategy;

import com.base.parkingLot.manager.ParkingSpotManager;
import com.base.parkingLot.parkingSpot.ParkingSpot;
import com.base.parkingLot.vehicle.Vehicle;

public class NearToEntryParkingStrategy implements ParkingStrategy{

    private ParkingSpotManager parkingSpotManager;

    public NearToEntryParkingStrategy(ParkingSpotManager parkingSpotManager){
        this.parkingSpotManager = parkingSpotManager;
    }

    @Override
    public ParkingSpot findParkingSpot(ParkingSpotManager parkingSpotManager, Vehicle vehicle) {
        ParkingSpot parkingSpot= parkingSpotManager.getParkingSpots().stream().
                filter(parkingSpotTemp -> parkingSpotTemp.isEmpty).
                findFirst().get();
        parkingSpot.parkVehicle(vehicle);
        return parkingSpot;

    }
}
