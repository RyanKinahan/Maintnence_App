public class vehicle {

    int vehicle_id;

    int year;

    String make;

    String model;

    String aq_date;

    String sell_date;


    public vehicle(int vid, int yr, String mke, String mdl, String adate, String sdate){
        vehicle_id = vid;
        year = yr;
        make = mke;
        model = mdl;
        aq_date = adate;
        sell_date = sdate;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getAq_date() {
        return aq_date;
    }

    public String getSell_date() {
        return sell_date;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public void year(int year) {
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAq_date(String aq_date) {
        this.aq_date = aq_date;
    }

    public void setSell_date(String sell_date) {
        this.sell_date = sell_date;
    }

    public String toString(){
        return vehicle_id + ": " + year + " " + make + " " + model + ", Aquired: " + aq_date + ", Sold:" + sell_date;
    }
    
}