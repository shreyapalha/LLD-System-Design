# Requirements
1. The parking lot should have multiple levels, each level with a certain number of parking spots.
2. The parking lot should support different types of vehicles, such as cars, motorcycles, and trucks.
3. Each parking spot should be able to accommodate a specific type of vehicle.
4. The system should assign a parking spot to a vehicle upon entry and release it when the vehicle exits.
5. The system should track the availability of parking spots and provide real-time information to customers.
6. The system should handle multiple entry and exit points and support concurrent access.


# Entities
1. vehicle
   1. type -> enum [2 wheeler, 3, 4]
   2. timeIn
   3. timeOut
2. parking_space
   3. type
   4. blocked
   5. level

   isParkingAvailable(VehicleType){}








# questions
1. types of vehicles allowed ?