package com.base.parkingLot.parkingSpot;

import com.base.parkingLot.vehicle.Vehicle;
import com.base.parkingLot.vehicle.VehicleType;

public class FourWheelerParkingSpot extends ParkingSpot {

    public FourWheelerParkingSpot(Vehicle vehicle, VehicleType vehicleType) {
        super(vehicle, vehicleType);
    }

    int price = 40;


}
