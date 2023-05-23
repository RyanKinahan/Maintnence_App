import java.io.*;
import java.util.*;

class app {

    public ArrayList<vehicle> vehicles = new ArrayList<vehicle>();

    public int readCSV(String filename){
        try{
            FileInputStream stream = new FileInputStream(filename);
            Scanner scan = new Scanner(stream);
            scan.useDelimiter("[,\r\n]+");

            while(scan.hasNext()){
                int vid = Integer.parseInt(scan.next());
                int vyr = Integer.parseInt(scan.next());
                String make = scan.next();
                String model = scan.next();
                String aq_date = scan.next();
                String sell_date = scan.next();

                vehicles.add(new vehicle(vid, vyr, make, model, aq_date, sell_date));
            }

            stream.close();
            scan.close();
        }
        catch(IOException e) {
            System.out.println("error reading vehicle file");
        }

        return 1;
    }


    public int writeToCSV(String filename, List csvHeader){
        
        //PrintWriter writer = new PrintWriter(new File (filename));
        //writer.close();
        return 1;


    }

    public static void main(String[] args) {
        app myApp = new app();
        String input = "";
        Boolean run = true;
        System.out.println("Hello! This is a car maintence management tool.");
        System.out.println("First, please select a vehicle to view maintence on.");
        myApp.readCSV("vehicles.csv");
        System.out.println(myApp.vehicles.get(0));
        while (run) {
            input = "";
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader buff = new BufferedReader(reader);

            try{
                input = buff.readLine();
            }
            catch (IOException e ){
                System.out.println(e);
            }
            switch(input){
                case "test": 
                    System.out.println("Worked!"); 
                    break;
                case "end":
                    System.out.println("Thanks!");
                    run=false;
                    break;
                case "menu":
                    System.out.println("This should be a sub menu!");
                    Boolean subMenu1 = true;
                    while (subMenu1){
                        input = "";
                        try{
                            input = buff.readLine();
                        }
                        catch (IOException e ){
                            System.out.println(e);
                        }
                        switch(input){
                            case "test": 
                                System.out.println("Worked!"); 
                                break;
                            case "end":
                                System.out.println("Thanks!");
                                subMenu1=false;
                                break;
                            default:
                                System.out.println("submenu1");
                    }
                }
                default:
                    System.out.println("Try typing test");
            }
        }
    }
}
//start with writing entries to csv
//infinite loop + maintence object probably
//infinite loop to read in + navigation objects