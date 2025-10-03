package com.base.parkingLot.manager;

import com.base.parkingLot.parkingSpot.ParkingSpot;
import com.base.parkingLot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class TwoWheelerParkingSlotManager implements ParkingSpotManager {

    private List<ParkingSpot> parkingSpots;

    public TwoWheelerParkingSlotManager(List<ParkingSpot> parkingSpots) {
        this.parkingSpots=parkingSpots;
    }

    public TwoWheelerParkingSlotManager(){
        this.parkingSpots=new ArrayList<>();
    }

    @Override
    public void addParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.add(parkingSpot);
    }

    @Override
    public void removeParkingSpot(ParkingSpot parkingSpot) {

    }

    @Override
    public ParkingSpot assignVehicle(Vehicle vehicle) {
        return null;
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {

    }

    @Override
    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
