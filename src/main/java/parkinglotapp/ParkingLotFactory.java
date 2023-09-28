package parkinglotapp;

public class ParkingLotFactory {
    public IParkingLot createParkingLot(String parkingLotType){
        switch (parkingLotType){
            case "Long Term Parking"->{
                return new LongTermParkingLot();
            }
            case "Discounted Parking"->{
                return new DiscountParkingLot();
            }
            default -> {
                return new ParkingLot();
            }
        }
    }
}
