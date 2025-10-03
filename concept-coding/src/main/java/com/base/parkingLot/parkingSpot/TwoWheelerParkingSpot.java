package com.base.parkingLot.parkingSpot;

import com.base.parkingLot.vehicle.Vehicle;
import com.base.parkingLot.vehicle.VehicleType;

public class TwoWheelerParkingSpot extends ParkingSpot {

    int price = 20;

    public TwoWheelerParkingSpot(Vehicle vehicle, VehicleType vehicleType) {
        super(vehicle, vehicleType);
    }
}
