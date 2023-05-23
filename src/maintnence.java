public class maintence {

    int vehicle_id;

    String date;

    String desc;

    int odo;

    int price;


    public maintence(int vid, String dte, String dsc, int od, int prce){
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

    public int getPrice() {
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

    public void setPrice(int price) {
        this.price = price;
    }
    
}