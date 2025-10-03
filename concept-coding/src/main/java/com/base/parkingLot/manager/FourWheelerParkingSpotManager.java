package com.base.parkingLot.manager;

import com.base.parkingLot.parkingSpot.ParkingSpot;
import com.base.parkingLot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class FourWheelerParkingSpotManager implements ParkingSpotManager {

    private List<ParkingSpot> parkingSpots;

    public FourWheelerParkingSpotManager(List<ParkingSpot> parkingSpots) {
        this.parkingSpots=parkingSpots;
    }

    public FourWheelerParkingSpotManager(){
        parkingSpots=new ArrayList<>();
    }

    @Override
    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
    }

    @Override
    public void removeParkingSpot(ParkingSpot parkingSpot) {
        parkingSpots.remove(parkingSpot);
    }

    @Override
    public ParkingSpot assignVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.isEmpty){
                parkingSpot.parkVehicle(vehicle);
                return parkingSpot;
            }
        }
        return null;
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot: parkingSpots){
            if(!parkingSpot.isEmpty){
                parkingSpot.removeVehicle(vehicle);
            }
        }
    }

    @Override
    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
