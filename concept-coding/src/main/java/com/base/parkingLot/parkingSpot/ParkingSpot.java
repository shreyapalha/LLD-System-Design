package com.base.parkingLot.parkingSpot;

import com.base.parkingLot.vehicle.Vehicle;
import com.base.parkingLot.vehicle.VehicleType;

public class ParkingSpot {

    private Vehicle vehicle;

    public VehicleType vehicleType;

    public boolean isEmpty;

    public ParkingSpot(Vehicle vehicle,VehicleType vehicleType){
        this.vehicle=vehicle;
        this.vehicleType=vehicleType;
        isEmpty=true;
    }

    public void parkVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
        isEmpty=false;
    }

    public void removeVehicle(Vehicle vehicle){
        if(this.vehicle.getId() == vehicle.getId()) {
            this.vehicle = null;
            isEmpty = true;
        }
        return;
    }
}
