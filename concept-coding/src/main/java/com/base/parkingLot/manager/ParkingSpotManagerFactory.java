package com.base.parkingLot.manager;

import com.base.parkingLot.vehicle.VehicleType;

public class ParkingSpotManagerFactory {

    public static ParkingSpotManager getParkingSpotManager(VehicleType vehicleType){
        if(vehicleType.equals(VehicleType.TWO_WHEELER)){
            return new TwoWheelerParkingSlotManager();
        }else if(vehicleType.equals(VehicleType.FOUR_WHEELER)){
            return new FourWheelerParkingSpotManager();
        }else{
            return null;
        }
    }
}
