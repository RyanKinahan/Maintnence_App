public class maintnence {

    int vehicle_id;

    String date;

    String desc;

    int odo;

    Float price;


    public maintnence(int vid, String dte, String dsc, int od, Float prce){
        vehicle_id = vid;
        date = dte;
        desc = dsc;
        odo = od;
        price = prce;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public String getDate() {
        return date;
    }

    public String getDesc() {
        return desc;
    }

    public int getOdo() {
        return odo;
    }

    public Float getPrice() {
        return price;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setOdo(int odo) {
        this.odo = odo;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
    public String toString(){
        return date + " " + desc + " " + odo + " $" + price;
    }
}