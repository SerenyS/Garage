public class ticket {


    private int checkInTime;

    private int checkOutTime;

    private int total;

    private static int id;

    private int randomTimeIn = (int) ((int) 7 + (Math.random() * (12 - 7)));
    private int randomTimeOut = (int) ((int) 1 + (Math.random() * (11 - 1)));

    public ticket() {
        setCheckInTime(randomTimeIn);
        setCheckOutTime(randomTimeOut);
        id++;
    }

    public int getId() {
        return id;
    }


    public void setCheckInTime(int randomTimeIn) {

        this.checkInTime = randomTimeIn;
    }

    public void setCheckOutTime(int randomTimeOut) {

        this.checkOutTime = randomTimeOut;
    }


    public int getCheckInTime() {

        return checkInTime;
    }

    public int getCheckOutTime() {

        return checkOutTime;
    }


    public int getTimeInGarage() {
        int timePeriod = (getCheckOutTime() + 12) - getCheckInTime();
        return timePeriod;
    }

    public int getTotal() {
        this.total = (5 + (getTimeInGarage()));
        if (total < 15) {
            return total;
        } else {
            total = 15;
            return total;
        }
    }

    public int setTotal(int total) {
        int lost = 25;
        this.total = lost;
        return lost;
    }

    public String toStringId() {
        return "Ticket Number : " + getId();

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
}
