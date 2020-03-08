import java.sql.Time;

public class ticket {


    private int checkInTime;

    private int checkOutTime;

    private int total;

    private int TimeInGarage;

    private static int id;


    private int randomTimeIn = (int) ((int) 7 + (Math.random() * (12 - 7)));
    private int randomTimeOut = (int) ((int) 1 + (Math.random() * (11 - 1)));

    public ticket() {
        setCheckInTime(randomTimeIn);
        setCheckOutTime(randomTimeOut);
        id++;
    }


    public void setCheckInTime(int randomTimeIn) {

        this.checkInTime = randomTimeIn;
    }


    public void setCheckOutTime(int randomTimeOut) {

        this.checkOutTime = randomTimeOut;
    }


    public int getTotal() {

        if (getTimeInGarage() != 0 && getTimeInGarage() <= 3) {
            total = 5;
        } else if (getTimeInGarage() > 3 && getTimeInGarage() <= 12) {
            total = (5 + (getTimeInGarage()) - 3);
        } else if (getTimeInGarage() >= 13) {
            total = 15;
        } else if (TimeInGarage ==0){
            total =25;
        }

        return total;
    }

    public int getTimeInGarage() {
        TimeInGarage = (getCheckOutTime() + 12) - getCheckInTime();
        return TimeInGarage;
    }

    public void setTimeInGarage(int timeInGarage) {
        TimeInGarage = timeInGarage;
    }



    public int getCheckInTime() {

        return checkInTime;
    }

    public int getCheckOutTime() {

        return checkOutTime;
    }


    public String toStringTimePeriod() {
        return "This Ticket " +
                "Check In Time " + checkInTime + ":00 " +
                "Check Out Time " + checkOutTime + ":00 "
                ;
    }

    public String toStringTotal() {

        return "Total " +
                "$ " + getTotal();
    }

    public String toStringPeriod() {

        return "Total hours in Garage " +
                getTimeInGarage() + " hours";
    }

    public String toStringID (){
        return "ID:"+id;
    }

}
