package parkinglotapp;

public class LongTermParkingLot implements IParkingLot{
    @Override
    public double calculatePrice(ITicket ticket) {
        int[] duration = ticket.calculateDuration();

        if( duration[1] > 7){
            return 10 + duration[0]*10;
        } else if (duration[1] == 7 && duration[2] > 0) {
            return 10 + duration[0]*10;
        } else if (duration[1] == 0 && duration[2] <= 30) {
            return  duration[0]*10;
        } else if (duration[2] > 0) {
            return 3 * (duration[1] + 1) +  duration[0]*10;
        } else {
            return 3 * duration[1] + duration[0]*10;
        }
    }

}
