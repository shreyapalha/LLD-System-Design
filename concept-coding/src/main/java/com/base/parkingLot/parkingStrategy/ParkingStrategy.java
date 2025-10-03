package com.base.parkingLot.parkingStrategy;

import com.base.parkingLot.manager.ParkingSpotManager;
import com.base.parkingLot.parkingSpot.ParkingSpot;
import com.base.parkingLot.vehicle.Vehicle;

public interface ParkingStrategy {

    public ParkingSpot findParkingSpot(ParkingSpotManager processSpotManager, Vehicle vehicle);
}
