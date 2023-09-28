package parkinglotapp;

public class ParkingLot implements IParkingLot {

    public static final int MAX_DAILY_CHARGE = 15;
    public static final int HOURLY_CHARGE = 2;

    @Override
    public double calculatePrice(ITicket ticket) throws TimeTravellerException {
        int[] duration = ticket.calculateDuration();
        double price;


        if(duration[1] > 7){
            price = MAX_DAILY_CHARGE + duration[0]*MAX_DAILY_CHARGE;
        } else if (duration[1] == 7 && duration[2] > 0) {
            price = MAX_DAILY_CHARGE + duration[0]*MAX_DAILY_CHARGE;
        } else if (duration[1] == 0 && duration[2] <= 30) {
            price = duration[0]*MAX_DAILY_CHARGE;
        } else if (duration[2] > 0) {
            price = HOURLY_CHARGE * (duration[1] + 1) +  duration[0]*MAX_DAILY_CHARGE;
        } else {
            price = HOURLY_CHARGE * duration[1] + duration[0]*MAX_DAILY_CHARGE;
        }
        if (price<0){
            throw new TimeTravellerException("You can't travel back in time");
        }
        return price;
    }
}
