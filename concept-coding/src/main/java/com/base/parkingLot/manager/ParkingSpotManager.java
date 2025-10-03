package com.base.parkingLot.manager;

import com.base.parkingLot.parkingSpot.ParkingSpot;
import com.base.parkingLot.vehicle.Vehicle;

import java.util.List;

public interface ParkingSpotManager {

     void addParkingSpot(ParkingSpot parkingSpot);

     void removeParkingSpot(ParkingSpot parkingSpot);

     ParkingSpot assignVehicle(Vehicle vehicle);

     void removeVehicle(Vehicle vehicle);

     List<ParkingSpot> getParkingSpots();


}
